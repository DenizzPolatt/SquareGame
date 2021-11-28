package game;

import processing.core.PApplet;

public class SquareGameApplet extends PApplet {
    int previousMs;
    SquareGame game;
    SquareGameGraphics gameGraphics;
    SquareGameController gameController;

    @Override
    public void settings()
    {
        size(800, 800);
    }

    @Override
    public void setup()
    {
        game = new SquareGame();
        gameGraphics = new SquareGameGraphics(game);
        gameController = new SquareGameController(game);
        previousMs = millis();
    }

    @Override
    public void draw()
    {
        int deltaMs = millis() - previousMs;

        gameGraphics.draw(this);
        gameController.update(keyPressed);
        game.update(deltaMs / 1e3);
        
        previousMs = millis();
    }
    
}
