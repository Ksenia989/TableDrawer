package TableModul;
import java.util.ArrayList;

public class Column {
    private String columnTitle;
    private ArrayList<Cell> cells;
    private ArrayList<Double> values;
    private int heightColumn;

    public Column(String columnTitle, ArrayList<Double> values) {
        this.columnTitle = columnTitle;
        this.values = values;
        this.heightColumn = values.size();
        createCellList();
    }

    public Column() {
    }

    public void createCellList() {
        String a;
        cells = new ArrayList<>();
        cells.add(new Cell(columnTitle));
        for (int i = 0; i < values.size(); i++) {
            a = String.valueOf(values.get(i));
            cells.add(new Cell(a));
        }
    }

    public ArrayList<Double> getValues() {
        return values;
    }

    public int getHeightColumn() {
        return heightColumn;
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }
}