import java.io.*;
import java.util.*;
import java.util.Scanner;


public class Student {
    /*  4 categories for input are "quizzes" , "exams", "homework ","project"
     * total is to the calculate the 4 categories
     */
    private String name;
    private File gradeBook = new File("gradeBook.txt");
    private BufferedWriter writer;;
    private ArrayList<course> courses = new ArrayList<>();

    /**
     * @param name
     */

    Student(String name) {
        this.name = name;
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

    public void addCourse(course course){
        courses.add(course);
    }

    public ArrayList<course> getCourses(){
        return courses;
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
            writer = new BufferedWriter(new FileWriter(gradeBook, false));
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
            for (course course: courses){
                writer.write(course.toString());
                writer.flush();
            }
        } catch (IOException e) {
            // Print exception if cannot write to file
            e.printStackTrace();
        }

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

}


