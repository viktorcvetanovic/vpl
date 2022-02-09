package com.viktorcvetanovic.vpl.iterrator;

import com.viktorcvetanovic.vpl.lexer.token.Token;
import com.viktorcvetanovic.vpl.lexer.token.TokenType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class TokenIterator implements Iterator<Token> {
    private List<Token> tokenList;
    private int i = 0;

    public TokenIterator(List<Token> tokenList) {
        this.tokenList = tokenList;
    }


    @Override
    public boolean hasNext() {
        return i < tokenList.size() ;
    }

    @Override
    public Token next() {
        return tokenList.get(i++);
    }

    public Token peek() {
        return tokenList.get(i);
    }

    public List<Token> eatWhile(Predicate<Token> predicate) {
        List<Token> list = new ArrayList<>();
        while (hasNext() && predicate.test(peek())) {
            list.add(next());
        }
        return list;
    }

    public boolean isPeekOfType(TokenType token, TokenType ... tokens){
        List<TokenType> tokenList=new ArrayList<>();
        tokenList.add(token);
        tokenList.addAll(Arrays.asList(tokens));
        return hasNext() && tokenList.contains(peek().tokenType);
    }
}
