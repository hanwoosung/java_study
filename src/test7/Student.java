package test7;

class Student {
 
	private static int count = 1;
    private String id;
    private String name;
    private String gender;
    private int grade;
    private int koreanScore;
    private int englishScore;
    private int mathScore;
    private int electiveScore;
    private String level;

    public Student(String name, String gender, int grade, int koreanScore, int englishScore, int mathScore, int electiveScore) {
        this.id = "s" + count++;
        this.name = name;
        this.gender = gender;
        this.grade = grade;
        this.koreanScore = koreanScore;
        this.englishScore = englishScore;
        this.mathScore = mathScore;
        this.electiveScore = electiveScore;
        this.level = calculateGrade(); 
    }

    private String calculateGrade() {
       
    	double avg = (koreanScore + englishScore + mathScore + electiveScore) / 4.0; 
      
    	if (avg >= 90) return "A";
        if (avg >= 80) return "B";
        if (avg >= 70) return "C";
        if (avg >= 60) return "D";
      
        return "F";
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public int getGrade() { return grade; }
    public int getScore() { return (koreanScore + englishScore + mathScore + electiveScore) / 4; }
    public String getLevel() { return level; }
}
