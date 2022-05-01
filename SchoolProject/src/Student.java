public class Student {
    private String firstName;
    private String lastName;
    private int grade;
    static int studentNum = 1;
    int idNum;

    //methods
    Student(){
        firstName = "";
        lastName = "";
        grade = 1;
        idNum = studentNum;
        studentNum++;
    }
    Student(String firstName, String lastName, int grade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        idNum = studentNum;
        studentNum++;
    }

    public void setName(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getfirstName(){
        return this.firstName;
    }
    public void setGrade(int grade){
        this.grade = grade;
    }
    public int getGrade(){
        return this.grade;
    }
    public int getIdNum(){
        return idNum;
    }

//Override method. When the object is printed, this string is printed instead of the location of the object
    public String toString(){
        return "Name: " + this.firstName + " " + this.lastName + " Grade: " + this.grade + "\n";
    }



}
