import java.util.ArrayList;

public class course {

    private String name;
    private double total;
    private ArrayList<Integer> quizzes = new ArrayList<>();
    private ArrayList<Integer> exams = new ArrayList<>();
    private ArrayList<Integer> homeworks = new ArrayList<>();
    private ArrayList<Integer> projects = new ArrayList<>();
    private double quizWeight = 0.20;
    private double examWeight = 0.30;
    private double homeworkWeight = 0.25;
    private double projectWeight = 0.25;


    course(String name) {
        this.name = name;
    }

    public void addQuiz(int quiz) {
        quizzes.add(quiz);
    }

    public void addExam(int exam) {
        exams.add(exam);
    }

    public void addHomework(int homework) {
        homeworks.add(homework);
    }

    public void addProject(int project) {
        projects.add(project);
    }

    public String getName(){
        return name;
    }

    public ArrayList<Integer> getQuizzes() {
        return quizzes;
    }

    public ArrayList<Integer> getExams() {
        return exams;
    }

    public ArrayList<Integer> getHomeworks() {
        return homeworks;
    }

    public ArrayList<Integer> getProjects() {
        return projects;
    }

    public double getTotal() {
        return total;
    }

    public void calculateTotal() {
        // calculate quizzes total and use weight
        double quizTotal = 0;
        for (int i = 0; i < getQuizzes().size(); i++) {
            quizTotal += getQuizzes().get(i);
        }
        quizTotal = (quizTotal / ((getQuizzes().size()) * 100.0)) * quizWeight;

        // calculate exams total and use weight
        double examTotal = 0;
        for (int i = 0; i < getExams().size(); i++) {
            examTotal += getExams().get(i);
        }
        examTotal = (examTotal / ((getExams().size()) * 100.0)) * examWeight;

        // calculate homework total and use weight
        double homeworkTotal = 0;
        for (int i = 0; i < getHomeworks().size(); i++) {
            homeworkTotal += getHomeworks().get(i);
        }
        homeworkTotal = (homeworkTotal / ((getHomeworks().size()) * 100.0)) * homeworkWeight;

        // calculate project total and use weight
        double projectTotal = 0;
        for (int i = 0; i < getProjects().size(); i++) {
            projectTotal += getProjects().get(i);
        }
        projectTotal = (projectTotal / ((getProjects().size()) * 100.0)) * projectWeight;

        total = (quizTotal + examTotal + homeworkTotal + projectTotal) * 100.0;
    }

    public String toString() {

        /**Inherits properties of toString
         * @return report the calculations of the category with the weights of each category
         */
        String report =
                "Course name: " + name + "\n____________________" + "\nQuizzes: " + getQuizzesReport() + "\nExams: "
                        + getExamsReport() + "\nHomework: "
                        + getHomeworksReport() + "\nProject: " + getProjectsReport() + "\nOverall Grade: "
                        + String.format("%.2f", getTotal()) + "\n\n";
        return report;
    }

    private String getQuizzesReport() {
        String quizReport = "";
        for (int i = 0; i < getQuizzes().size(); i++) {
            if (i != getQuizzes().size() - 1){
                quizReport = quizReport + getQuizzes().get(i) + ", ";
            } else{
                quizReport = quizReport + getQuizzes().get(i);
            }
        }

        return quizReport;
    }

    private String getHomeworksReport() {
        String homeworkReport = "";
        for (int i = 0; i < getHomeworks().size(); i++) {
            if (i != getHomeworks().size() - 1){
                homeworkReport = homeworkReport + getHomeworks().get(i) + ", ";
            } else{
                homeworkReport = homeworkReport + getHomeworks().get(i);
            }
        }

        return homeworkReport;
    }

    private String getExamsReport() {
        String examReport = "";
        for (int i = 0; i < getExams().size(); i++) {
            if (i != getExams().size() - 1){
                examReport = examReport + getExams().get(i) + ", ";
            } else{
                examReport = examReport + getExams().get(i);
            }
        }

        return examReport;
    }

    private String getProjectsReport() {
        String projectReport = "";
        for (int i = 0; i < getProjects().size(); i++) {
            if (i != getProjects().size() - 1){
                projectReport = projectReport + getProjects().get(i) + ", ";
            } else{
                projectReport = projectReport + getProjects().get(i);
            }
        }

        return projectReport;
    }


}
