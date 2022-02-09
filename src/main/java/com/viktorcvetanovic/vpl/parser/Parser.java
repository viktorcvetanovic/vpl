package com.viktorcvetanovic.vpl.parser;

import com.viktorcvetanovic.vpl.exception.VPLInvalidSyntax;
import com.viktorcvetanovic.vpl.iterrator.TokenIterator;
import com.viktorcvetanovic.vpl.lexer.token.Token;
import com.viktorcvetanovic.vpl.lexer.token.TokenType;
import com.viktorcvetanovic.vpl.parser.nodes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Parser extends TokenIterator {

    Stack<AstNode> stack = new Stack<>();

    public Parser(List<Token> tokenList) {
        super(tokenList);
    }

    public TreeAstNode parse() {
        List<AstNode> list = new ArrayList<>();
        while (hasNext()) {
            AstNode node = parseStatement();
            list.add(node);
        }
        return new TreeAstNode(list);
    }


    private AstNode parseStatement() {
        AstNode node = null;
        if (peek().tokenType == TokenType.IF) {
            node = parseIf();
        } else if (peek().tokenType == TokenType.FOR) {

        } else if (peek().tokenType == TokenType.WHILE) {

        } else if (peek().tokenType == TokenType.VAR) {
            node = parseVar();
        } else {
            node = parseExpression();
        }
        return node;
    }

    private AstNode parseIf() {
        AstNode current = fromToken(next());
        AstIfNode astIfNode = (AstIfNode) current;
        if (peek().tokenType != TokenType.L_PAREN) {
            throw new VPLInvalidSyntax("Expected token L_PAREN");
        }
        next();
        AstNode node = parseExpression();
        if (peek().tokenType != TokenType.R_PAREN) {
            throw new VPLInvalidSyntax("Expected token R_PAREN");
        }
        next();
        astIfNode.expression = node;

        astIfNode.left = parseBlockNode();
        if (isPeekOfType(TokenType.ELIF)) {
            astIfNode.right=parseIf();
        }else if(isPeekOfType(TokenType.ELSE)){
            astIfNode.right=parseElseNode();
        }
        return astIfNode;
    }


    private AstNode parseElseNode(){
        AstNode current = fromToken(next());
        AstElseNode astElseNode = (AstElseNode) current;
        astElseNode.block=parseBlockNode();
        return astElseNode;
    }

    private AstBlockNode parseBlockNode() {
        if (peek().tokenType != TokenType.L_BRACK) {
            throw new VPLInvalidSyntax("Expected token L_BRACK");
        }
        AstBlockNode astBlockNode = (AstBlockNode) fromToken(next());
        while (peek().tokenType != TokenType.R_BRACK) {
            astBlockNode.list.add(parseExpression());
        }
        if (peek().tokenType != TokenType.R_BRACK) {
            throw new VPLInvalidSyntax("Expected token R_BRACK");
        }
        next();
        return astBlockNode;
    }

    private AstNode parseVar() {
        AstNode current = fromToken(next());
        if (peek().tokenType != TokenType.IDENTIFIER) {
            throw new VPLInvalidSyntax("Expected token identifier");
        }
        AstVarNode astVarNode = (AstVarNode) current;
        astVarNode.astIdentifierNode = (AstIdentifierNode) fromToken(next());
        AstNode astAssignmentNode = parseAssignment(astVarNode);

        return astAssignmentNode;
    }

    private AstNode parseExpression() {
        AstNode current = fromToken(next());
        AstNode node = null;
        if (isPeekOfType(TokenType.EQ)) {
            node = parseEqual(current);
        } else if (isPeekOfType(TokenType.ASS)) {
            node = parseAssignment(current);
        }  else {
            return current;
        }

        return node;
    }


    //----------------------------------------------------------------------//

    private AstNode parseAssignment(AstNode current) {
        AstAssignmentNode astAssignmentNode = null;
        if (peek().tokenType == TokenType.ASS) {
            astAssignmentNode = (AstAssignmentNode) fromToken(next());
        }
        astAssignmentNode.left = current;
        astAssignmentNode.right = parseExpression();
        if (peek().tokenType != TokenType.END) {
            throw new VPLInvalidSyntax("Expected token END " + peek());
        }
        next();
        return astAssignmentNode;
    }

    private AstNode parseEqual(AstNode current) {
        AstEqualNode astEqualNode = null;
        if (peek().tokenType == TokenType.EQ) {
            astEqualNode = (AstEqualNode) fromToken(peek());
            next();
        }
        astEqualNode.left = current;
        astEqualNode.right = parseExpression();
        return astEqualNode;
    }


    private AstNode fromToken(Token t) {
        TokenType tokenType = t.tokenType;
        switch (tokenType) {
            case VAR:
                return new AstVarNode(t);
            case IF:
            case ELIF:
                return new AstIfNode(t);
            case STR_LITERAL:
            case FLO_LITERAL:
            case NULL_LITERAL:
            case INT_LITERAL:
                return new AstLiteralNode(t);
            case ELSE:
                return new AstElseNode(t);
            case FOR:
            case WHILE:
            case BREAK:
            case TRUE:
            case FALSE:
            case END:
                return new AstEndNode(t);
            case EQ:
                return new AstEqualNode(t);
            case NE:
            case NOT:
            case GT:
            case LT:
            case LE:
            case GE:
            case AND:
            case OR:
            case L_BRACK:
                return new AstBlockNode(t);
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
