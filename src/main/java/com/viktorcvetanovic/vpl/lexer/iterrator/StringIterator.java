package com.viktorcvetanovic.vpl.lexer.iterrator;

import java.util.Iterator;
import java.util.function.Predicate;

public class StringIterator implements Iterator<String> {
    private final String text;
    protected int i = 0;

    public StringIterator(String text) {
        this.text = text;
    }

    public boolean hasNext() {
        return i < text.length();
    }

    public String next() {
        return String.valueOf(text.charAt(i++));
    }

    public String peek() {
        return String.valueOf(text.charAt(i));
    }


    public String eatWhile(Predicate<String> predicate) {
        StringBuilder stringBuilder = new StringBuilder();
        while (hasNext() && predicate.test(peek())) {
            stringBuilder.append(next());
        }
        return stringBuilder.toString();
    }

    public String eatWhiteSpace() {
        return eatWhile(String::isBlank);
    }
}
