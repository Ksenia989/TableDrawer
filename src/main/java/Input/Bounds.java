package Input;

import java.io.IOException;

public abstract class Bounds extends InputRepeater{
    public Bounds(String message) throws Exception {
        super(message);
    }

    abstract public void setBound() throws IOException;

    abstract public int getBound();
}
