package com.viktorcvetanovic.vpl;

import com.viktorcvetanovic.vpl.lexer.Lexer;
import com.viktorcvetanovic.vpl.lexer.token.Token;
import com.viktorcvetanovic.vpl.parser.Parser;
import com.viktorcvetanovic.vpl.parser.nodes.TreeAstNode;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String text = "var a=5;" +
                "if(a==5){a=6;b=5;c=3;}" +
                "elif(a==3){m=5;}" +
                "elif(o==1){m=2.2;}" +
                "else{a=2;}";
        Lexer lexer = new Lexer(text);
        List<Token> tokenList = lexer.lex();
//        tokenList.forEach(System.out::println);
        Parser parser = new Parser(tokenList);
        TreeAstNode treeAstNode = parser.parse();
        System.out.println(treeAstNode);
    }
}
