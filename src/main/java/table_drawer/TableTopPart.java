package table_drawer;

public class TableTopPart {
    private int tableLength;

    public TableTopPart(int symbolsAfterComma, int columnsNumber) {
        tableLength = (7 + symbolsAfterComma) * columnsNumber + 1;
    }

    public void drawTableTopPart(){
        System.out.print(TableElements.LEFT_UPPER_ELEMENT);
        for (int i = 0; i < tableLength; i++) {
            System.out.print(TableElements.HORIZONTAL_BORDER_LINE);
        }
        System.out.print(TableElements.RIGHT_UPPER_ELEMENT);
        System.out.println();
    }
}
