import java.io.*;

public class Student {
    /*  4 categories for input are "quizzes" , "exams", "homework ","project"
    * total is to the calculate the 4 categories
     */
    private String name;
    private int quizzes;
    private int exams;
    private int homework;
    private int project;
    private double total;
    private File gradeBook = new File("gradeBook.txt");
    private BufferedWriter writer;


    private double quizWeight = 0.20;
    private double examWeight = 0.30;
    private double homeworkWeight = 0.25;
    private double projectWeight = 0.25;

    /**
     * these percentages are made for the categories
     * @return results
     */


    Student(String name) {
        this.name = name;
        /**
         * @returm name
         */
    }

    public String getName() {
        /** set get to get students name
         * @return name
         */
        return name;
    }

    public int getQuiz() {
        /**
         * @return quizzes
         */
        return quizzes;
    }

    public int getExam() {
        /**
         * @return exams
         */
        return exams;
    }

    public int getHomework() {
        /**
         * @homework
         */
        return homework;
    }

    public int getProject() {
        /**
         * @return project
         */
        return project;
    }

    public double getTotal(){return total;}

    public void setQuiz(int grade) {
        quizzes = grade;
    }

    public void setExam(int grade) {
        exams = grade;
    }

    public void setHomework(int grade) {
        homework = grade;
    }

    public void setProject(int grade) {
        project = grade;
    }

    public void calculateGrade(){
        total = (((quizzes / 100.0) * quizWeight)) + (((exams / 100.0) * examWeight)) + (((homework / 100.0) * homeworkWeight))
        + (((project / 100.0) * projectWeight));
        total = total * 100.0;
    }

    public void createGradeBook(){
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
        String report = "Quizzes: " + getQuiz() + "\nExams: " + getExam() + "\nHomework: "
                + getHomework() + "\nProject: " + getProject() + "\nOverall Grade: "
                + String.format("%.2f", getTotal());
        /**
         * show the values to the grade
         * @param get the grades and the weights of it
         */
        try {
            writer.write(report);
            writer.flush();
        } catch (IOException e) {
            // Print exception if cannot write to file
            e.printStackTrace();
        }

    }

    public void closeGradeBook() throws IOException {
        writer.close();
    }

    public void readGrades(){
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
}