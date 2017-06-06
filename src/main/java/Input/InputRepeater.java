package Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class InputRepeater {
    public String userMessage;
    Integer data;

    public InputRepeater(String message) throws Exception {
        this.userMessage = message;
    }

    public void read() throws IOException {
        System.out.println(userMessage);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        data = Integer.parseInt(reader.readLine());
        setValue(data);
    }

    abstract void setValue(int data);

    public static void main(String[] args) throws Exception {
        Step step = new Step();
        SymbolsAfterComma symbolsAfterComma = new SymbolsAfterComma();
        Bounds leftBound = new LeftBound();
        Bounds rightBound = new RightBound();

        try {
            symbolsAfterComma.setSymbolsAfterComma();
            step.setStep();
            leftBound.setBound();
            rightBound.setBound();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("symbolsAfterComma = " + symbolsAfterComma.getSymbolsAfterComma());
        System.out.println("step = " + step.getStep());
        System.out.println("rightBound = " + rightBound.getBound());
        System.out.println("leftBound = " + leftBound.getBound());
    }
}
