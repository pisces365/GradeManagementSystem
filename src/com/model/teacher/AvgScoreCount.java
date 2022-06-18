package com.model.teacher;

public class AvgScoreCount {
    private String Cname;
    private String year;
    private double AveScore;

    public AvgScoreCount(String cname, String year, double aveScore) {
        Cname = cname;
        this.year = year;
        AveScore = aveScore;
    }

    public AvgScoreCount() {
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getAveScore() {
        return AveScore;
    }

    public void setAveScore(double aveScore) {
        AveScore = aveScore;
    }
}
