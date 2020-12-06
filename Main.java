import java.io.IOException;
import java.util.Scanner;

public class Main {
    /**
     * This will hold the arraylist items that is added to gradebook which are
     * Quizzes,Exams,Homework,Projects
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


        /**
         * The is method to enter 1 to add grades and 2 to view grades
         * @param !done
         */
        while (!done) {
            System.out.print("Enter 1 for adding grades or Enter 2 for viewing grades (or -1 to quit): ");
            int addGrades = scan.nextInt();
            scan.nextLine();
            if (addGrades == 1) {
                System.out.print("Which category is the grade in? \nType 1 for quiz, 2 for exam, 3 for homework, " +
                        "4 for project: ");
                int category = scan.nextInt();
                // The enter grades based on the 4 categories given: quizzes, exams,homework, project
                //Method for getting quiz, exam, homework, project grades. specifies when each grade needs to be inputted
                switch (category) {
                    case 1:
                        System.out.print("Enter quiz grade:");
                        grade = scan.nextInt();
                        scan.nextLine();
                        student.addQuiz(grade);
                        break;
                    case 2:
                        System.out.print("Enter exam grade: ");
                        grade = scan.nextInt();
                        scan.nextLine();
                        student.addExam(grade);
                        break;
                    case 3:
                        System.out.print("Enter homework grade: ");
                        grade = scan.nextInt();
                        scan.nextLine();
                        student.addHomework(grade);
                        break;
                    default:
                        System.out.print("Enter project grade: ");
                        grade = scan.nextInt();
                        scan.nextLine();
                        student.addProject(grade);
                        break;
                }

                String classes = scan.next();
                System.out.print("Enter 1 Government , Enter 2 for ");
                switch(classes){
                }

                // outputs grades for quizzes, exams,homework,project


                //Created the student grade book

                student.createGradeBook();
                try {
                    student.closeGradeBook();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (addGrades == 2) {
                student.readGrades();
            } else if (addGrades == -1) {
                System.out.println("Goodbye");
                done = true;
                student.recordGrades();
                student.calculateGrade();

                boolean finish = false;

            }
        }
    }
}



