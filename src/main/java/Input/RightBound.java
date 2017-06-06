package Input;

public class Bounds extends InputRepeater{
    private static final String message = "Введите интервал A и B: ";
    private int leftBound;
    private int rightBound;

    public Bounds() throws Exception {
        super(message);
    }

    public void setBounds() throws Exception {
        super.read();
        super.read();
    }

    void setValue(int data) {
        this.leftBound = data;
    }

    public void setLeftBound(int leftBound) {
        this.leftBound = leftBound;
    }

    public void setRightBound(int rightBound) {
        this.rightBound = rightBound;
    }

    public int getLeftBound() {
        return leftBound;
    }

    public int getRightBound() {
        return rightBound;
    }
}
