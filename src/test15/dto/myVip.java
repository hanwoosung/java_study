package test15.dto;

import java.sql.Timestamp;

public class myVip {
    String name;
    String birth;
    Timestamp regdate;

    public myVip(String name, String birth, Timestamp regdate) {
        this.name = name;
        this.regdate = regdate;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }



    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Timestamp getRegdate() {
        return regdate;
    }

    public void setRegdate(Timestamp regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        return "myVip{" +
                "name='" + name + '\'' +
                ", birth=" + birth +
                ", regdate=" + regdate +
                '}';
    }
}
