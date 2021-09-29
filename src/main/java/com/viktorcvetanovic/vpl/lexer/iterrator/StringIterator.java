package com.viktorcvetanovic.vpl.lexer.iterrator;

import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.function.Predicate;

public class StringIterator implements Iterator<String> {
    private final String text;
    private int i = 0;

    public StringIterator(String text) {
        this.text = text;
    }

    public boolean hasNext() {
    return i < text.length() - 1;
    }

    public String next() {
        return String.valueOf(text.charAt(i++));
    }

    public String peek() {
        return String.valueOf(text.charAt(i));
    }

    public void remove() {

    }

    public String eatWhile(Predicate<String> predicate) {
        StringBuilder stringBuilder = new StringBuilder();
        while (predicate.test(peek()) && hasNext()) {
            stringBuilder.append(next());
        }
        return stringBuilder.toString();
    }

    public String eatWhiteSpace() {
        return eatWhile(String::isBlank);
    }
}
