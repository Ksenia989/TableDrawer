package TableDrawer;

import Input.Step;
import Input.SymbolsAfterComma;
import Parts.Function;
import Parts.ValuesCalculator;
import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class TableDrawer {
    private static final int EDGE_INTENDATION = 2;
    public List<Double>[] columns;
    Function function;
    int symbolsAfterComma;
    String title;

    public TableDrawer(String title, Function function, SymbolsAfterComma symbolsAfterComma, List<Double>... columns) {
        this.title = title;
        this.function = function;
        this.columns = columns;
        this.symbolsAfterComma = 5;// todo symbolsAfterComma.getSymbolsAfterComma();
    }

    void drawFullTable() {
        System.out.println(drawHeader());
        System.out.println(drawValues());
        System.out.println(drawFoundation());
    }

    private String drawHeader() {
        StringBuilder header = new StringBuilder("╔");
        int symbolsForPartOfTable = calculateSymbols() - 2;//todo - write description
        for (int i = 0; i < symbolsForPartOfTable / 2; i++) {
            header.append('═');
        }
        header.append('╦');
        for (int i = 0; i < symbolsForPartOfTable / 2; i++) {
            header.append('═');
        }
        header.append('╗');
        return header.toString();
    }

    private String drawValues() {
        StringBuilder stringValues = new StringBuilder("║");
        for (int i = 0; i < columns[0].size(); i++) {
            stringValues.append(drawValuesForColumns());
            stringValues.append("║\n");
        }
        return stringValues.append('\n').toString();
    }

    private int index = 0;
    private String drawValuesForColumns() {
        StringBuilder stringValues = new StringBuilder();
        int i;
        for (i = 0; i < calculateColumnsValue(); i++) {// прогон по каждой колонке
            stringValues.append(printFormattedValue(columns[i].get(index)));// по определённому элементу
            stringValues.append('┼');
        }
        index++;
        stringValues.append('┼');
        return stringValues.toString();

    }

    private String printFormattedValue(Double value) {// вот это костыль...
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        ps.printf(calculateStringFormat(), value);
        return new String(baos.toByteArray(), StandardCharsets.UTF_8);
    }

    private String drawFoundation() {
        StringBuilder foundation = new StringBuilder("╚");
        for (int i = 0; i < calculateColumnsValue(); i++) {
            foundation.append(drawFoundationForOneColumn(i));
        }
        foundation.append('╝');
        return foundation.append('\n').toString();
    }

    @NotNull
    private String drawFoundationForOneColumn(int columns) {
        StringBuilder foundation = new StringBuilder();
        int symbolsForPartOfTable = calculateSymbols() - 2;//todo - write description
        int i;
        for (i = 0; i < symbolsForPartOfTable / 2; i++) {
            foundation.append('═');
        }
        if(columns < calculateColumnsValue() - 1) foundation.append('╩');
        return foundation.toString();
    }

    String drawEmptyLine() {
        StringBuilder line = new StringBuilder("╟");
        for (int i = 0; i < calculateColumnsValue(); i++) {
            line.append(drawEmptyLineForOneColumn());
        }
        line.append('╢');
        return line.append('\n').toString();
    }

    @NotNull
    private String drawEmptyLineForOneColumn() {
        StringBuilder line = new StringBuilder();
        int symbolsForPartOfTable = calculateSymbols() / 2 - 2;//todo - write description
        for (int i = 0; i < symbolsForPartOfTable; i++) {
            line.append('─');
        }
        line.append('┼');
        return line.toString();
    }

    String calculateStringFormat() {
        return "%." + symbolsAfterComma + 'f';
    }

    int calculateSymbols() {
        //TODO: учитывать заголовок и отступы и количество колонок
        return 20;
    }

    int calculateColumnsValue() {
        return columns.length;
    }

    public static void main(String[] args) throws Exception {
        // todo
        TableDrawer tableDrawer;
        ValuesCalculator valuesCalculator = new ValuesCalculator(new Function(), new Step());
        valuesCalculator.setValuesInList();
        valuesCalculator.valuesCalculator();
        tableDrawer = new TableDrawer("MyTable", new Function(), new SymbolsAfterComma(), valuesCalculator.getListOfYValues(), valuesCalculator.getCalculatedValues());
        tableDrawer.drawFullTable();
    }
}