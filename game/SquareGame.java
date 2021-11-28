package game;

public class SquareGame {
    private SquareGameState gameState;
    private SquareGameLevelGenerator generator;

    private int difficultyLevel;
    private boolean gameIsRunning;

    SquareGame()
    {
        difficultyLevel = 0;
        generateNextLevel();
        start();
    }

    public void generateNextLevel()
    {
        generator = new SquareGameLevelGenerator(difficultyLevel);
        gameState = generator.generateLevel();
        difficultyLevel++;
    }

    public boolean isRunning()
    {
        return gameIsRunning;
    }

    public void start()
    {
        gameIsRunning = true;
    }

    public void stop()
    {
        gameIsRunning = false;
    }

    public void update(double seconds)
    {
        if(gameIsRunning)
            gameState.squareY += gameState.squareSpeed * seconds;
    }

    public boolean isWinningState()
    {
        return 
            gameState.squareY >= gameState.upperLineY && 
            (gameState.squareY + gameState.squareSize) <= gameState.lowerLineY;
    }

    public double getUpperLineY()
    {
        return gameState.upperLineY;
    }
    
    public double getLowerLineY()
    {
        return gameState.lowerLineY;
    }

    public double getSquareSize()
    {
        return gameState.squareSize;
    }

    public double getSquareY()
    {
        return gameState.squareY;
    }

    public int getLevel()
    {
        return difficultyLevel;
    }

}
