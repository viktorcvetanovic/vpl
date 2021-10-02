package com.viktorcvetanovic.vpl.parser;

import com.viktorcvetanovic.vpl.lexer.iterrator.TokenIterator;
import com.viktorcvetanovic.vpl.lexer.token.Token;

import java.util.List;

public class Parser extends TokenIterator {

    public Parser(List<Token> tokenList) {
        super(tokenList);
    }


}
