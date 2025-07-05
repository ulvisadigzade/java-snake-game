import java.util.ArrayList;

public class Snake {
    private final int boardHeight = Constants.BOARD_HEIGHT;
    private final int boardWidth = Constants.BOARD_WIDTH;
    private final int initialRow = Constants.INITIAL_SNAKE_ROW;
    private final int initialCol = Constants.INITIAL_SNAKE_COL;

    private Direction currentDirection = Direction.LEFT;
    private ArrayList<int[]> snakeBody = new ArrayList<>();


    public Snake(){
        snakeBody.add(new int[]{initialRow, initialCol});
        snakeBody.add(new int[]{initialRow, initialCol+1});
    }

    public void move() {
        for(int i = snakeBody.size() - 1; i > 0; i--){
            var elem1 = snakeBody.get(i-1);
            snakeBody.set(i,elem1);
        }

        var snakeHead = snakeBody.get(0);
        int newHeadRowPos = snakeHead[0] + currentDirection.deltaI;
        int newHeadColPos = snakeHead[1] + currentDirection.deltaJ;
        snakeBody.set(0,new int[]{newHeadRowPos, newHeadColPos});

    }

    public void updateDirection(Direction newDirection){
        if(newDirection != Direction.NO_DIRECTION && newDirection != currentDirection.opposite())currentDirection = newDirection;
    }

    public boolean hasEaten(Apple apple){
        int headRowPos = snakeBody.get(0)[0];
        int headColPos = snakeBody.get(0)[1];

        return headRowPos==apple.getRowPos() && headColPos==apple.getColPos();
    }

    public boolean hasLost(){
        var head = snakeBody.get(0);

        if(head[1]==0 || head[1]== boardWidth -1 || head[0]==0 || head[0]== boardHeight -1){
            return true;
        }

        for(int i = 1; i< snakeBody.size(); i++){
            var snakeIthPart = snakeBody.get(i);
            if(head[0]== snakeIthPart[0] && head[1]== snakeIthPart[1]){
                return true;
            }
        }
        return false;
    }

    public void addTail(){
        var snakeTail = snakeBody.get(snakeBody.size()-1);

        int newTailRowPos = snakeTail[0] - currentDirection.deltaI;
        int newTailColPos = snakeTail[1] - currentDirection.deltaJ;

        snakeBody.add(new int[] {newTailRowPos, newTailColPos});
    }

    public boolean contains(int i, int j){
        for(int[] part: snakeBody){
            if(part[0]==i && part[1]==j)return true;
        }
        return false;
    }
}
