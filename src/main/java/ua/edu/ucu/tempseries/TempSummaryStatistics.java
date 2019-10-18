package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    public double avgTemp;
    public double devTemp;
    public double minTemp;
    public double maxTemp;

    TempSummaryStatistics(double avg, double dev, double min, double max) {
        avgTemp = avg;
        devTemp = dev;
        minTemp = min;
        maxTemp = max;
    }
    public double getAvg() {
        return avgTemp;
    }
    public double getDev() {
        return devTemp;
    }
    public double getMin() {
        return minTemp;
    }
    public double getMax() {
        return maxTemp;
    }
}
    

