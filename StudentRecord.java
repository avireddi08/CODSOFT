
import java.util.Scanner;

class StudentGradeCalculator {

    Scanner s = new Scanner (System.in);

    private String studentName;
    private float totalMarks = 0;
    private String grade;
    
    public StudentGradeCalculator (String studentName) {

        this.studentName = studentName;

    }//constructor

    public void displayStudentGrade (int total_subjects) {

        int totalSub = total_subjects;
        int [] marks = new int [totalSub];//array of marks to store marks of each subject

        for (int i = 0; i < totalSub; i++) {

            System.out.print("\nEnter marks of subject-"+(i+1)+" out of 100 : ");
            marks[i] = s.nextInt();

            if (marks[i] >= 0 && marks[i] <= 100) {//ensures that marks are in valid range
                totalMarks = totalMarks + marks[i];
            }

            else {
                System.out.print("\nPlease enter valid marks!");
                i--;//re-prompt for current subject
            }

        }//end for

        float avgPercentage = (totalMarks / totalSub);//calculates average percentage

        if (avgPercentage >= 90) {
            grade = "O";
        }

        else if (avgPercentage >= 75 && avgPercentage < 90) {
            grade = "A";
        }

        else if (avgPercentage >= 60 && avgPercentage < 75) {
            grade = "B";
        }

        else if (avgPercentage >= 40 && avgPercentage < 60) {
            grade = "C";
        }

        else {
            grade = "F";
        }

        //printing student's record
        System.out.print("\nStudent's record : ");
        System.out.print("\nStudent's name : "+studentName);
        System.out.print("\nStudent's total marks in "+totalSub+" subjects : "+totalMarks);
        System.out.print("\nStudent's average percentage : "+avgPercentage);
        System.out.print("\nStudent's grade : "+grade);

    }//end displayStudentGrade

    public void closeScanner () {
        s.close();
    }

}//end StudentGradeCalculator

public class StudentRecord {

    public static void main(String[] args) {

        Scanner s = new Scanner (System.in);
        
        System.out.print("\nEnter student's full name : ");
        String name = s.nextLine();

        while (true) { 
            
            System.out.print("\nEnter total no. of subjects : ");
            int total_subjects = s.nextInt();

            if (total_subjects >= 1 && total_subjects <= 20) {//ensures that no. of subjects is in valid range

                StudentGradeCalculator sgc = new StudentGradeCalculator (name);
                sgc.displayStudentGrade(total_subjects);
                break;

            }

            else {

                System.out.print("\nPlease enter valid no. of subjects (1 to 20) !");

            }
        
        }//end while

        s.close();

    }//end of main method

}//end of main class