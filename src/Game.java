public class Game {
    private  int boardHeight = Constants.BOARD_HEIGHT;
    private  int boardWidth = Constants.BOARD_WIDTH;



    private Board board = new Board();
    private GameInput gameInput = new GameInput();
    private Snake snake = new Snake();
    private Apple apple = new Apple();

    private boolean isRunning = true;


    public void start(){
        while(isRunning){
            board.clear();
            board.print(snake, apple);
            char button = gameInput.getChar();
            Direction newDirection = Direction.inputToDirection(button);

            snake.updateDirection(newDirection);

            snake.move(Direction.inputToDirection(button));
            if(snake.hasLost()){
                isRunning = false;
            }
            else if(snake.hasEaten(apple)){
                apple.generateRowPos();
                apple.generateColPos();
                snake.addTail();
            }
            wait(200);
        }
    }

    public static void wait(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
