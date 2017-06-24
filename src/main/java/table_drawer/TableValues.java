package table_drawer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class TableValues {
    public List<Double> leftColumn;
    public List<Double> rightColumn;
    private String stringFormat;
    private int symbolsAfterComma;
    private int tableLength;


    public TableValues(int symbolsAfterComma, int columnsNumber, List<Double> leftColumn, List<Double> rightColumn) {
        tableLength = (7 + symbolsAfterComma);
        this.leftColumn = leftColumn;
        this.rightColumn = rightColumn;
        this.symbolsAfterComma = symbolsAfterComma;
        this.stringFormat = calculateStringFormat();
    }

    public void printValues(){
        StringBuilder myLine;
        for (int i = 0; i < leftColumn.size(); i++) {
            myLine = new StringBuilder();
            myLine.append(TableElements.LATERAL_ELEMENT);
            myLine.append("\t").append(printFormattedValue(leftColumn.get(i)));
            myLine.append(TableElements.LATERAL_ELEMENT);
            myLine.append("\t").append(printFormattedValue(rightColumn.get(i)));
            myLine.append(TableElements.LATERAL_ELEMENT);
            System.out.print(myLine);
            System.out.println();
        }
    }

    private String printFormattedValue(Double value) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        ps.printf(stringFormat, value);
        return new String(baos.toByteArray(), StandardCharsets.UTF_8);
    }

    String calculateStringFormat() {
        return "%." + symbolsAfterComma + 'f';
    }
}
