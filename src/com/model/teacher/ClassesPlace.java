package com.model.teacher;

public class ClassesPlace {
    private String Sno;
    private String Sname;
    private String Ssex;
    private double Sscore;
    private String Clno;
    private String Clname;

    public ClassesPlace(String sno, String sname, String ssex, double sscore, String clno, String clname) {
        Sno = sno;
        Sname = sname;
        Ssex = ssex;
        Sscore = sscore;
        Clno = clno;
        Clname = clname;
    }

    public ClassesPlace() {
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
}
