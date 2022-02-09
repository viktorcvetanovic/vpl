package com.viktorcvetanovic.vpl.parser.nodes;

import com.viktorcvetanovic.vpl.lexer.token.Token;

public class AstIfNode extends AstNode{
    public AstNode expression;
    public AstNode left;
    public AstNode right;

    public AstIfNode(Token token) {
        super(token);
    }

    public AstIfNode(Token token, AstNode expression) {
        super(token);
        this.expression = expression;
    }

    public AstIfNode(Token token, AstNode expression, AstNode left, AstNode right) {
        super(token);
        this.expression = expression;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "AstIfNode{" +
                "expression=" + expression +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
