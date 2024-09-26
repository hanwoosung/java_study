package test7;

import java.util.ArrayList;
import java.util.List;

class Manager {

    private List<Student> students = new ArrayList<>();

    public void registerStudent(String name, String gender, int grade, int koreanScore, int englishScore, int mathScore,
                                int electiveScore) {

        if (countStudentsByGrade(grade) >= 5) {
            System.out.println("이미 " + grade + "학년에 5명의 학생이 등록됨");
            return;
        }

        Student student = new Student(name, gender, grade, koreanScore, englishScore, mathScore, electiveScore);
        students.add(student);

        System.out.println("학생 등록 완료: " + student.getId() + " - " + student.getName());
    }

    public void showGrades(String gender, int grade) {

        System.out.println(gender + " " + grade + "학년 학생 성적:");

        for (Student student : students) {
            if (student.getGender().equals(gender) && student.getGrade() == grade) {
                System.out.println(student.getId() + " - " + student.getName() + ": " + student.getLevel());
            }
        }
    }

    public int countBelow(String gender, int grade) {

        int count = 0;

        for (Student student : students) {
            if (student.getGender().equals(gender) && student.getGrade() == grade && student.getScore() < 60) {
                count++;
            }
        }

        return count;
    }

    private int countStudentsByGrade(int grade) {

        int count = 0;

        for (Student student : students) {
            if (student.getGrade() == grade) {
                count++;
            }
        }

        return count;
    }
}
