package com.example.render;

public class Glyph {
    // Smell: style stored per instance → not memory efficient
    private final char ch;
    private final TextStyle textStyle;

    public Glyph(char ch, TextStyle textStyle) {
        this.ch = ch;
        this.textStyle = textStyle;
    }

    public TextStyle getTextStyle() {
        return textStyle;
    }

    public int drawCost() {
        return textStyle.getSize() + (textStyle.isBold() ? 10 : 0);
    }

    public char getCh() { return ch; }
}
