import java.util.Random;
import java.util.Scanner;

class Game{
    public int number;
    public int inputNumber;
    public int noOfGuesses = 0;

    public int getNoOfGuesses(){
        return noOfGuesses;
    }

    public void setNoOfGuesses(int noOfGuesses){
        this.noOfGuesses = noOfGuesses;
    }

    Game(){
        Random rand = new Random();
        this.number = rand.nextInt(100);
    }

    void takeuserInput(){
        System.out.println("Guess the number:");
        Scanner sc = new Scanner(System.in);
        inputNumber = sc.nextInt();
    }

    boolean isCorrectNumber(){
        
        if(inputNumber == number){
            return true;
        }
        else if(inputNumber < number){
            System.out.println("Too less!!!!\n");
        }
        else if(inputNumber > number){
            System.out.println("Too high!!!!\n");
        }
        return false;
    }
}

public class numberGame {
    
    public static void main(String args[]){
        Game g = new Game();
        int noOfAttempts = 0;
        boolean b = false;
        while(noOfAttempts < 8 && !b){
            noOfAttempts++;
            g.takeuserInput();
            b = g.isCorrectNumber();
        }
        if(b){
            System.out.format("Congratulations! You guessed the right number :) \nYou guessed it in %d attempts", noOfAttempts);
        }else{
            System.out.println("You lost. Number of attempts exhausted ");
        }
        
    }
    
}
