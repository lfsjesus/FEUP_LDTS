package com.lfsjesus.hero;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    Hero hero = new Hero(10, 10);

   public Game(int col, int row) throws IOException {
       TerminalSize terminalSize = new TerminalSize(col, row);
       DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
       Terminal terminal = terminalFactory.createTerminal();
       screen = new TerminalScreen(terminal);
       screen.setCursorPosition(null); // we don't need a cursor
       screen.startScreen(); // screens must be started
       screen.doResizeIfNecessary(); // resize screen if necessary

    }

    public void draw() throws IOException {
        screen.clear();
        hero.draw(screen);
        screen.refresh();
    }

    public void run() throws IOException {
       while (true) {
           draw();
           KeyStroke key = screen.readInput();
           if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
                screen.close();
           }
           if (key.getKeyType() == KeyType.EOF) {
               break;
           }
           processKey(key);
       }
    }

    private void moveHero (Position position) {
        hero.setPosition(position);
    }
    private void processKey(KeyStroke key) {
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


}
