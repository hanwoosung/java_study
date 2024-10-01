package test17.dto.respones;

public class InfoDto {
    private String sname;
    private int pCnt;
    private int pWin;
    private int pLose;
    private int pDraw;
    private int sCnt;
    private int sWin;
    private int sLose;
    private int sDraw;
    private int rCnt;
    private int rWin;
    private int rLose;
    private int rDraw;

    public int getAllCnt() {
        return allCnt;
    }

    public void setAllCnt(int allCnt) {
        this.allCnt = allCnt;
    }

    private int allCnt;
    private double pWinPer;
    private double sWinPer;
    private double rWinPer;

    public InfoDto() {
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getPCnt() {
        return pCnt;
    }

    public void setPCnt(int pCnt) {
        this.pCnt = pCnt;
    }

    public int getPWin() {
        return pWin;
    }

    public void setPWin(int pWin) {
        this.pWin = pWin;
    }

    public int getPLose() {
        return pLose;
    }

    public void setPLose(int pLose) {
        this.pLose = pLose;
    }

    public int getPDraw() {
        return pDraw;
    }

    public void setPDraw(int pDraw) {
        this.pDraw = pDraw;
    }

    public int getSCnt() {
        return sCnt;
    }

    public void setSCnt(int sCnt) {
        this.sCnt = sCnt;
    }

    public int getSWins() {
        return sWin;
    }

    public void setSWins(int sWin) {
        this.sWin = sWin;
    }

    public int getSLose() {
        return sLose;
    }

    public void setSLose(int sLose) {
        this.sLose = sLose;
    }

    public int getSDraw() {
        return sDraw;
    }

    public void setSDraw(int sDraw) {
        this.sDraw = sDraw;
    }

    public int getRCnt() {
        return rCnt;
    }

    public void setRCnt(int rCnt) {
        this.rCnt = rCnt;
    }

    public int getRWin() {
        return rWin;
    }

    public void setRWin(int rWin) {
        this.rWin = rWin;
    }

    public int getRLose() {
        return rLose;
    }

    public void setRLose(int rLose) {
        this.rLose = rLose;
    }

    public int getRDraw() {
        return rDraw;
    }

    public void setRDraw(int rDraw) {
        this.rDraw = rDraw;
    }

    public double getPWinPer() {
        return pWinPer;
    }

    public void setPWinPer(double pWinPer) {
        this.pWinPer = pWinPer;
    }

    public double getSWinsPer() {
        return sWinPer;
    }

    @Override
    public String toString() {
        return "나의 전적 {\n" +
                "  이름: '" + sname + "'\n" +
                "  전체 횟수: '" + allCnt + "'\n" +
                "  --- 가위 ---\n" +
                "  가위 승리: " + pWin + "\n" +
                "  가위 패배: " + pLose + "\n" +
                "  가위 무승부: " + pDraw + "\n" +
                "  가위 승률: " + pWinPer + "%\n" +
                "  --- 바위 ---\n" +
                "  바위 승리: " + rWin + "\n" +
                "  바위 패배: " + rLose + "\n" +
                "  바위 무승부: " + rDraw + "\n" +
                "  바위 승률: " + rWinPer + "%\n" +
                "  --- 보 ---\n" +
                "  보 승리: " + sWin + "\n" +
                "  보 패배: " + sLose + "\n" +
                "  보 무승부: " + sDraw + "\n" +
                "  보 승률: " + sWinPer + "%\n" +
                '}';
    }

    public void setSWinsPer(double sWinPer) {
        this.sWinPer = sWinPer;
    }

    public double getRWinPer() {
        return rWinPer;
    }

    public void setRWinPer(double rWinPer) {
        this.rWinPer = rWinPer;
    }
}
