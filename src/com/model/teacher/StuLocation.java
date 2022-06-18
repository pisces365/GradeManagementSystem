package com.model.teacher;

public class StuLocation {
    private String Sno;
    private String Sname;
    private String Pname;
    private String Ciname;
    private String Dname;

    public StuLocation(String sno, String sname, String pname, String ciname, String dname) {
        Sno = sno;
        Sname = sname;
        Pname = pname;
        Ciname = ciname;
        Dname = dname;
    }

    public StuLocation() {
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

    public String getPname() {
        return Pname;
    }

    public void setPname(String pname) {
        Pname = pname;
    }

    public String getCiname() {
        return Ciname;
    }

    public void setCiname(String ciname) {
        Ciname = ciname;
    }

    public String getDname() {
        return Dname;
    }

    public void setDname(String dname) {
        Dname = dname;
    }
}
