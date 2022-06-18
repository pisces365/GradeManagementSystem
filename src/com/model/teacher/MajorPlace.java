package com.model.teacher;

public class MajorPlace {
    private String Sno;
    private String Sname;
    private String Ssex;
    private double Sscore;
    private String Clno;
    private String Clname;
    private String Mno;
    private String Mname;

    public MajorPlace() {
    }

    public MajorPlace(String sno, String sname, String ssex, double sscore, String clno, String clname, String mno, String mname) {
        Sno = sno;
        Sname = sname;
        Ssex = ssex;
        Sscore = sscore;
        Clno = clno;
        Clname = clname;
        Mno = mno;
        Mname = mname;
    }

    public String getSno() {
        return Sno;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSsex() {
        return Ssex;
    }

    public void setSsex(String ssex) {
        Ssex = ssex;
    }

    public double getSscore() {
        return Sscore;
    }

    public void setSscore(double sscore) {
        Sscore = sscore;
    }

    public String getClno() {
        return Clno;
    }

    public void setClno(String clno) {
        Clno = clno;
    }

    public String getClname() {
        return Clname;
    }

    public void setClname(String clname) {
        Clname = clname;
    }

    public String getMno() {
        return Mno;
    }

    public void setMno(String mno) {
        Mno = mno;
    }

    public String getMname() {
        return Mname;
    }

    public void setMname(String mname) {
        Mname = mname;
    }
}
