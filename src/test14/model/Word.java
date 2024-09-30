package test14.model;

public class Word {
    String korea;
    String english;

    public Word(String korea, String english) {
        this.korea = korea;
        this.english = english;
    }

    public void setKorea(String korea) {
        this.korea = korea;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getKorea() {
        return korea;
    }

    public String getEnglish() {
        return english;
    }
}
