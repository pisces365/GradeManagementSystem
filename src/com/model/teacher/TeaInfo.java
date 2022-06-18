package com.model.teacher;

public class TeaInfo {
    private String Tno;
    private String Tname;

    public TeaInfo() {
    }

    public TeaInfo(String tno, String tname) {
        Tno = tno;
        Tname = tname;
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
}
