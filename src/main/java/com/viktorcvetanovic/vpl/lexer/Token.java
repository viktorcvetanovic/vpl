package com.viktorcvetanovic.vpl.lexer;

public class Token {
    public TokenType tokenType;
    public Object value;

    public Token(TokenType tokenType, Object value) {
        this.tokenType = tokenType;
        this.value = value;
    }

    public Token(TokenType tokenType) {
        this.tokenType = tokenType;
    }

    public static Token createToken(TokenType tokenType, Object value) {
        return new Token(tokenType, value);
    }


    public static Token createToken(TokenType tokenType) {
        return new Token(tokenType);
    }

    public Token() {

    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public void setTokenType(TokenType tokenType) {
        this.tokenType = tokenType;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Token{" +
                "tokenType=" + tokenType +
                ", value='" + value + '\'' +
                '}';
    }
}
