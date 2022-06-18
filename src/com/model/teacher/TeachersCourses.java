package com.model.teacher;

public class TeachersCourses {
    private String Tno;
    private String Tname;
    private String Cno;
    private String Clname;
    private String TCyear;
    private String Cname;

    public TeachersCourses(String tno, String tname, String cno, String clname, String TCyear, String cname) {
        Tno = tno;
        Tname = tname;
        Cno = cno;
        Clname = clname;
        this.TCyear = TCyear;
        Cname = cname;
    }

    public TeachersCourses() {
    }

    public String getTno() {
        return Tno;
    }

    public void setTno(String tno) {
        Tno = tno;
    }

    public String getTname() {
        return Tname;
    }

    public void setTname(String tname) {
        Tname = tname;
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

    public String getTCyear() {
        return TCyear;
    }

    public void setTCyear(String TCyear) {
        this.TCyear = TCyear;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }
}
