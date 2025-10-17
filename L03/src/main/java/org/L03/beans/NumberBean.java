package org.L03.beans;

public class NumberBean {
    private double num = 0;

    public NumberBean(double number) {
        this.num = number;
    }

    public double getNum() {
        return this.num;
    }

    public void setNum(double number){
        this.num = number;
    }
}
