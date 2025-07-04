public class Board {
    private static int boardHeight = Constants.BOARD_HEIGHT;
    private static int boardWidth = Constants.BOARD_WIDTH;

    private static int [][] board = new int[boardHeight][boardWidth];


    public void clear(){
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void print(Snake snake, Apple apple){
        for(int i = 0; i < boardHeight; i++){
            for(int j = 0; j < boardWidth; j++){
                if(snake.contains(i,j)) System.out.print("O");
                else if(i == apple.getRowPos() && j == apple.getColPos()) System.out.print('X');
                else if(i==0 || i== boardHeight -1 || j==0 || j== boardWidth -1)System.out.print("#");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
}
