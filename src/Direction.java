public enum Direction {
    UP(-1, 0),
    DOWN(1, 0),
    LEFT(0, -1),
    RIGHT(0, 1),
    NO_DIRECTION(0,0);

    public final int deltaI;
    public final int deltaJ;

    Direction(int deltaI, int deltaJ) {
        this.deltaI = deltaI;
        this.deltaJ = deltaJ;
    }

    public Direction opposite() {
        return switch(this) {
            case UP -> DOWN;
            case DOWN -> UP;
            case LEFT -> RIGHT;
            case RIGHT -> LEFT;
            case NO_DIRECTION -> NO_DIRECTION;
        };
    }
    public static Direction inputToDirection(char input) {
        return switch(input) {
            case 'w' -> Direction.UP;
            case 's' -> Direction.DOWN;
            case 'a' -> Direction.LEFT;
            case 'd' -> Direction.RIGHT;
            default -> Direction.NO_DIRECTION;
        };
    }
}
