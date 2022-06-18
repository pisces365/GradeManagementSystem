package com.model.teacher;

public class CoursesPlace {
    private String Cno;
    private String Cname;
    private int SCscore;
    private String Sno;
    private String Sname;
    private String Clno;
    private String Clname;
    private String SCyear;

    public CoursesPlace(String cno, String cname, int SCscore, String sno, String sname, String clno, String clname, String SCyear) {
        Cno = cno;
        Cname = cname;
        this.SCscore = SCscore;
        Sno = sno;
        Sname = sname;
        Clno = clno;
        Clname = clname;
        this.SCyear = SCyear;
    }

    public String getSCyear() {
        return SCyear;
    }

    public void setSCyear(String SCyear) {
        this.SCyear = SCyear;
    }

    public CoursesPlace() {
    }

    public String getCno() {
        return Cno;
    }

    public void setCno(String cno) {
        Cno = cno;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public int getSCscore() {
        return SCscore;
    }

    public void setSCscore(int SCscore) {
        this.SCscore = SCscore;
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
