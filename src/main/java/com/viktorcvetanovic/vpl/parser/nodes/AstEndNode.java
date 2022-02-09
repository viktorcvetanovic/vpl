package com.viktorcvetanovic.vpl.parser.nodes;

import com.viktorcvetanovic.vpl.lexer.token.Token;

public class AstEndNode extends AstNode {

    public AstEndNode(Token token) {
        super(token);
    }

    @Override
    public String toString() {
        return "AstEndNode{" +
                "token=" + token +
                '}';
    }
}
