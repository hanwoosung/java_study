package test10;

public class Student {
    private String name;
    private int grade;
    private int s_class;
    private int snum;
    private int korea_socre;
    private int math_score;
    private int english_score;

    public Student() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setEnglish_score(int english_score) {
        this.english_score = english_score;
    }

    public void setMath_score(int math_score) {
        this.math_score = math_score;
    }

    public void setKorea_socre(int korea_socre) {
        this.korea_socre = korea_socre;
    }

    public void setSnum(int snum) {
        this.snum = snum;
    }

    public void setS_class(int s_class) {
        this.s_class = s_class;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getEnglish_score() {
        return english_score;
    }

    public int getMath_score() {
        return math_score;
    }

    public int getKorea_socre() {
        return korea_socre;
    }

    public int getSnum() {
        return snum;
    }

    public int getS_class() {
        return s_class;
    }

    public int getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    public Student(String name, int grade, int s_class, int snum, int korea_socre, int math_score, int english_score) {
        this.name = name;
        this.grade = grade;
        this.s_class = s_class;
        this.snum = snum;
        this.korea_socre = korea_socre;
        this.math_score = math_score;
        this.english_score = english_score;
    }
}