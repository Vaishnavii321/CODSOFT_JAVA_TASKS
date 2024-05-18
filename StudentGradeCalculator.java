//TASK 2
import java.util.*;

class Grade{
    public String grade(int avgp){
        if(avgp >= 90){
            return "A";
        }
        else if(avgp >= 80 && avgp < 90){
            return "B";
        }
        else if(avgp >= 70 && avgp < 80){
            return "C";
        }
        else if(avgp >=60 && avgp < 70){
            return "D";
        }
        else if(avgp >=50 && avgp <60){
            return "E";
        }
        else{
            return "F";
        }
    }
}

public class StudentGradeCalculator {
    public static void main(String args[]){
        Grade g = new Grade();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of subjects :-");
        int tsubs = sc.nextInt();
        int tmarks = 0;

        for(int i = 0; i < tsubs; i++){
            System.out.println("Enter the marks obtain in subject " + (i+1));
            int marks = sc.nextInt();
            tmarks += marks;
        }

        //calculating pecentage 
        int avgp = tmarks / tsubs;
        
        //calculating  grade
        String Grade = g.grade(avgp);

        //displaying the result 
        System.out.println("Total marks obtained: " + tmarks);
        System.out.println("percentage obtained: " + avgp + "%");
        System.out.println("Grade Obtained: " + Grade);

        sc.close();
    }
}
