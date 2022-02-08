package com.viktorcvetanovic.vpl.parser;

import com.viktorcvetanovic.vpl.iterrator.TokenIterator;
import com.viktorcvetanovic.vpl.lexer.token.Token;
import com.viktorcvetanovic.vpl.lexer.token.TokenType;
import com.viktorcvetanovic.vpl.parser.nodes.*;

import java.util.ArrayList;
import java.util.List;

public class Parser extends TokenIterator {

    public Parser(List<Token> tokenList) {
        super(tokenList);
    }

    public TreeAstNode parse() {
        List<AstNode> list = new ArrayList<>();
        while (hasNext()) {
            AstNode node = parseStatement();
            list.add(node);
        }
        System.out.println(list);

        return null;
    }


    private AstNode parseStatement() {
        AstNode node = null;
        if (peek().tokenType == TokenType.IF) {

        } else if (peek().tokenType == TokenType.FOR) {

        } else if (peek().tokenType == TokenType.WHILE) {

        } else {
            node = parseExpression();
        }
        return node;
    }

    private AstNode parseExpression() {
        AstNode current = fromToken(next());
        AstNode node = null;
        if (peek().tokenType == TokenType.ASS) {
            if (!current.isTokenEqual(TokenType.IDENTIFIER)) {
                throw new RuntimeException("Sintaksna greska");
            }
            node = parseAssignment(current);
        } else {
            node = fromToken(current.token);
        }

        return node;
    }

    private AstNode parseAssignment(AstNode current) {
        AstAssignmentNode astAssignmentNode = null;
        if (peek().tokenType == TokenType.ASS) {
            astAssignmentNode = (AstAssignmentNode) fromToken(peek());
            //we skip next because it is assignment token
            next();
        }
        astAssignmentNode.left = current;
        astAssignmentNode.right = parseExpression();

        return astAssignmentNode;
    }


    private AstNode fromToken(Token t) {
        TokenType tokenType = t.tokenType;
        switch (tokenType) {
            case VAR:
                return new AstVarNode(t);
            case IF:
            case STR_LITERAL:
            case FLO_LITERAL:
            case NULL_LITERAL:
            case INT_LITERAL:
                return new AstLiteralNode(t);
            case ELSE:
            case ELIF:
            case FOR:
            case WHILE:
            case BREAK:
            case TRUE:
            case FALSE:
            case END:
            case EQ:
            case NE:
            case NOT:
            case GT:
            case LT:
            case LE:
            case GE:
            case AND:
            case OR:
            case L_BRACK:
            case R_BRACK:
            case L_PAREN:
            case R_PAREN:
            case PLUS:
            case MINUS:
            case MOD:
            case DIV:
            case MUL:
            case DUCA500:
            case ASS:
                return new AstAssignmentNode(t);
            case CONTINUE:
            case DOT:
            case RETURN:
            case COMMA:
            case IDENTIFIER:
                return new AstIdentifierNode(t);
            default:
                throw new RuntimeException("Ne postoji ovakav token =" + t);
        }

    }
}
