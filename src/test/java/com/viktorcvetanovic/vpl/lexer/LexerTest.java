package com.viktorcvetanovic.vpl.lexer;


import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LexerTest extends TestCase {

    @Test
    public void test_lexer() {
        Lexer lexer = new Lexer("viktor=5;");
        List<Token> token = lexer.lex();
        assertEquals(4,token.size());
        assertEquals(Token.createToken(TokenType.IDENTIFIER,"viktor"),token.get(0));
        assertEquals(Token.createToken(TokenType.ASS),token.get(1));
        assertEquals(Token.createToken(TokenType.INT_LITERAL,5),token.get(2));
        assertEquals(Token.createToken(TokenType.END),token.get(3));
    }

}