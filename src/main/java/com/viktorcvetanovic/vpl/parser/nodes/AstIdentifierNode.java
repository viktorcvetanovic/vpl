package com.viktorcvetanovic.vpl.parser.nodes;

import com.viktorcvetanovic.vpl.lexer.token.Token;

public class AstIdentifierNode extends  AstNode{
    private AstNode varNode;

    public AstIdentifierNode(Token token, AstNode varNode) {
        super(token);
        this.varNode = varNode;
    }

    public AstIdentifierNode(Token token) {
        super(token);
    }
}
