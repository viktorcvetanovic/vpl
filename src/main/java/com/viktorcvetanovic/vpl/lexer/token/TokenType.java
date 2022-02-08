package com.viktorcvetanovic.vpl.lexer.token;

public enum TokenType {
    VAR("var"),
    IF("if"),
    ELSE("else"),
    ELIF("elif"),
    FOR("for"),
    WHILE("while"),
    BREAK("break"),
    TRUE("true"),
    FALSE("false"),
    END(";"),
    EQ("=="),
    NE("!="),
    NOT("!"),
    GT(">"),
    LT("<"),
    LE("<="),
    GE(">="),
    AND("&&"),
    OR("||"),
    L_BRACK("{"),
    R_BRACK("}"),
    L_PAREN("("),
    R_PAREN(")"),
    PLUS("+"),
    MINUS("-"),
    MOD("%"),
    DIV("/"),
    MUL("*"),
    DUCA500("duca500"),
    ASS("="),
    CONTINUE(""),
    STR_LITERAL(null),
    FLO_LITERAL(null),
    NULL_LITERAL("null"),
    INT_LITERAL(null),
    DOT("."),
    RETURN ("return"),
    COMMA(","),
    IDENTIFIER(null);


    public final String label;

    private TokenType(String label) {
        this.label = label;
    }
    }


