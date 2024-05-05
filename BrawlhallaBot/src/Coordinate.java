import java.awt.*;

public class Coordinate {
    public int x;
    public int y;

    public int getColor() {
        return color;
    }

    public int color;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordinate(int x, int y, int color, GameState gameState) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.gameState = gameState;
    }

    public GameState gameState;
}
