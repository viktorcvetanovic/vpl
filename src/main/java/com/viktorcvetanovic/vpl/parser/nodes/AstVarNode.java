package com.viktorcvetanovic.vpl.parser.nodes;

import com.viktorcvetanovic.vpl.lexer.token.Token;

public class AstVarNode extends AstNode{
    public AstIdentifierNode astIdentifierNode;


    public AstVarNode(Token token) {
        super(token);
    }


    @Override
    public String toString() {
        return "AstVarNode{" +
                "astIdentifierNode=" + astIdentifierNode +
                '}';
    }
}
