package com.viktorcvetanovic.vpl.lexer;

public class Token {
    public TokenType tokenType;
    public String value;

    public Token(TokenType tokenType, String value) {
        this.tokenType = tokenType;
        this.value = value;
    }

    public Token(TokenType tokenType) {
        this.tokenType = tokenType;
    }
}
