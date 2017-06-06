package Input;

import java.io.IOException;

public class RightBound extends Bounds{
    private static final String message = "Введите правую границу: ";
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
