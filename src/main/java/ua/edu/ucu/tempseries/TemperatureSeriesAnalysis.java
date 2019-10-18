package ua.edu.ucu.tempseries;

import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    private double[] temp;

    public TemperatureSeriesAnalysis() {
    }

    public TemperatureSeriesAnalysis(double[] temper) {
        this.temp = Arrays.copyOf(temper, temper.length);
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] <= -273) {
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
        double average_v = this.average();
        double sum = 0;
        for (int i = 0; i < temp.length; i++) {
            double new_el = temp[i] - average_v;
            sum += new_el;

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
        double closest_el = temp[0] - tempValue;
        for (int i = 0; i < temp.length; i++) {
            if (Math.abs(closest_el) > Math.abs(temp[i] - tempValue)) {
                closest_el = temp[i] - tempValue;
            }
        }
        return closest_el;
    }

    public double[] findTempsLessThen(double tempValue) {
        if (temp.length == 0) {
            throw new IllegalArgumentException();

        }
        int leng_needed = 0;
        for (double t : temp) {
            if (t < tempValue) {
                leng_needed++;
            }
        }
        double[] new_arr = new double[leng_needed];
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] < tempValue) {
                new_arr[i] = temp[i];
            }

        }
        return new_arr;

    }

    public double[] findTempsGreaterThen(double tempValue) {
        if (temp.length == 0) {
            throw new IllegalArgumentException();

        }
        if (temp.length == 1 && temp[0] > tempValue) {
            return temp;
        }
        int leng_needed = 0;
        for (double t : temp) {
            if (t < tempValue) {
                leng_needed++;
            }
        }
        int k = 0;
        double[] new_arr = new double[leng_needed];
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > tempValue) {
                new_arr[k] = temp[i];
                k++;
                if (k >= leng_needed) break;
            }
        }
        return new_arr;

    }

    public TempSummaryStatistics summaryStatistics() {
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }

    public int addTemps(double... temps) {
        double[] res;
        res = new double[temp.length * 2];
        int sum = 0;
        int i = 0;
        for (double t : temp) {
            res[i] = t;
            sum += t;
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

