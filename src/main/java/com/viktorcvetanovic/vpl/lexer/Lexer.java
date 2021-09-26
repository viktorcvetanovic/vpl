package com.viktorcvetanovic.vpl.lexer;

import com.viktorcvetanovic.vpl.lexer.iterrator.StringIterator;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private final StringIterator iter;

    public Lexer(String text) {
        iter = new StringIterator(text);
    }

    public List<Token> lex() {
        List<Token> tokens = new ArrayList<>();
        while (iter.hasNext()) {
            iter.eatWhiteSpace();
            String val = iter.next();
            Token token = readToken(val);
            if (token != null) {
                tokens.add(token);
            }
        }
        return tokens;
    }

    private Token readToken(String value) {
        switch (value) {
            case "if":
                return new Token(TokenType.IF);
            default:
                return null;
        }
    }

}
