package input;

public class SymbolsAfterComma extends InputRepeater {
    private static final String message = "Print the values of symbols after comma: ";
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
