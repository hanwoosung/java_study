package test12.model.respones;

public class StudentClubDto {
    private String stdName;
    private String addr;
    private String clubName;
    private String roomNo;

    public StudentClubDto(String stdName, String addr, String clubName, String roomNo) {
        this.stdName = stdName;
        this.addr = addr;
        this.clubName = clubName;
        this.roomNo = roomNo;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    @Override
    public String toString() {
        return "학생 정보{" +
                "이름='" + stdName + '\'' +
                ", 지역='" + addr + '\'' +
                ", 동아리='" + clubName + '\'' +
                ", 방 번호='" + roomNo + '\'' +
                '}';
    }
}
