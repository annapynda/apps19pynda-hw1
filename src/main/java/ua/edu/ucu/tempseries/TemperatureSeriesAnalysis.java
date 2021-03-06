package ua.edu.ucu.tempseries;

import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    private double[] temp;
    public TemperatureSeriesAnalysis(double[] temper) {
        this.temp = Arrays.copyOf(temper, temper.length);
        final double ELMIN = -273.0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] <= ELMIN) {
                throw new InputMismatchException();
            }
        }
    }

    public double average() {
        if (temp.length == 0) {
            throw new IllegalArgumentException();
        }
        double sum = 0.0;
        for (int i = 0; i < temp.length; i++) {
            sum += temp[i];
        }
        return sum / temp.length;
    }

    public double deviation() {
        if (temp.length == 0) {
            throw new IllegalArgumentException();
        }
        double averagev = this.average();
        double sum = 0;
        for (int i = 0; i < temp.length; i++) {
            double newel = temp[i] - averagev;
            sum += newel;

        }
        return Math.sqrt(sum / temp.length);

    }

    public double min() {
        if (temp.length == 0) {
            throw new IllegalArgumentException();
        }
        double mn = Double.MAX_VALUE;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] < mn) {
                mn = temp[i];
            }

        }
        return mn;
    }

    public double max() {
        if (temp.length == 0) {
            throw new IllegalArgumentException();
        }
        if (temp.length == 1) {
            return temp[0];
        }
        double mx = Double.MIN_VALUE;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > mx) {
                mx = temp[i];
            }

        }
        return mx;
    }

    public double findTempClosestToZero() {
        if (temp.length == 0) {
            throw new IllegalArgumentException();

        }
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        if (temp.length == 0) {
            throw new IllegalArgumentException();

        }
        if (temp.length == 1) {
            return temp[0];
        }
        double closestel = temp[0] - tempValue;
        for (int i = 0; i < temp.length; i++) {
            if (Math.abs(closestel) > Math.abs(temp[i] - tempValue)) {
                closestel = temp[i] - tempValue;
            }
        }
        return closestel;
    }

    public double[] findTempsLessThen(double tempValue) {
        if (temp.length == 0) {
            throw new IllegalArgumentException();

        }
        int lengneeded = 0;
        for (double t : temp) {
            if (t < tempValue) {
                lengneeded++;
            }
        }
        double[] newArr = new double[lengneeded];
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] < tempValue) {
                newArr[i] = temp[i];
            }

        }
        return newArr;

    }

    public double[] findTempsGreaterThen(double tempValue) {
        if (temp.length == 0) {
            throw new IllegalArgumentException();

        }
        if (temp.length == 1 && temp[0] > tempValue) {
            return temp;
        }
        int lengneeded = 0;
        for (double t : temp) {
            if (t < tempValue) {
                lengneeded++;
            }
        }
        int k = 0;
        double[] newArr = new double[lengneeded];
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > tempValue) {
                newArr[k] = temp[i];
                k++;
                if (k >= lengneeded) {
                    break;
                }
            }
        }
        return newArr;

    }

    public TempSummaryStatistics summaryStatistics() {
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }

    public int addTemps(double... temps) {
        if (temp.length == 0) {
            throw new IllegalArgumentException();
        }
        double[] res;
        res = new double[temp.length * 2];
        int sum = 0;
        int i = 0;
        for (int j = 0; j < temp.length; j++) {
            res[i] = temp[j];
            sum += temp[j];
            i++;
        }
        for (double t : temps) {
            res[i] = t;
            sum += t;
            i++;
        }
        this.temp = res;
        return sum;
    }


}

