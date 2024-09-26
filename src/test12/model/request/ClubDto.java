package test12.model.request;

public class ClubDto {
    private String clubName;
    private String roomNo;

    public ClubDto(String clubName, String roomNo) {
        this.clubName = clubName;
        this.roomNo = roomNo;
    }

    public String getClubName() {
        return clubName;
    }

    public String getRoomNo() {
        return roomNo;
    }

    @Override
    public String toString() {
        return "동아리 목록{" +
                "동아리 이름='" + clubName + '\'' +
                ", 방 번호='" + roomNo + '\'' +
                '}';
    }
}
