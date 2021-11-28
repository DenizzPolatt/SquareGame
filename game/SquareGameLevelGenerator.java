package game;

public class SquareGameLevelGenerator {
    private double upperLineY;
    private double lowerLineY;

    private double squareSize;
    private double squareY;
    private double squareSpeed;

    private int difficultyLevel;

    public SquareGameLevelGenerator(int difficultyLevel)
    {
        this.difficultyLevel = difficultyLevel;
    }

    public SquareGameState generateLevel()
    {
        setupSquare();
        setupLines(computeGap());
        setupSpeed();

        return new SquareGameState(
            upperLineY, lowerLineY, squareSize, squareY, squareSpeed);
    }

    private void setupSquare()
    {
        double sizeMax = 0.5;
        double sizeMin = 0.2;
        squareSize = Math.random() * (sizeMax-sizeMin) + sizeMin;
        
        squareY = -squareSize;
    }

    private double computeGap()
    {
        double gapBase = 1.0 / (10.0 + difficultyLevel);
        double gapMarginMin = squareSize + gapBase;
        double gapMarginMax = gapMarginMin + gapBase * 2;
        
        return Math.random() * (gapMarginMax-gapMarginMin) + (gapMarginMin);
    }

    private void setupLines(double gap)
    {
        double yBase = 9.0 / (10.0 + 0.3 * difficultyLevel);
        double yRandomizer = yBase + 0.1 * Math.random();
        upperLineY = yRandomizer - gap; 
        lowerLineY = upperLineY + gap;
    }

    private void setupSpeed()
    {
        double speedRandomizer = (1.0 + 0.1 * Math.random());
        double speedBase = 10.0;
        double speedMultiplier = 
            (speedBase + (0.5 * difficultyLevel)) 
            * speedRandomizer / speedBase;
        squareSpeed = 0.5 * speedMultiplier;
    }
}
