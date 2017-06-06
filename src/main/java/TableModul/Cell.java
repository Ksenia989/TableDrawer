package TableModul;

public class Cell {
    private String value;
    private int sizeValue;

    public Cell(String value) {
        this.value = value;
        this.sizeValue = this.value.length();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getSizeValue() {
        return sizeValue;
    }
}
