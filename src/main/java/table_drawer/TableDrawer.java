package table_drawer;

import input.*;
import parts.Function;
import parts.ValuesCalculator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class TableDrawer {
    public TableDrawer(int symbolsAfterComma, int columnsNumber, List<Double> leftColumn, List<Double> rightColumn) {
        new TableTopPart(symbolsAfterComma, columnsNumber).drawTableTopPart();
        new TableHeader(symbolsAfterComma,columnsNumber, "MyNewTable").drawTableHeader();
        new TableEmptyLine(symbolsAfterComma, columnsNumber).drawEmptyLine();
        new TableColumnNames(symbolsAfterComma, columnsNumber, "X", "Y").drawColumnNames();
        new TableEmptyLine(symbolsAfterComma, columnsNumber).drawEmptyLine();
        new TableValues(symbolsAfterComma, columnsNumber, leftColumn, rightColumn).printValues();
        new TableBottomPart(symbolsAfterComma, columnsNumber).drawTableButtomPart();
    }

    public static void main(String[] args) throws Exception {
        Step step = new Step();
        step.setStep();
        ValuesCalculator valuesCalculator =
                new ValuesCalculator(new Function(-1, 5), step);
        valuesCalculator.setValuesInList();
        valuesCalculator.valuesCalculator();

        new TableDrawer(6, 2,
                valuesCalculator.getListOfYValues(), valuesCalculator.getCalculatedValues());
    }
}