import java.util.ArrayList;

public class School {
    //Fields
    ArrayList<Teacher> Teachers;
    ArrayList<Student> Students;
    ArrayList<String> Courses;
    String schoolName;
    String city;
    int yearFounded;

    //Methods

    //Constructor
    School(){
        Teachers = new ArrayList<Teacher>();
        Students = new ArrayList<Student>();
        Courses = new ArrayList<String>();
        schoolName = "";
        city = "";
        yearFounded = 1900;
    }
    //Method for when there is user input when the method is called.
    School(String schoolName, String city, int yearFounded){
        Teachers = new ArrayList<Teacher>();
        Students = new ArrayList<Student>();
        Courses = new ArrayList<String>();
        this.schoolName = schoolName;
        this.city = city;
        this.yearFounded = yearFounded;
    }

    //Method that adds teachers to the Teachers ArrayList (takes in a name and subject, creates a new teacher object with those fields, and adds it to the Teachers ArrayList
    public void addTeacher(String firstName, String lastName, String subject){
        this.Teachers.add(new Teacher(firstName, lastName, subject));
    }

    //Method that removes the last teacher object from the teacher ArrayList. The last index is obtained using size().
    public void removeTeacher() {
        this.Teachers.remove(Teachers.size()-1);
    }

    //Method that prints out the Teachers ArrayList when called.
    public void allTeachers() {
        System.out.println("All Teachers:\n" + this.Teachers);
    }
    //Method that adds students to the Students ArrayList (takes in a name and subject, creates a new student object with those fields, and adds it to the Students ArrayList
    public void addStudent(String firstName, String lastName, int grade) {
        this.Students.add(new Student(firstName, lastName, grade));
    }

    //Same as teacher version
    public void removeStudent() {
        Students.remove(Students.size()-1);
    }

    //Same as teacher version
    public void allStudents() {
        System.out.println("All Students:\n" + this.Students);
    }
}
