public class GameInput {
    public native char getChar();

    static {
        System.loadLibrary("inputs"); // Adjust to your compiled library name
    }

}
