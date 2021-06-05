/**
 * Represents COMP 1210 grade.
 * @author Wesley Monnette
 * @version Oct 2 2017
 */
public class Grade {
   
   // Variables
   private double exam1, exam2, finalExam;
   private double activityAvg, quizAvg, projectAvg;
   private String studentName;
   
   /**
    * Constants.
    */
   public static final int EXAM_1 = 1, EXAM_2 = 2, FINAL = 3;
   private static final double EXAM_WEIGHT = 0.15, FINAL_WEIGHT = 0.30,
      ACT_WEIGHT = 0.05, QUIZ_WEIGHT = 0.10, PROJ_WEIGHT = 0.25;
      
   /**
    * Grade constructor.
    * @param studentNameIn student's name
    */
   public Grade(String studentNameIn) {
      studentName = studentNameIn;
   }
   
   /**
    * Sets lab average.
    * @param activityAvgIn activity average.
    * @param quizAvgIn quiz average
    */
   public void setLabAverages(double activityAvgIn, double quizAvgIn) {
      activityAvg = activityAvgIn;
      quizAvg = quizAvgIn;
   }
   
   /**
    * Sets project average.
    * @param projectAvgIn project average
    */
   public void setProjectAvg(double projectAvgIn) {
      projectAvg = projectAvgIn;
   }
   
   /**
    * Sets exam scores.
    * @param examType exam indicator
    * @param examScoreIn exam score
    */
   public void setExamScore(int examType, double examScoreIn) {
      if (examType == EXAM_1) {
         exam1 = examScoreIn;
      }
      else if (examType == EXAM_2) {
         exam2 = examScoreIn;
      }
      else if (examType == FINAL) {
         finalExam = examScoreIn;
      }
   }
   
   /**
    * Calculates grade.
    * @return output 
    */
   public double calculateGrade() {
      double grade = exam1 * EXAM_WEIGHT + exam2 * EXAM_WEIGHT
         + finalExam * FINAL_WEIGHT
         + activityAvg * ACT_WEIGHT
         + quizAvg * QUIZ_WEIGHT
         + projectAvg * PROJ_WEIGHT;
      return grade;
   }
   
   /**
    * toString output.
    * @return output 
    */
   public String toString() {
      return "Name: " + studentName + "\n"
         + "Course Grade: " + calculateGrade();
   } 
}