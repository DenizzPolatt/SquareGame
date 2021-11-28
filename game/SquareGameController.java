package game;

public class SquareGameController {
    SquareGame game;
    boolean mouseReleased;

    SquareGameController(SquareGame game)
    {
        this.game = game;
        mouseReleased = true;
    }

    public void update(boolean keyPressed)
    {
        boolean mouseHit = mouseReleased && keyPressed;
        
        if(mouseHit)
        {
            if(game.isRunning())
            {
                game.stop();
            }
            else if(game.isWinningState())
            {
                game.generateNextLevel();
                game.start();
            }
        }

        mouseReleased = !keyPressed;
    }
}
