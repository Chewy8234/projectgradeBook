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

    int numCourses;
    System.out.print("Enter the number of courses you are currently taking: ");
    numCourses = scan.nextInt();
    scan.nextLine();

    String courseName;
    int grade;

    for (int i = 0; i < numCourses; i++) {
      System.out.print("Enter course name: ");
      courseName = scan.nextLine();
      course course = new course(courseName);
      System.out.print("Enter a quiz grade: ");
      grade = scan.nextInt();
      scan.nextLine();
      course.addQuiz(grade);
      System.out.print("Enter an exam grade: ");
      grade = scan.nextInt();
      course.addExam(grade);
      scan.nextLine();
      System.out.print("Enter a homework grade: ");
      grade = scan.nextInt();
      scan.nextLine();
      course.addHomework(grade);
      System.out.print("Enter a project grade: ");
      grade = scan.nextInt();
      scan.nextLine();
      course.addProject(grade);
      course.calculateTotal();
      student.addCourse(course);
    }

    student.recordGrades();

    boolean done = false;

    while (!done) {
      System.out.print("Enter 1 for adding grades or Enter 2 for viewing grades (or -1 to quit): ");
      int option = scan.nextInt();
      scan.nextLine();

      if (option == 1) {
        System.out.println("Courses available to input grades: ");
        for (int i = 1; i <= student.getCourses().size(); i++) {
          System.out.println(i + ". " + student.getCourses().get(i-1).getName());
        }

        System.out.print("Enter number of course you'd like to input grade for: ");
        int courseOption = scan.nextInt();
        scan.nextLine();

        System.out.print(
            "Which category is the grade in? \nType 1 for quiz, 2 for exam, 3 for homework, " +
                "4 for project: ");
        int category = scan.nextInt();
        // The enter grades based on the 4 categories given: quizzes, exams,homework, project
        //Method for getting quiz, exam, homework, project grades. specifies when each grade needs to be inputted
        switch (category) {
          case 1:
            System.out.print("Enter quiz grade:");
            grade = scan.nextInt();
            scan.nextLine();
            student.getCourses().get(courseOption - 1).addQuiz(grade);
            student.getCourses().get(courseOption - 1).calculateTotal();
            student.createGradeBook();
            student.recordGrades();
            break;
          case 2:
            System.out.print("Enter exam grade: ");
            grade = scan.nextInt();
            scan.nextLine();
            student.getCourses().get(courseOption - 1).addExam(grade);
            student.getCourses().get(courseOption - 1).calculateTotal();
            student.createGradeBook();
            student.recordGrades();
            break;
          case 3:
            System.out.print("Enter homework grade: ");
            grade = scan.nextInt();
            scan.nextLine();
            student.getCourses().get(courseOption - 1).addHomework(grade);
            student.getCourses().get(courseOption - 1).calculateTotal();
            student.createGradeBook();
            student.recordGrades();
            break;
          default:
            System.out.print("Enter project grade: ");
            grade = scan.nextInt();
            scan.nextLine();
            student.getCourses().get(courseOption - 1).addProject(grade);
            student.getCourses().get(courseOption - 1).calculateTotal();
            student.createGradeBook();
            student.recordGrades();
            break;
        }
      } else if (option == 2){
        System.out.println("\n");
        student.readGrades();
      } else if (option == -1) {
        try {
          student.closeGradeBook();
        } catch (IOException e) {
          e.printStackTrace();
        }
        System.out.println("Goodbye");
        done = true;
      }
    }


  }
}



