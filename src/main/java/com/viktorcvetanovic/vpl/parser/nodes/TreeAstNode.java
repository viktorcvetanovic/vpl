package com.viktorcvetanovic.vpl.parser.nodes;

import java.util.List;

public class TreeAstNode {
    private List<AstNode> root;

    public TreeAstNode(List<AstNode> root) {
        this.root = root;
    }

    public List<AstNode> getRoot() {
        return root;
    }

    @Override
    public String toString() {
        return "TreeAstNode{" +
                "root=" + root +
                '}';
    }
}
