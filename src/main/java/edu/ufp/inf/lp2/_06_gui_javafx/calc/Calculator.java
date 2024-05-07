package edu.ufp.inf.lp2._06_gui_javafx.calc;

import java.math.BigDecimal;

public class Calculator {

    private BigDecimal valueInMem;

    public Calculator() {
        this.valueInMem = new BigDecimal(0.0);
    }

    protected enum Op {NOOP, SUM, SUBTRACT, MULTIPLY, DIVIDE}

    public double getValueInMem() {
        return valueInMem.doubleValue();
    }

    public void resetCalc() {
        valueInMem = new BigDecimal(0.0);
    }

    public void setValueInMem(Double value) {
        this.valueInMem = BigDecimal.valueOf(value);
    }


    public Double makeOperation(Op operation, Double number) {
        switch (operation) {
            case SUM:
                sum(number);
                break;
            case SUBTRACT:
                subtract(number);
                break;
            case MULTIPLY:
                multiply(number);
                break;
            case DIVIDE:
                divide(number);
        }
        return getValueInMem();
    }

    private void sum(Double number) {
        setValueInMem(getValueInMem()+number);
    }

    private void subtract(Double number) {
        setValueInMem(getValueInMem()-number);
    }

    private void multiply(Double number) {
        setValueInMem(getValueInMem()*number);
    }

    private void divide(Double number) {
        setValueInMem(getValueInMem()/number);
    }
}