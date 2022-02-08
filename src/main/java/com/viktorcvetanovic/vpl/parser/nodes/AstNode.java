package com.viktorcvetanovic.vpl.parser.nodes;

import com.viktorcvetanovic.vpl.lexer.token.Token;
import com.viktorcvetanovic.vpl.lexer.token.TokenType;

public abstract class AstNode {
    public Token token;

    public AstNode(Token token) {
        this.token = token;
    }

    public boolean isTokenEqual(TokenType tokenType) {
        return this.token.tokenType == tokenType;
    }

    @Override
    public String toString() {
        return "AstNode{" +
                "token=" + token +
                '}';
    }
}
