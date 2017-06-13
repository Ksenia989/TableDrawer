package input;

import java.io.IOException;

public class RightBound extends Bounds{
    private static final String message = "Print right board: ";
    private int rightBound;

    public RightBound() throws Exception {
        super(message);
    }

    @Override
    public void setBound() throws IOException {
        super.read();
    }

    @Override
    void setValue(int data) {
        this.rightBound = data;
    }

    @Override
    public int getBound() {
        return this.rightBound;
    }
}
