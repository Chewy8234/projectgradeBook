import java.io.*;
import java.util.*;
import java.util.Scanner;


public class Student {
    Scanner scan = new Scanner(System.in);
    /*  4 categories for input are "quizzes" , "exams", "homework ","project"
     * total is to the calculate the 4 categories
     */
    private String name;
    private double total;
    private ArrayList<Integer> quizzes = new ArrayList<>();
    private ArrayList<Integer> exams = new ArrayList<>();
    private ArrayList<Integer> homework = new ArrayList<>();
    private ArrayList<Integer> project = new ArrayList<>();
    private File gradeBook = new File("gradeBook.txt");
    private BufferedWriter writer;
    private Map<String, Integer> grades = new HashMap<>();
    private ArrayList<String> courses = new ArrayList<>();



    private double quizWeight = 0.20;
    private double examWeight = 0.30;
    private double homeworkWeight = 0.25;
    private double projectWeight = 0.25;


    /**
     * Assign grade category
     * @param name
     */

    Student(String name) {
        this.name = name;
        grades.put("quizzes", 0);
        grades.put("exams", 0);
        grades.put("homework", 0);
        grades.put("projects", 0);
    }

    /**
     * Returns the students name from grade book
     * @return
     */

    public String getName() {
        /** set get to get students name
         * @return name
         */
        return name;
    }


    /**
     * inputs that were inputted in the arraylist is going to show
     * @return quizzes
     */
    public ArrayList<Integer> getQuiz() {
        int grade = 0;
        ArrayList<Integer> grades = new ArrayList<>();
        while(grade > 0){
            System.out.print("Enter quiz");
            grade = scan.nextInt();
            scan.nextLine();
            if(grade > 0){
                grades.add( grade);
            }

        }

        return quizzes;
    }

    /**
     * Getter to get back input for exams
     * @return exams
     */

    public ArrayList<Integer> getExam() {
        int grade = 0;
        ArrayList<Integer> grades = new ArrayList<>();
        while(grade > 0){
            System.out.print("Enter exam");
            grade = scan.nextInt();
            scan.nextLine();
            if(grade > 0){
                grades.add(grade);
            }

        }

        return exams;
    }

    /**
     *get back the input from the private class for exams
     * @return exams
     */

    public ArrayList<Integer> getHomework() {
        int grade = 0 ;
        ArrayList<Integer> grades = new ArrayList<>();
        while(grade > 0){
            System.out.print("Enter homework");
            grade = scan.nextInt();
            scan.nextLine();
            if(grade > 0){
                grades.add( grade);
            }

        }
        return homework;
    }

    /**
     * get back the input from the private class for homework
     * @return homework
     */

    public ArrayList<Integer> getProject() {

        int grade = 0;
        ArrayList<Integer> grades = new ArrayList<>();
        while(grade > 0){
            System.out.print("Enter quiz");
            grade = scan.nextInt();
            scan.nextLine();
            if(grade > 0){
                grades.add( grade);
            }

        }
        return project;
    }
    public ArrayList<String> getCourses(){
        return courses;
    }

    public double getTotal() {
     return grades.get("total");
    }

    public void addQuiz(int grade) {
        quizzes.add(grade);
        grades.put("quizzes", grades.get("quizzes") + grade);
    }

    public void addExam(int grade) {
        exams.add(grade);
        grades.put("exams", grades.get("exams") + grade);
    }

    public void addHomework(int grade) {
        homework.add(grade);
        grades.put("homework", grades.get("homework") + grade);
    }


    public void addProject(int grade) {
        project.add(grade);
        grades.put("projects", grades.get("projects") + grade);
    }



    public void calculateGrade() {
        int quiz = 0;
        total =  quizzes.get(quiz);
        total = total * 100.0;
    }

    public void createGradeBook() {
        if (gradeBook.exists()) {
            gradeBook.delete();
        }
        /** the gradeBook value is only set to one
         * After entering a new value those values are going to be seen
         */

        try {
            gradeBook.createNewFile();
            writer = new BufferedWriter(new FileWriter(gradeBook, false)); //false only for alpha since it is only one set of grades.
        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void recordGrades() {
        /**
         * show the values to the grade
         * @param get the grades and the weights of it
         */
        try {
            writer.write(toString());
            writer.flush();
        } catch (IOException e) {
            // Print exception if cannot write to file
            e.printStackTrace();
        }

    }

    public String toString(){

        /**Inherits properties of toString
         * @return  report the calculations of the category with the weights of each category
         */
        String report = "Quizzes: " + getQuiz() + "\nExams: " + getExam() + "\nHomework: "
                + getHomework() + "\nProject: " + getProject() + "\nOverall Grade: "
                + String.format("%.2f", getTotal());
        return report;
    }

    public void closeGradeBook() throws IOException {
        writer.close();
    }

    public void readGrades() {
        try {
            FileReader reader = new FileReader(gradeBook);
            BufferedReader bReader = new BufferedReader(reader);

            if (gradeBook.length() == 0) {
                System.out.println("No grades to view. Please add grades first.");
            } else {
                String line = "";
                while ((line = bReader.readLine()) != null) {
                    System.out.println(line);
                }
                reader.close();
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File does not exist: " + ex.getStackTrace());
        } catch (IOException e) {
            System.out.println("Problem reading file: " + e.getStackTrace());
        }
    }

    public void addClasses(ArrayList<String> courses) {
    }
}


