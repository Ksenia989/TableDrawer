package input;

import java.io.IOException;

public class LeftBound extends Bounds{
    private static final String message = "Print left board ";
    private int leftBound;

    public LeftBound() throws Exception {
        super(message);
    }

    @Override
    public void setBound() throws IOException {
        super.read();
    }

    void setValue(int data) {
        this.leftBound = data;
    }

    @Override
    public int getBound() {
        return this.leftBound;
    }
}
