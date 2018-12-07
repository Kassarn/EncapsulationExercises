package com.company;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLenght(length);
        setWidth(width);
        setHeight(height);
    }


    private void setLenght(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
            this.width = width;

    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    public double getVolume() {
        return this.length * this.height * this.width;
    }

    public double getLateralArea() {
        return 2 * this.length * this.height + 2 * this.width * this.height;
    }

    public double getSurfaceArea() {
        return 2 * this.length * this.width + 2 * this.length * this.height + 2 * this.width * this.height;
    }

    @Override
    public String toString() {
        return String.format("\nSurface Area - %.2f\nLateral Surface Area - %.2f\nVolume - %.2f"
                , this.getSurfaceArea(), this.getLateralArea(), this.getVolume());
    }
}
