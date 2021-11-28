package game;

public class SquareGameState {
    public double upperLineY;
    public double lowerLineY;
    public double squareSize;
    public double squareY;
    public double squareSpeed;
    
    SquareGameState(
        double upperLineY,
        double lowerLineY,
        double squareSize,
        double squareY,
        double squareSpeed)
    {
        this.upperLineY = upperLineY;
        this.lowerLineY = lowerLineY;
        this.squareSize = squareSize;
        this.squareY = squareY;
        this.squareSpeed = squareSpeed;
    }
}
