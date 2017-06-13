package table_drawer;

import input.*;
import parts.Function;

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
        this.symbolsAfterComma = symbolsAfterComma.getSymbolsAfterComma();
    }

    public void drawFullTable() {
        System.out.println(drawHeader());
        System.out.println(drawValues());
        System.out.println(drawFoundation());
    }

    private String drawHeader() {
        StringBuilder header = new StringBuilder("╔");
        int symbolsForPartOfTable = calculateSymbols() - 2;
        for (int i = 0; i < symbolsForPartOfTable / 2; i++) {
            header.append("═");
        }
        header.append("╦");
        for (int i = 0; i < symbolsForPartOfTable / 2; i++) {
            header.append("═");
        }
        header.append("╗");
        return header.toString();
    }

    private String drawValues() {
        StringBuilder stringValues = new StringBuilder();
        for (int i = 0; i < columns[0].size(); i++) {
            stringValues.append(drawValuesForColumns());
            stringValues.append("║");
            stringValues.append('\n');//todo
            stringValues.append(drawEmptyLine());
        }
        stringValues.append('\n');
        return stringValues.toString();
    }

    private int index = 0;
    private String drawValuesForColumns() {
        StringBuilder stringValues = new StringBuilder();
        stringValues.append("║");
        appendIntendation(stringValues);
        int i;
        for (i = 0; i < calculateColumnsValue(); i++) {// прогон по каждой колонке
            stringValues.append(printFormattedValue(columns[i].get(index)));// по определённому элементу
            stringValues.append('\t');
            if (i < calculateColumnsValue() - 1) {
                stringValues.append("║");
                appendIntendation(stringValues);
            }
        }
        index++;
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

    private String drawFoundationForOneColumn(int columns) {
        StringBuilder foundation = new StringBuilder();
        int symbolsForPartOfTable = calculateSymbols() - 2;
        int i;
        for (i = 0; i < symbolsForPartOfTable / 2; i++) {
            foundation.append("═");
        }
        if(columns < calculateColumnsValue() - 1) foundation.append("╩");
        return foundation.toString();
    }

    int i;
    String drawEmptyLine() {
        StringBuilder line = new StringBuilder("╟");
        for (i = 0; i < calculateColumnsValue(); i++) {
            line.append(drawEmptyLineForOneColumn());
        }
        line.append("╢");
        return line.append('\n').toString();
    }

    private String drawEmptyLineForOneColumn() {
        StringBuilder line = new StringBuilder();
        int symbolsForPartOfTable = calculateSymbols() / 2 - 1;
        for (int i = 0; i < symbolsForPartOfTable; i++) {
            line.append("─");
        }
        if (i < calculateColumnsValue() - 1) {line.append("╫");}
        return line.toString();
    }

    String calculateStringFormat() {
        return "%." + symbolsAfterComma + 'f';
    }

    int calculateSymbols() {
        //TODO: учитывать заголовок и отступы и количество колонок
        return (7 + symbolsAfterComma) * 2;
    }

    void appendIntendation(StringBuilder stringBuilder){
        for (int i = 0; i < EDGE_INTENDATION; i++) {
            stringBuilder.append(' ');
        }
    }

    int calculateColumnsValue() {
        return columns.length;
    }
}