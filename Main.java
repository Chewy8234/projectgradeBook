import java.io.IOException;
import java.util.Scanner;
public class Main {
    /**
     * Prints student name
     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name;
        System.out.print("Enter Student name: ");
        name = scan.nextLine();
        Student student = new Student(name);
        System.out.println(student.getName());
        student.createGradeBook();


        boolean done = false;
        int grade;
        /** 1 is to add grades
         * 2 is to view the grades
         * Enter -1 to quit
         * @return the grades will show
         */
        while (!done) {
            System.out.print("Enter 1 for adding grades or Enter 2 for viewing grades (or -1 to quit): ");
            int addGrades = scan.nextInt();
            if (addGrades == 1) {
                System.out.print("Enter quiz grade: ");
                grade = scan.nextInt();
                scan.nextLine();
                student.setQuiz(grade);
                System.out.print("Enter exam grade: ");
                grade = scan.nextInt();
                scan.nextLine();
                student.setExam(grade);
                System.out.print("Enter homework grade: ");
                grade = scan.nextInt();
                scan.nextLine();
                student.setHomework(grade);
                System.out.print("Enter project grade: ");
                grade = scan.nextInt();
                scan.nextLine();
                student.setProject(grade);

                // record grades
                student.calculateGrade();
                student.createGradeBook();
                student.recordGrades();
                try{
                    student.closeGradeBook();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (addGrades == 2) {
                student.readGrades();
            } else if (addGrades == -1) {
                System.out.println("Goodbye");
                done = true;
                /** Enter 1 for quiz , Enter 2 for exam.
                 * Enter 3 for homework, Enter 4 for project
                 * @return The value of the the enter number
                 */
            }
        }
    }
}



