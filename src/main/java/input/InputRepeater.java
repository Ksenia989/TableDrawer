package input;

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
}
