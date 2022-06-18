package com.model.student;
///学生成绩查询模型
public class stuGrade {
    private String Cno;
    private String Clname;
    private int SCscore;
    private String SCyear;
    private String Cname;
    private double Ccredit;
    private String Cevaluation;
    private String Cterm;
    private int Cperiod;

    public stuGrade(String cno, String Clname, int SCscore, String SCyear, String cname, double ccredit, String cevaluation, String cterm, int cperiod) {
        Cno = cno;
        this.Clname = Clname;
        this.SCscore = SCscore;
        this.SCyear = SCyear;
        Cname = cname;
        Ccredit = ccredit;
        Cevaluation = cevaluation;
        Cterm = cterm;
        Cperiod = cperiod;
    }

    public stuGrade() {
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

    public void setClname(String Clname) {
        this.Clname = Clname;
    }

    public int getSCscore() {
        return SCscore;
    }

    public void setSCscore(int SCscore) {
        this.SCscore = SCscore;
    }

    public String getSCyear() {
        return SCyear;
    }

    public void setSCyear(String SCyear) {
        this.SCyear = SCyear;
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
