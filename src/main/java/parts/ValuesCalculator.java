package parts;

import input.Step;

import java.util.*;

public class ValuesCalculator {
    private List<Double> listOfValues = new ArrayList<>();
    private List<Double> calculatedValues = new ArrayList<>();
    private List<Part> parts = new ArrayList<>();
    Function function;
    double step;

    public ValuesCalculator(Function function, Step step) {
        this.function = function;
        this.parts = function.getParts();
        this.step = step.getStep();
    }

    public List setValuesInList() {
        int listIndex = 0;
        for (double i = Function.LEFT_BOARD; i <= Function.RIGHT_BOARD; i = i + step, listIndex++) {// step = 1;
            listOfValues.add(listIndex, i);
        }
        return listOfValues;
    }

    private int indexOfElement = 0;
    public List valuesCalculator() {
        for (int i = 0; i < parts.size(); i++) {
            calculateValueForOneElement(i);
        }
        calculatedValues.add(indexOfElement, parts.get(parts.size() - 1).calculateY(parts.get(parts.size() - 1).getRightBoard()));
        return calculatedValues;
    }

    private void calculateValueForOneElement(int indexOfElementForCalculation){
         Part currentPart = parts.get(indexOfElementForCalculation);
         for(double i = currentPart.getLeftBoard(); i < currentPart.getRightBoard(); i+= step){
             calculatedValues.add(indexOfElement, currentPart.calculateY(i));
             indexOfElement++;
         }
    }

    public List<Double> getCalculatedValues() {
        return calculatedValues;
    }

    public List<Double> getListOfYValues() {
        return listOfValues;
    }
}
