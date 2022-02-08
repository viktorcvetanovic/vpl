package com.viktorcvetanovic.vpl;

import com.viktorcvetanovic.vpl.lexer.Lexer;
import com.viktorcvetanovic.vpl.lexer.token.Token;
import com.viktorcvetanovic.vpl.parser.Parser;
import com.viktorcvetanovic.vpl.parser.nodes.TreeAstNode;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String text = "var b=5;";
        Lexer lexer = new Lexer(text);
        List<Token> tokenList = lexer.lex();
        tokenList.forEach(System.out::println);
        Parser parser = new Parser(tokenList);
        TreeAstNode treeAstNode = parser.parse();

    }
}
