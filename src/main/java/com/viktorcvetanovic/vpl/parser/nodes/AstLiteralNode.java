package com.viktorcvetanovic.vpl.parser.nodes;

import com.viktorcvetanovic.vpl.lexer.token.Token;

public class AstLiteralNode extends AstNode{

    public AstLiteralNode(Token token) {
        super(token);
    }
}
