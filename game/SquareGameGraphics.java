package game;

import processing.core.PApplet;

public class SquareGameGraphics {
    SquareGame game;

    SquareGameGraphics(SquareGame game)
    {
        this.game = game;
    }

    private void drawHorizontalLine(PApplet applet, double y)
    {
        float scaledY = (float) y * applet.height;
        applet.strokeWeight(3);
        applet.line(
            0, 
            scaledY, 
            applet.width, 
            scaledY);
    }

    private void determineBackground(PApplet applet)
    {
        applet.background(255);
        if(!game.isRunning())
        {
            if(game.isWinningState())
                applet.background(0, 255, 0);
            else
                applet.background(255, 0, 0);
        }
    }

    private void drawSquare(PApplet applet)
    {
        int squareSize = (int) (game.getSquareSize() * applet.width);
        int squareX = (applet.width - squareSize) / 2;
        int squareY = (int) (game.getSquareY() * applet.height);

        applet.fill(128, 0, 128);
        applet.square(squareX, squareY, squareSize);
    }

    private void drawLevelInfo(PApplet applet)
    {
        int textMargin = (int) (applet.width * 0.030); 
        int textSize = (int) (applet.width * 0.06);
        applet.fill(0);
        applet.textSize(textSize);
        applet.text(
            "LEVEL: " + game.getLevel(), 
            textMargin, 
            textMargin + textSize / 2);
    }

    public void draw(PApplet applet)
    {
        determineBackground(applet);

        drawHorizontalLine(applet, game.getUpperLineY());
        drawHorizontalLine(applet, game.getLowerLineY());
        
        drawSquare(applet);

        drawLevelInfo(applet);
    }
}
