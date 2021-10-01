package com.viktorcvetanovic.vpl.lexer;

import com.viktorcvetanovic.vpl.lexer.iterrator.StringIterator;

import java.util.ArrayList;
import java.util.List;

public class Lexer extends StringIterator {

    public Lexer(String text) {
        super(text);
    }

    public List<Token> lex() {
        List<Token> tokens = new ArrayList<>();
        while (hasNext()) {
            eatWhiteSpace();
            Token token = parseToken();
            tokens.add(token);
        }
        return tokens;
    }

    private Token parseToken() {

        if (isStartOfIdeOrKw()) {
            String ideOrExp = eatIdeOrKw();
            TokenType tokenType = getOrDefaultTokenType(ideOrExp, TokenType.IDENTIFIER);
            return Token.createToken(tokenType, ideOrExp);
        }

        if (isStringLiteral()) {
            String strLit = eatStringLiteral();
            Token token = Token.createToken(TokenType.STR_LITERAL, strLit);
            return token;
        }

        if (isIntegerOrFloatLiteral()) {
            Object number = eatIntegerOrFloat();
            Token token = null;
            if (number instanceof Integer) {
                token = Token.createToken(TokenType.INT_LITERAL, number);
            } else if (number instanceof Float) {
                token = Token.createToken(TokenType.FLO_LITERAL, number);
            }
            return token;
        }


        return parseOperator();
    }

    private Object eatIntegerOrFloat() {
        String s = eatWhile(e -> e.matches("[0-9.]"));
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException ex) {
            return Float.parseFloat(s);
        }
    }

    private String eatStringLiteral() {
        next();
        String s = eatWhile(e -> !e.matches("\""));
        if (!hasNext() || !peek().equals("\"")) {
            throw new RuntimeException("OVDE SAM PUKO"+i);
        }
        next();
        return s;
    }

    private boolean isStringLiteral() {
        return peek().matches("\"");
    }

    private boolean isIntegerOrFloatLiteral() {
        return peek().matches("[0-9]");
    }

    private boolean isStartOfIdeOrKw() {
        return peek().matches("[a-zA-Z_]");
    }

    private String eatIdeOrKw() {
        return eatWhile(e -> e.matches("[a-zA-Z_]"));
    }


    private Token parseOperator() {
        switch (next()) {
            case "+":
                return Token.createToken(TokenType.PLUS);
            case "=":
                return Token.createToken(TokenType.ASS);
            case "*":
                return Token.createToken(TokenType.MUL);
            case "/":
                return Token.createToken(TokenType.DIV);
            case ";":
                return Token.createToken(TokenType.END);
            case "-":
                return Token.createToken(TokenType.MINUS);
            case "%":
                return Token.createToken(TokenType.MOD);
            case "!":
                return Token.createToken(TokenType.NOT);
            case ">":
                return Token.createToken(TokenType.GT);
            case "<":
                return Token.createToken(TokenType.LT);
            case "}":
                return Token.createToken(TokenType.R_BRACK);
            case "{":
                return Token.createToken(TokenType.L_BRACK);
            case "(":
                return Token.createToken(TokenType.L_PAREN);
            case ")":
                return Token.createToken(TokenType.R_PAREN);
        }
        return null;
    }


    private TokenType getOrDefaultTokenType(String val, TokenType val1) {
        try {
            return TokenType.valueOf(val);
        } catch (Exception ex) {
            return val1;
        }
    }
}
