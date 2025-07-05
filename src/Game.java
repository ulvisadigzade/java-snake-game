public class Game {
    private final Board board = new Board();
    private final GameInput gameInput = new GameInput();
    private final Snake snake = new Snake();
    private final Apple apple = new Apple();
    private boolean isRunning = true;


    public void start(){
        while(isRunning){
            board.clear();
            board.print(snake, apple);

            char button = gameInput.getChar();
            Direction newDirection = Direction.inputToDirection(button);
            snake.updateDirection(newDirection);

            snake.move();

            if(snake.hasLost()){
                isRunning = false;
            }
            else if(snake.hasEaten(apple)){
                apple.generateNewPosition();
                snake.addTail();
            }
            wait(Constants.GAME_DELAY_MS);
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
