package Parts;

import java.util.ArrayList;
import java.util.List;

public class Function {
    public static final int LEFT_BOARD = -8;// todo а если ещё захочешь кусочки добавить?
    public static final int RIGHT_BOARD = 10;
    private List<Part> parts = new ArrayList<>();

    public Function() {
        PartsInitializer partsInitializer = new PartsInitializer();
        this.parts = partsInitializer.getPartList();
    }

    public List<Part> getParts() {
        return parts;
    }
}
