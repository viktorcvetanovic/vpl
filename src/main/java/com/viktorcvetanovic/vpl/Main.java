package com.viktorcvetanovic.vpl;

import com.viktorcvetanovic.vpl.lexer.Lexer;
import com.viktorcvetanovic.vpl.lexer.Token;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String text = " viktor=car";
        Lexer lexer = new Lexer(text);
        List<Token> tokenList = lexer.lex();
        System.out.println(tokenList);

    }
}
