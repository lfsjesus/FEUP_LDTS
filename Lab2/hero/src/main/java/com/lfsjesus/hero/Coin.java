package com.lfsjesus.hero;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Coin  extends Element{
    public Coin(int x, int y) {
        super(x,y);
    }
    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF00"));
        graphics.setBackgroundColor(TextColor.Factory.fromString("#6495ED"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "€");
    }



}
