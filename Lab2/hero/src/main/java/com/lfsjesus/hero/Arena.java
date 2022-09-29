package com.lfsjesus.hero;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private Hero hero;
    private int width;
    private int height;
    private List<Wall> walls;
    public Arena (int width, int height) {
        this.width = width;
        this.height = height;
        hero = new Hero (width / 2, height / 2);
        this.walls = createWalls();
    }

    public Hero getHero() {
        return hero;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    private void moveHero (Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }

    public void processKey(KeyStroke key) {
        switch(key.getKeyType()) {
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
        }
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#01579b"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);

        for (Wall wall : walls)
            wall.draw(graphics);

    }

    public boolean canHeroMove(Position position) {
        if (position.getX() > width - 1 || position.getX() < 0 || position.getY() > height - 1 || position.getY() < 0) return false;

        for (Wall wall : walls) {
            if (wall.getPosition().getX() == position.getX() && wall.getPosition().getY() == position.getY())
                return false;
        }

        return true;
    }

    private  List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0 ; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r  = 1; r < height - 1 ; r++) {
            walls.add(new Wall(0 ,r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }

}
