package parts;

import java.util.ArrayList;
import java.util.List;

public class Function {
    static int LEFT_BOARD;
    static int RIGHT_BOARD;
    private List<Part> parts = new ArrayList<>();

    public Function(int LEFT_BOARD, int RIGHT_BOARD) {
        PartsInitializer partsInitializer = new PartsInitializer();
        this.parts = partsInitializer.getPartList();
        this.LEFT_BOARD = LEFT_BOARD;
        this.RIGHT_BOARD = RIGHT_BOARD;
    }

    public List<Part> getParts() {
        return parts;
    }
}
