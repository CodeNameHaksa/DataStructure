package org.cscnu.example1;

public class MyTemperature implements Temperature {
    private double celsius;

    public MyTemperature(double value, char scale) {
        if (scale == 'C')
            setCelsius(value);
        else
            setFahrenheit(value);
    }

    public double getCelsius() {
        return celsius;
    }

    public double getFahrenheit() {
        return 9 * celsius / 5 + 32.0;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    public void setFahrenheit(double fahrenheit) {
        this.celsius = 5 * (fahrenheit - 32) / 9;
    }

    public String toString() {
        return round(getCelsius()) + " C =" + round(getFahrenheit()) + " F";
    }

    private double round(double x) {
        return Math.round(10 * x) / 10.0;
    }

}
