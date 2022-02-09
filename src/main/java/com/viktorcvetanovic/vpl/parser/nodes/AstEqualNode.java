package com.viktorcvetanovic.vpl.parser.nodes;

import com.viktorcvetanovic.vpl.lexer.token.Token;

public class AstEqualNode extends AstNode {
    public AstNode left;
    public AstNode right;


    public AstEqualNode(Token token) {
        super(token);
    }

    public AstEqualNode(Token token, AstNode left, AstNode right) {
        super(token);
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "AstEqualNode{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
