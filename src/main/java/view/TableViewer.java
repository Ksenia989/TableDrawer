package view;

import input.*;
import parts.Function;
import parts.ValuesCalculator;
import table_drawer.TableDrawer;

public class TableViewer {
    public static void main(String[] args) throws Exception {
        Step step = new Step();
        SymbolsAfterComma symbolsAfterComma = new SymbolsAfterComma();
        Bounds leftBound = new LeftBound();
        Bounds rightBound = new RightBound();// todo нигдед не используются

        try {
            symbolsAfterComma.setSymbolsAfterComma();
            step.setStep();
            leftBound.setBound();
            rightBound.setBound();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // todo
        TableDrawer tableDrawer;
        ValuesCalculator valuesCalculator = new ValuesCalculator(new Function(), step);
        valuesCalculator.setValuesInList();
        valuesCalculator.valuesCalculator();
        tableDrawer = new TableDrawer("MyTable", new Function(), symbolsAfterComma, valuesCalculator.getListOfYValues(), valuesCalculator.getCalculatedValues());
        tableDrawer.drawFullTable();
    }
}


