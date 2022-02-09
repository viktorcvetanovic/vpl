package com.viktorcvetanovic.vpl.parser.nodes;

import com.viktorcvetanovic.vpl.lexer.token.Token;

public class AstElseNode extends AstNode{
    public AstNode block;

    public AstElseNode(Token token) {
        super(token);
    }




    @Override
    public String toString() {
        return "AstElseNode{" +
                "block=" + block +
                '}';
    }
}
