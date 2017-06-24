package input;


import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.*;

public class Step extends InputRepeater {
    private static final String message = "Print step: ";


    @Digits(integer=6, fraction=2)
    @NotNull(message = "Шаг не должен быть нулевым")
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
