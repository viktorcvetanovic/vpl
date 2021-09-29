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
            next();
        }
        return tokens;
    }

    // viktor=5; if(viktor>5){}
    private Token parseToken() {

        if (isIdentifierOrExpression()) {
            String ideOrExp = eatIdentifierOrExpression();
            TokenType tokenType = getOrDefaultTokenType(ideOrExp, TokenType.IDENTIFIER);
            return Token.createToken(tokenType, ideOrExp);
        }



        return null;
    }


    private boolean isIdentifierOrExpression() {
        char[] chars = peek().toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    private String eatIdentifierOrExpression() {
        return eatWhile(e -> isIdentifierOrExpression());
    }


    private Token createTokenFromParsedString(String parsed) {
        switch (parsed) {
            case "+":
                return Token.createToken(TokenType.PLUS);

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
