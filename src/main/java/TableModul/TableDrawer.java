package TableModul;

import Input.Step;
import Parts.Function;
import Parts.ValuesCalculator;

import java.util.*;

public class TableDrawer {
    private static final int INDENTATION = 2; // отступы по бокам
    private TableHeader tableHeader;
    private List<Column> columns;

    private int maxLength; // Максимальная длинна значений
    private int widthTable;
    private HashMap<Column, Integer> widthColumns;

    public TableDrawer(TableHeader tableHeader, List<Column> columns) {
        this.tableHeader = tableHeader;
        this.columns = columns;
        findMaxLength();
        calcWidhtTableAndColumns();
    }

    public void findMaxLength() {
        for (int i = 0; i < columns.size(); i++) {
            for (Cell v : columns.get(i).getCells()) {
                int size = v.getValue().length();
                if (size > maxLength) {
                    maxLength = size;
                }
            }
        }
    }

    public void calcWidhtTableAndColumns() {
        int sizebBetweenColumns = columns.size() - 1;
        int widthColumn = maxLength + 2 * INDENTATION;
        int widthHeaderTitel = tableHeader.getHeaderTitle().length() + 2 * INDENTATION;
        int widthAllColumns = widthColumn * columns.size() + sizebBetweenColumns;
        int width = widthHeaderTitel - columns.size() + 1; // общая ширина всех колонок
        widthColumns = new HashMap<>();
        for (int i = 0; i < columns.size(); i++) {
            if (widthHeaderTitel > widthAllColumns) {
                int readyWidth = width / (columns.size() - i); // Вычисляем ширину колонки
                width -= readyWidth; // уменьшаем ширину всех колонок
                widthColumns.put(columns.get(i), readyWidth);
                widthTable = widthHeaderTitel;
            } else {
                widthColumns.put(columns.get(i), widthColumn);
                widthTable = widthAllColumns;
            }
        }
    }

    public StringBuffer setNSymbol(int size, String symbol) {
        StringBuffer result = new StringBuffer("");
        for (int i = 0; i < size; i++) {
            result.append(symbol);
        }
        return result;
    }

    public StringBuffer assemblyHeader() {
        StringBuffer head = new StringBuffer("╓");
        int lenghtHeaderTitel = tableHeader.getHeaderTitle().length();
        int leftBorder = (widthTable - lenghtHeaderTitel) / 2;
        int rightBorder = widthTable - leftBorder - lenghtHeaderTitel;
        head.append(setNSymbol(widthTable, "─") + "╖\n║");
        head.append(setNSymbol(leftBorder, " ") + tableHeader.getHeaderTitle() +
                setNSymbol(rightBorder, " ") + "║\n╟");
        for (Column column : columns) {
            head.append(setNSymbol(widthColumns.get(column), "─"));
            if (isColumnLast(column)) {
                head.append("╢");
            } else {
                head.append("╥");
            }
        }
        return head;
    }

    public StringBuffer assemblyColumns() {
        StringBuffer stringColumn = new StringBuffer("");
        int highColumn = columns.get(0).getHeightColumn();
        for (int i = 0; i < highColumn; i++) {
            for (int j = 0; j < columns.size(); j++) {
                Column column = columns.get(j);
                Cell cell = column.getCells().get(i);
                int leftBorderForValue = widthColumns.get(column) - cell.getValue().length();
                int leftBorderForHead = leftBorderForValue / 2;
                int rightBorderForHead = leftBorderForValue - leftBorderForHead;
                if (isCellFirst(column, cell)) {
                    stringColumn.append("║" + setNSymbol(leftBorderForHead, " ") + cell.getValue() +
                            setNSymbol(rightBorderForHead, " "));
                } else {
                    stringColumn.append("║" + setNSymbol(leftBorderForValue, " ") + cell.getValue());
                }
            }
            if (!isCellLast(i, highColumn)) {
                stringColumn.append("║\n");
                stringColumn.append(createBetweenCellLine());
            } else {
                stringColumn.append("║");
            }
        }
        return stringColumn;
    }

    public StringBuffer createBetweenCellLine() {
        StringBuffer result = new StringBuffer("╟");
        for (Column column : columns) {
            result.append(setNSymbol(widthColumns.get(column), "─"));
            if (isColumnLast(column)) {
                result.append("╢\n");
            } else {
                result.append("╫");
            }
        }
        return result;
    }

    public StringBuffer assemblyBasement() {
        StringBuffer stringBasement = new StringBuffer("╙");
        for (Column column : widthColumns.keySet()) {
            if (isColumnLast(column)) {
                stringBasement.append(setNSymbol(widthColumns.get(column), "─") + "╜");
            } else {
                stringBasement.append(setNSymbol(widthColumns.get(column), "─") + "╨");
            }
        }
        return stringBasement;
    }

    public StringBuffer createHeaderColumns() {
        StringBuffer result = new StringBuffer("║");
        return result;
    }

    public Boolean isCellFirst(Column column, Cell cell) {
        return column.getCells().get(0) == cell;
    }

    public Boolean isCellLast(int i, int high) {
        return i == high - 1;
    }

    public Boolean isColumnLast(Column column) {
        int indexLastColumn = columns.size() - 1;
        return columns.get(indexLastColumn) == column;
    }

    public void assemblyTable() {
        System.out.println(assemblyHeader());
        System.out.println(assemblyColumns());
        System.out.println(assemblyBasement());
    }

    public static void main(String[] args) throws Exception {
        List<Column> list = new ArrayList<>();// todo
        TableDrawer tableDrawer = new TableDrawer(new TableHeader("MyTable"), (new ValuesCalculator(new Function(), new Step())).getCalculatedValues());
        tableDrawer.assemblyTable();
    }
}