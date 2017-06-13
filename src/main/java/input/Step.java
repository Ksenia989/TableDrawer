package input;

public class Step extends InputRepeater {
    private static final String message = "Print step: ";
    private int step;

    public Step() throws Exception {
        super(message);
    }

    public void setStep() throws Exception {
        super.read();
    }

    @Override
    void setValue(int data) {
        this.step = data;
    }

    public int getStep() {
        return step;
    }
}