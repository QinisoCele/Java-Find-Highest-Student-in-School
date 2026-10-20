import java.util.ArrayList;


public class ClassGrade {

    private String grade;
    private Student[] students;

    public ClassGrade(String grade){
        this.grade = grade;
    }

    public ClassGrade(String grade, Student[] students){
        this(grade);
        if(students == null || students.length == 0){
                System.out.println("No students provided for class " + grade + ". Please provide at least one student.\n"
                    + "The students array for class " + grade + " will be initialized as an empty array.\n"
                    + "Please use the setStudents() method to add students to class " + grade + ".\n");
        }else{
            this.students = students;
        }
    }

    public void setStudents(Student[] students){
        if(students == null || students.length == 0){
            System.out.println("No students provided for class " + grade + ". Please provide at least one student.");
            System.out.println("The students array for class " + grade + " will remain unchanged.");
            System.out.println("Please use the setStudents() method to add students to class " + grade + ".");
            System.out.println();
        }else{
            this.students = students;
        }
    }

    public String getAllStudentsAndMarks(){
        String allStudentsAndMarks = "Class: " + this.grade + "\n";

        if(students == null || students.length == 0){
            allStudentsAndMarks = allStudentsAndMarks + "No students provided for class " + grade + ". Please provide at least one student.\n";
            allStudentsAndMarks = allStudentsAndMarks + "Please use the setStudents() method to add students to class " + grade + ".\n";
            return allStudentsAndMarks;
        }

        for(int i=0; i< students.length; i++){
            if(students[i] == null){
                allStudentsAndMarks = allStudentsAndMarks + "Student " + (i+1) + ": No student provided.\n";
            }else{  
                allStudentsAndMarks = allStudentsAndMarks + students[i].toString() + "\n";
            }
        }
        return allStudentsAndMarks;
    }

    public double average(){
        double avg =0;
        int totalStudents = 1;
        if(students == null || students.length == 0){
            System.out.println("No students provided for class " + grade + ". Please provide at least one student.");
            System.out.println("The average mark for class " + grade + " will be returned as 0.");
            System.out.println("Please use the setStudents() method to add students to class " + grade + ".");
            System.out.println();
            return 0;
        }
        int totalStudentsSize = students.length;

        // to avoid zero division error
        if(totalStudentsSize - 1 > 0){
            totalStudents = totalStudentsSize;
        }

        for(int i=0; i< totalStudents; i++){
            avg += students[i].getMark();
        }
        return avg/totalStudents;
    }

    public ArrayList<Student> getStuHighestMark(){
        ArrayList<Student> stusHighMark = new ArrayList<Student>();

        stusHighMark.add(students[0]);

        for(int i = 1; i < students.length; i++){
            // `.get(0)`, since all the items here will have same mark but diff name
            if (stusHighMark.get(0).getMark() < students[i].getMark() ){
                // clear the list since, we have same mark but differnt names
                // of the highest achievers if student
                stusHighMark.clear();
                stusHighMark.add(students[i]);

            }else if( stusHighMark.get(0).getMark() == students[i].getMark() ){
                stusHighMark.add(students[i]);
            }
        }
        return stusHighMark;
    }

    public String toString(){
        if(students == null || students.length == 0){
            return "Class: " + this.grade + ", Students: 0";
        }
        return "Class: " + this.grade + ", Students: " + this.students.length;
    }

    public static void main(String[] args) {
        // create students
        Student s1 = new Student("John", 85);
        Student s2 = new Student("Alice", 92);
        Student s3 = new Student("Bob", 78);
        Student s4 = new Student("Eve", 92);
        Student s5 = new Student("Charlie", 88);

        // create class 1
        Student[] students = {s1, s2, s3, s4, s5};
        ClassGrade cg10A = new ClassGrade("Grade 10A", students);

        //Create class 2
        Student s6 = new Student("David", 90);
        Student s7 = new Student("Eva", 95);
        Student[] students2 = {s6, s7}; 
        ClassGrade cg10B = new ClassGrade("Grade 10B", new Student[]{});

        // print class 1 details
        System.out.println(cg10A.toString());
        System.out.println(cg10A.getAllStudentsAndMarks());
        System.out.println("Average Mark: " + cg10A.average());
        System.out.println();

        // print class 2 details
        System.out.println(cg10B.toString());
        System.out.println(cg10B.getAllStudentsAndMarks());
        System.out.println("Average Mark: " + cg10B.average()); 
        System.out.println();


        // get highest mark students Class 1
        ArrayList<Student> highMarkStudents = cg10A.getStuHighestMark();
        System.out.println("Highest Mark Students:");
        for(Student student : highMarkStudents){
            System.out.println(student.toString());
        }

        //Update class 2 students
        System.out.println();
        System.out.println("Updating class 2 students...");
        cg10B.setStudents(students2);
        System.out.println(cg10B.toString());
        System.out.println();



        // get highest mark students Class 2
        System.out.println("Class 2 students after update:");
        ArrayList<Student> highMarkStudents2 = cg10B.getStuHighestMark();
        System.out.println("Highest Mark Students:");
        for(Student student : highMarkStudents2){       
            System.out.println(student.toString());
        }   

    }
}