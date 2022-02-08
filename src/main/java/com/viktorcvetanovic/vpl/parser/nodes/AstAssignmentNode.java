package com.viktorcvetanovic.vpl.parser.nodes;

import com.viktorcvetanovic.vpl.lexer.token.Token;

public class AstAssignmentNode extends AstNode {
    public AstNode left;
    public AstNode right;

    public AstAssignmentNode(Token token) {
        super(token);
    }

    @Override
    public String toString() {
        return "AstAssignmentNode{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
