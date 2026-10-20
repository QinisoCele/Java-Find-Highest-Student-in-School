import java.util.ArrayList;

public class School {

    public ArrayList<ArrayList<Student>>  getHighStuSchool(ClassGrade[] cg){
        ArrayList<ArrayList<Student>> highClassSchool = new ArrayList<ArrayList<Student>>();

        // find highest for each class
        ArrayList<ArrayList<Student>> high4AllClass = new ArrayList<ArrayList<Student>>();
        
        for(int i=1; i< cg.length; i++){
            high4AllClass.add(cg[i].getStuHighestMark());
        }

        // compare all classes, to find class/es with highest marks
        highClassSchool.add(high4AllClass.get(0));

        for(int i=1; i< high4AllClass.size(); i++){
            if(
                // -> means (within)
                // `get first class -> the list of classes (represented as arraylist) 
                // -> get first student in the list of students (STUDENTS OF CLASS) 
                // -> get mark of the student, since they will have same mark but different names,
                //  we can just compare the first student in the list of students of a class, since they all have same mark`,
                ((highClassSchool.get(0)).get(0)).getMark() 
                < 
                ((high4AllClass.get(i)).get(0)).getMark()
            ){
                highClassSchool.clear();
                highClassSchool.add(high4AllClass.get(i));

            }else if(
                    ((highClassSchool.get(0)).get(0)).getMark() 
                    ==
                    ((high4AllClass.get(i)).get(0)).getMark()
            ){
                highClassSchool.add(high4AllClass.get(i));

            }
        }
        return highClassSchool;
    } 

    public static void main(String[] args) {
        // create students
        Student Ndvodza = new Student("Ndvodza", 85);
        Student Tarzan = new Student("Tarzan", 92);
        Student Qiniso = new Student("Qiniso", 100);
        Student Bongani = new Student("Bongani", 99);
        Student Thando = new Student("Thando", 100);
        Student Zanele = new Student("Zanele", 76);
        Student Sipho = new Student("Sipho", 85);

        // create classes
        ClassGrade class12A = new ClassGrade("12A", new Student[]{Ndvodza, Tarzan});
        ClassGrade class12B = new ClassGrade("12B", new Student[]{Qiniso, Bongani, Thando});
        ClassGrade class12C = new ClassGrade("12C", new Student[]{Zanele, Sipho, Ndvodza});

        // create school
        School school = new School();
        ArrayList<ArrayList<Student>> highestStudentsAchieversInSchool = school.getHighStuSchool(new ClassGrade[]{class12A, class12B, class12C});

        // print results
        System.out.println("Class averages: ");
        System.out.println(class12A.getAllStudentsAndMarks() + "Average: " + class12A.average());
        System.out.println(class12B.getAllStudentsAndMarks() + "Average: " + class12B.average());
        System.out.println(class12C.getAllStudentsAndMarks() + "Average: " + class12C.average());

        System.out.println();

        System.out.println(highestStudentsAchieversInSchool);

        System.out.println();

        System.out.println("Highest achievers in school: ");
        for (int i = 0; i < highestStudentsAchieversInSchool.size(); i++) {
            System.out.println("Class: " + (i + 1));
            for (int j = 0; j < highestStudentsAchieversInSchool.get(i).size(); j++) {
                System.out.println(" - " + ((highestStudentsAchieversInSchool.get(i)).get(j)).getName() + " with mark: " + ((highestStudentsAchieversInSchool.get(i)).get(j)).getMark());
            }
        }

    }


}