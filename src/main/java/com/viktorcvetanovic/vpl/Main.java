package com.viktorcvetanovic.vpl;

import com.viktorcvetanovic.vpl.lexer.Lexer;
import com.viktorcvetanovic.vpl.lexer.token.Token;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String text = "if (a==0){System.out.println(a,b,c);}";
        Lexer lexer = new Lexer(text);
        List<Token> tokenList = lexer.lex();
        tokenList.forEach(System.out::println);

    }
}
