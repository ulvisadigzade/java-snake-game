public class Game {
    private final Board board = new Board();
    private final GameInput gameInput = new GameInput();
    private final Snake snake = new Snake();
    private final Apple apple = new Apple();
    private boolean isRunning = true;


    public void start(){
        while(isRunning){
            render();
            control();
            delayGame();
        }
    }

    public void render(){
        board.clear();
        board.print(snake, apple);
    }

    public void control(){
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
    }


    public void delayGame(){
        try {
            Thread.sleep(Constants.GAME_DELAY_MS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
