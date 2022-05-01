import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        School VCS = new School("Vancouver Christian School", "Vancouver", 1930);

        //Adding 10 new students
        VCS.addStudent("Kyla", "Yu", 11);
        VCS.addStudent("Second", "Kyla", 11);
        VCS.addStudent("TheBetter", "Kyla", 11);
        VCS.addStudent("TheBest", "Kyla", 11);
        VCS.addStudent("Another", "Kyla", 11);
        VCS.addStudent("Younger", "Kyla", 1);
        VCS.addStudent("Older", "Kyla", 12);
        VCS.addStudent("Kyla", "You", 10);
        VCS.addStudent("Kyla!", "Yu!!!", 11);
        VCS.addStudent("THAT", "Kyla", 11);

        //Adding 3 teachers
        VCS.addTeacher("Aaron", "Gysbers", "Math");
        VCS.addTeacher("Timothy", "Cheung", "Chemistry");
        VCS.addTeacher("Grace", "Li", "Physics");

        //printing students and teachers
        VCS.allStudents();
        VCS.allTeachers();

        //removing 2 students and 1 teacher
        VCS.removeStudent();
        VCS.removeStudent();
        VCS.removeTeacher();

        //printing students and teachers again
        VCS.allStudents();
        VCS.allTeachers();

    }
}
