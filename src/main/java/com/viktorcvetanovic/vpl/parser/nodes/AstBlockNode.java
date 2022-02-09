package com.viktorcvetanovic.vpl.parser.nodes;

import com.viktorcvetanovic.vpl.lexer.token.Token;

import java.util.ArrayList;
import java.util.List;

public class AstBlockNode extends AstNode {
    public List<AstNode> list = new ArrayList<>();

    public AstBlockNode(Token token) {
        super(token);
    }

    @Override
    public String toString() {
        return "AstBlockNode{" +
                "list=" + list +
                '}';
    }
}
