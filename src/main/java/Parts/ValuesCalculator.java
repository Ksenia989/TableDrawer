package Parts;

import Input.Step;

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
        this.step = 1;//step.getStep();//TODO: заменять 0.5 На step
    }

    List setValuesInList() {
        int listIndex = 0;
        for (double i = Function.LEFT_BOARD; i <= Function.RIGHT_BOARD; i = i + step, listIndex++) {// step = 1;
            listOfValues.add(listIndex, i);
        }
        return listOfValues;
    }

    public static void main(String[] args) throws Exception {
        List listOfValues;
        ValuesCalculator valuesCalculator = new ValuesCalculator(new Function(), new Step());
        // получаем listOfValues, с которым работаем
        listOfValues = valuesCalculator.setValuesInList();
        System.out.println("Значения x " + listOfValues);
        valuesCalculator.valuesCalculator();
        System.out.println("Вычислен   " + valuesCalculator.getCalculatedValues());
        System.out.println("Размеры " +
                "\n "+ listOfValues.size() + " " + valuesCalculator.getCalculatedValues().size());
    }

    private int indexOfElement = 0;
    List valuesCalculator() {
        for (int i = 0; i < parts.size(); i++) {
            calculateValueForOneElement(i);
        }
        calculatedValues.add(indexOfElement, parts.get(parts.size() - 1).calculateY(parts.get(parts.size() - 1).getRightBoard()));
        return calculatedValues;
    }

    void calculateValueForOneElement(int indexOfElementForCalculation){
         Part currentPart = parts.get(indexOfElementForCalculation);
         for(double i = currentPart.getLeftBoard(); i < currentPart.getRightBoard(); i+= step){
             calculatedValues.add(indexOfElement, currentPart.calculateY(i));
             indexOfElement++;
         }
    }

    public List<Double> getCalculatedValues() {
        return calculatedValues;
    }
}
