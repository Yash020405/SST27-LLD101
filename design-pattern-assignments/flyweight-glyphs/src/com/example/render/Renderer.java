package com.example.render;

public class Renderer {
    private final TextStyleFactory textStyleFactory = new TextStyleFactory();

    public int render(String text) {
        int cost = 0;
        for (char c : text.toCharArray()) {
            Glyph g = new Glyph(c, textStyleFactory.getTextStyle("Inter", 14, (c % 7 == 0)));
            cost += g.drawCost();
        }
        return cost;
    }
}
