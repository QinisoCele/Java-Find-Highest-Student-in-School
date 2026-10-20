// this is a student class
// it should have name, and a mark
// methods to act on the student

public class Student {

    private String name;
    private int mark;

    public Student(String name){
        this.name = name;
    }

    public Student(String name, int mark){
        this(name);
        if (mark < 0 || mark > 100) {
            System.out.printf(
                "Invalid mark for student %s. Please enter a mark between 0 and 100.%n" +
                "Mark for student %s will be initialized to 0.%n" +
                "Please use the setMark() method to set a valid mark for student %s.%n%n",
                name, name, name
            );
            this.mark = 0;
        } else {
            this.mark = mark;
        }

    }

    public void setMark(int mark){
        if (mark < 0 || mark > 100){
            System.out.printf(
                "Invalid mark. Please enter a mark between 0 and 100.%n" +
                "Mark for student %s will be unchanged.%n" +
                "Please try again with a valid mark for student %s.%n" +
                "student %s currently has a mark of: %d.%n%n",
                name, name, name, this.mark
            );
        }else{
            this.mark = mark;
        }
    }

    public String getName(){
        return this.name;
    }

    public int getMark(){
        return this.mark;
    }

    public String toString(){
        return "Name: " + this.name + ", class mark: " + this.mark;
    }

    public static void main(String[] args) {
        // create students
        Student s1 = new Student("John", 85);
        Student s2 = new Student("Alice", 92);
        Student s3 = new Student("Bob", 78);
        Student s4 = new Student("Eve", 105);
        Student s5 = new Student("Charlie", -5);

        // print student details
        System.out.println(s1.toString());
        System.out.println(s2.toString());
        System.out.println(s3.toString());
        System.out.println(s4.toString());
        System.out.println(s5.toString());

        // update marks
        s1.setMark(90);
        s5.setMark(70);
        System.out.println("Updated Student " + s1.toString());
        System.out.println("Updated Student " + s5.toString());
    }
}