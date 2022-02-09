package com.viktorcvetanovic.vpl.parser;

import com.viktorcvetanovic.vpl.lexer.Lexer;
import com.viktorcvetanovic.vpl.lexer.token.Token;
import com.viktorcvetanovic.vpl.lexer.token.TokenType;
import com.viktorcvetanovic.vpl.parser.nodes.AstAssignmentNode;
import com.viktorcvetanovic.vpl.parser.nodes.AstLiteralNode;
import com.viktorcvetanovic.vpl.parser.nodes.AstVarNode;
import com.viktorcvetanovic.vpl.parser.nodes.TreeAstNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    @Test
    public void test_parser_var(){
        String s="var a=5;";
        Lexer lexer = new Lexer(s);
        List<Token> tokenList = lexer.lex();
        Parser parser = new Parser(tokenList);
        TreeAstNode treeAstNode = parser.parse();
        AstAssignmentNode astAssignmentNode= (AstAssignmentNode) treeAstNode.getRoot().get(0);
        AstVarNode astVarNode= (AstVarNode) astAssignmentNode.left;
        AstLiteralNode astLiteralNode= (AstLiteralNode) astAssignmentNode.right;
        assertEquals(TokenType.ASS,astAssignmentNode.token.tokenType);
        assertEquals(TokenType.VAR,astVarNode.token.tokenType);
        assertEquals(TokenType.IDENTIFIER,astVarNode.astIdentifierNode.token.tokenType);
        assertEquals(TokenType.INT_LITERAL,astLiteralNode.token.tokenType);
        assertEquals(5,astLiteralNode.token.value);
        System.out.println(treeAstNode);
    }

    @Test
    public void test_parser_if(){
        String s="var a=5;if(a==4){a=3;}elif(a==3){}else{}";
        Lexer lexer = new Lexer(s);
        List<Token> tokenList = lexer.lex();
        Parser parser = new Parser(tokenList);
        TreeAstNode treeAstNode = parser.parse();
        System.out.println(treeAstNode);
    }


}
