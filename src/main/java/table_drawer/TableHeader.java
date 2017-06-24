package table_drawer;

public class TableHeader {
    private int tableLength;
    private String tableHeader;

    public TableHeader(int symbolsAfterComma, int columnsNumber, String tableHeader) {
        tableLength = (7 + symbolsAfterComma) * columnsNumber + 1;
        this.tableHeader = tableHeader;
    }

    public void drawTableHeader(){
        int tableRepeater;
        System.out.print(TableElements.LATERAL_ELEMENT);
        tableRepeater = (tableLength - tableHeader.length()) / 2;
        for (int i = 0; i < tableRepeater; i++) {
            System.out.print(" ");
        }
        System.out.print(tableHeader);
        if ((tableLength - tableHeader.length()) % 2 == 1) {
                tableRepeater++;
        }
        for (int i = 0; i < tableRepeater; i++) {
            System.out.print(" ");
        }
        System.out.print(TableElements.LATERAL_ELEMENT);
        System.out.println();
    }
}
