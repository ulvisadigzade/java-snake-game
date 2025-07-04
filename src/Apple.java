import java.util.Random;

public class Apple {
    private final Random random = new Random();

    private static final int boardHeight = Constants.BOARD_HEIGHT;
    private static final int boardWidth = Constants.BOARD_WIDTH;

    private int rowPos;
    private int colPos;

    public Apple(){
        rowPos = generateRowPos();
        colPos = generateColPos();
    }

    public int getRowPos(){
        return rowPos;
    }

    public int getColPos(){
        return colPos;
    }

    public int generateRowPos(){
        rowPos = random.nextInt(boardHeight-2) + 1;
        return rowPos;
    }

    public int generateColPos(){
        colPos = random.nextInt(boardWidth-2) + 1;
        return colPos;
    }

    public boolean hasEaten(int headRowPos, int headColPos){
        return headRowPos == rowPos && headColPos == colPos;
    }
}
