package table_drawer;

public class TableEmptyLine {
    private int tableLength;

    public TableEmptyLine(int symbolsAfterComma, int columnsNumber) {
        tableLength = (7 + symbolsAfterComma) * columnsNumber + 1;
    }

    public void drawEmptyLine(){
        System.out.print(TableElements.LATERAL_ELEMENT);
        for (int i = 0; i < tableLength; i++) {
            System.out.print(TableElements.HORIZONTAL_INTERMEDIATE_LINE);
        }
        System.out.print(TableElements.LATERAL_ELEMENT);
        System.out.println();
    }
}
