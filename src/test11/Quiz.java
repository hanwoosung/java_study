package test11;

public class Quiz {
    private int num;
    private String content;
    private String answer;

    public Quiz(int num,String content, String answer) {
        this.num = num;
        this.content = content;
        this.answer = answer;
    }

    public int getNum() {
        return num;
    }

    public String getContent() {
        return content;
    }

    public String getAnswer() {
        return answer;
    }

}
