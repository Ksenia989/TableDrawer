package TableModul;

import Input.Step;
import Input.SymbolsAfterComma;
import Parts.Function;
import Parts.ValuesCalculator;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class TableDrawer {
    private static final int EDGE_INTENDATION = 2;
    private List<Double>[] columns;
    Function function;
    int symbolsAfterComma;
    String title;

    public TableDrawer(String title, Function function, SymbolsAfterComma symbolsAfterComma, List<Double>... columns) {
        this.title = title;
        this.function = function;
        this.columns = columns;
        this.symbolsAfterComma = symbolsAfterComma.getSymbolsAfterComma();
    }

    void drawFillTable() {
        drawHeader();
        drawValues();
        drawFoundation();
    }

    private String drawHeader() {
        StringBuilder header = new StringBuilder("╔");
        int symbolsForPartOfTable = calculateSymbols() / 2 - 2;//todo - write description
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

    }

    private String drawFoundation() {
        StringBuilder header = new StringBuilder("╚");
        for(int i = 0; i < calculateColumnsValue(); i++){
            header.append(drawHeaderForOneColumn());
        }
        header.append('╝');
       return header.append('\n').toString();
    }

    @NotNull
    private String drawHeaderForOneColumn(){
        StringBuilder header = new StringBuilder();
        int symbolsForPartOfTable = calculateSymbols() / 2 - 2;//todo - write description
        for (int i = 0; i < symbolsForPartOfTable / 2; i++) {
            header.append('═');
        }
        header.append('╦');
        for (int i = 0; i < symbolsForPartOfTable / 2; i++) {
            header.append('═');
        }
        return header.toString();
    }

    String drawEmptyLine() {
        StringBuilder line = new StringBuilder("╟");
        for(int i = 0; i < calculateColumnsValue(); i++){
            line.append(drawEmptyLineForOneColumn());
        }
        line.append('╢');
        return line.append('\n').toString();
    }

    @NotNull
    private String drawEmptyLineForOneColumn(){
        StringBuilder line = new StringBuilder();
        int symbolsForPartOfTable = calculateSymbols() / 2 - 2;//todo - write description
        for (int i = 0; i < symbolsForPartOfTable / 2; i++) {
            line.append('─');
        }
        line.append('┼');
        for (int i = 0; i < symbolsForPartOfTable / 2; i++) {
            line.append('═');
        }
        return line.toString();
    }

    String calculateStringFormat() {
        return "%." + symbolsAfterComma + 'f';
    }

    int calculateSymbols() {
        //TODO: учитывать заголовок и отступы и количество колонок
        return 10;
    }

    int calculateColumnsValue(){
        return columns.length;
    }

    public static void main(String[] args) throws Exception {
        // todo
        TableDrawer tableDrawer;
        ValuesCalculator valuesCalculator = new ValuesCalculator(new Function(), new Step());
//        tableDrawer = new TableDrawer(valuesCalculator.getListOfYValues(), valuesCalculator.getCalculatedValues());
    }
}