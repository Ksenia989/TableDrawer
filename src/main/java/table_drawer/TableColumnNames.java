package table_drawer;

public class TableColumnNames {
    private int tableLength;
    private String leftColumnName;
    private String rightColumnName;

    public TableColumnNames(int symbolsAfterComma, int columnsNumber, String leftColumnName, String rightColumnName) {
        tableLength = (7 + symbolsAfterComma);
        this.leftColumnName = leftColumnName;
        this.rightColumnName = rightColumnName;
    }

    public void drawColumnNames(){
        System.out.print(TableElements.LATERAL_ELEMENT);
        drawColumnName(leftColumnName);
        System.out.print(TableElements.LATERAL_ELEMENT);
        drawColumnName(rightColumnName);
        System.out.print(TableElements.LATERAL_ELEMENT);
        System.out.println();
    }

    private void drawColumnName(String name) {
        int tableRepeater;
        tableRepeater = (tableLength - name.length()) / 2;
        for (int i = 0; i < tableRepeater; i++) {
            System.out.print(" ");
        }
        System.out.print(name);
        if ((tableLength - name.length()) % 2 == 1) {
            tableRepeater++;
        }
        for (int i = 0; i < tableRepeater; i++) {
            System.out.print(" ");
        }
    }
}
