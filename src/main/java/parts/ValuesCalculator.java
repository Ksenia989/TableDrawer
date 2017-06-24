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
        for (double i = Function.LEFT_BOARD; i <= Function.RIGHT_BOARD; i = i + step, listIndex++) {
            listOfValues.add(listIndex, i);
        }
        return listOfValues;
    }

    public List valuesCalculator(){
        int indexOfTablePartForValue;
        for (int i = 0; i < listOfValues.size(); i++) {
            indexOfTablePartForValue = calculateIndexOfTablePart(i);
            calculatedValues.add(calculateValueForOneElement(listOfValues.get(i), indexOfTablePartForValue));
        }
        return calculatedValues;
    }

    private double calculateValueForOneElement(double xValue, int partIndex) {
        return parts.get(partIndex).calculateY(xValue);
    }

    private int calculateIndexOfTablePart(int index){
        int calculatedIndex = 0;
        for (int i = 0; i < parts.size(); i++) {
            if (listOfValues.get(index) > parts.get(i).getLeftBoard() && listOfValues.get(index) <= parts.get(i).getRightBoard()) {
                calculatedIndex = i;
            }
        }
        return calculatedIndex;
    }

    public List<Double> getCalculatedValues() {
        return calculatedValues;
    }

    public List<Double> getListOfYValues() {
        return listOfValues;
    }
}
