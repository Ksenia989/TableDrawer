package Input;

public class SymbolsAfterComma extends InputRepeater {
    private static final String message = "Введите количество символов после запятой: ";
    private int symbolsAfrerComma;

    public SymbolsAfterComma() throws Exception {
        super(message);
    }

    public void setSymbolsAfterComma() throws Exception {
        super.read();
    }

    @Override
    void setValue(int data) {
        this.symbolsAfrerComma = data;
    }

    public int getSymbolsAfterComma() {
        return symbolsAfrerComma;
    }
}
