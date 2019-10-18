package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    final double avgTemp;
    final double devTemp;
    final double minTemp;
    final double maxTemp;

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
    

