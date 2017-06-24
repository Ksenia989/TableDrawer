package table_drawer;

public class TableBottomPart {
    private int tableLength;

    public TableBottomPart(int symbolsAfterComma, int columnsNumber) {
        tableLength = (7 + symbolsAfterComma) * columnsNumber + 1;
    }

    public void drawTableButtomPart(){
        System.out.print(TableElements.LEFT_BOTTOM_ELEMENT);
        for (int i = 0; i < tableLength; i++) {
            System.out.print(TableElements.HORIZONTAL_BORDER_LINE);
        }
        System.out.print(TableElements.RIGHT_BOTTOM_ELEMENT);
        System.out.println();
    }
}
