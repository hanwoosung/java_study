package test17.dto;

public class RpsVictoryDto {
    private int vno;
    private String sname;
    private String rps;
    private String result;
    public RpsVictoryDto() {
    }

    public RpsVictoryDto(int vno, String sname, String rps, String result) {
        this.vno = vno;
        this.sname = sname;
        this.rps = rps;
        this.result = result;
    }

    public int getVno() {
        return vno;
    }

    public void setVno(int vno) {
        this.vno = vno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sno) {
        this.sname = sno;
    }

    public String getRps() {
        return rps;
    }

    public void setRps(String rps) {
        this.rps = rps;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "RpsVictoryDto{" +
                "vno=" + vno +
                ", sno=" + sname +
                ", rps=" + rps +
                ", result=" + result +
                '}';
    }
}
