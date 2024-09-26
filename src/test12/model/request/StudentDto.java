package test12.model.request;

public class StudentDto {
    private String stdName;
    private String addr;

    public StudentDto(String stdName, String addr) {
        this.stdName = stdName;
        this.addr = addr;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }
}