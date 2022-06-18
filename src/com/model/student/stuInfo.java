package com.model.student;

public class stuInfo {
    private String Sno;
    private String Sname;
    private String Clname;

    public stuInfo() {
    }

    public stuInfo(String sno, String sname, String clname) {
        Sno = sno;
        Sname = sname;
        Clname = clname;
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

    public String getClname() {
        return Clname;
    }

    public void setClname(String clname) {
        Clname = clname;
    }
}
