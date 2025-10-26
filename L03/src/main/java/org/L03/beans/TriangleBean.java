package org.L03.beans;

public final class TriangleBean {
    private final int a;
    private final int b;
    private final int c;

    public TriangleBean() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }

    public TriangleBean(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return this.a;
    }

    public int getB() {
        return this.b;
    }

    public int getC() {
        return this.c;
    }

    public boolean isTriangle(){
        return (this.a + this.b) > this.c && (this.a + this.c) > this.b && (this.b + this.c) > this.a;
    }

    public double calculateArea() {
        // formula lui Heron
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - this.a) * (p - this.b) * (p - this.c));
    }

    public double calculatePerimeter() {
        return this.a + this.b + this.c;
    }
}
