package com.model.student;

public class stuCourses {
    private String Cno;
    private String Clname;
    private String Cname;
    private double Ccredit;
    private String Cevaluation;
    private String SCyear;
    private String Cterm;
    private int Cperiod;

    public stuCourses(String cno, String clname, String cname, double ccredit, String cevaluation, String SCyear, String cterm, int cperiod) {
        Cno = cno;
        Clname = clname;
        Cname = cname;
        Ccredit = ccredit;
        Cevaluation = cevaluation;
        this.SCyear = SCyear;
        Cterm = cterm;
        Cperiod = cperiod;
    }

    public stuCourses() {
    }

    public String getCno() {
        return Cno;
    }

    public void setCno(String cno) {
        Cno = cno;
    }

    public String getClname() {
        return Clname;
    }

    public void setClname(String clname) {
        Clname = clname;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public double getCcredit() {
        return Ccredit;
    }

    public void setCcredit(double ccredit) {
        Ccredit = ccredit;
    }

    public String getCevaluation() {
        return Cevaluation;
    }

    public void setCevaluation(String cevaluation) {
        Cevaluation = cevaluation;
    }

    public String getSCyear() {
        return SCyear;
    }

    public void setSCyear(String SCyear) {
        this.SCyear = SCyear;
    }

    public String getCterm() {
        return Cterm;
    }

    public void setCterm(String cterm) {
        Cterm = cterm;
    }

    public int getCperiod() {
        return Cperiod;
    }

    public void setCperiod(int cperiod) {
        Cperiod = cperiod;
    }
}
