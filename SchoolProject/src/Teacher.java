public class Teacher {
    private String teacherFirstName;
    private String teacherLastName;
    private String subject;

    //methods

    //constructor
    Teacher(){
        teacherFirstName = "";
        teacherLastName = "";
        subject = "";
    }
    Teacher( String firstName, String lastName, String subject){
        this.teacherFirstName = firstName;
        this.teacherLastName = lastName;
        this.subject = subject;
    }
    public void setTeacherFirstName(String firstName){
        this.teacherFirstName = firstName;
    }
    public String getTeacherFirstName(){
        return teacherFirstName;
    }
    public void setTeacherLastName(String lastName){
        this.teacherFirstName = lastName;
    }
    public String getTeacherLastName(){
        return teacherLastName;
    }
    public void setSubject(String subject){
        this.subject = subject;
    }
    public String getSubject(){
        return subject;
    }

    public String toString(){
        return "Name: " + teacherFirstName + " " + teacherLastName + " Subject: " + subject + "\n";
    }


}
