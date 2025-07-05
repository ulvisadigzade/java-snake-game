import java.util.Random;

public class Apple {
    private final Random random = new Random();

    private static final int boardHeight = Constants.BOARD_HEIGHT;
    private static final int boardWidth = Constants.BOARD_WIDTH;
    private static final int borderOffset = Constants.BORDER_OFFSET;

    private int rowPos;
    private int colPos;

    public Apple(){
        generateNewPosition();
    }

    public int getRowPos(){
        return rowPos;
    }

    public int getColPos(){
        return colPos;
    }

    public void generateNewPosition(){
        rowPos = random.nextInt(boardHeight- 2 * borderOffset) + borderOffset;
        colPos = random.nextInt(boardWidth- 2 * borderOffset) + borderOffset;

    }

    public boolean hasEaten(int headRowPos, int headColPos){
        return headRowPos == rowPos && headColPos == colPos;
    }
}
