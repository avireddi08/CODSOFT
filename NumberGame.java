
import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    static int cnt = 0;
    static int rounds = 1;

    public static int generateNumber () {
    
    Random r = new Random ();
    int n = r.nextInt(101);//generate random no. within the range 0 to 100 and assigning it's value to n
    return n;

    }//end generateNo

    public static void guessTheNumber (int no) {
        
        Scanner s = new Scanner(System.in);

        //System.out.print(no);

        System.out.print("\n");
        System.out.print("\nEnter your guess b/w range 0 to 100 : ");
        int guess = s.nextInt ();

        if (guess == no) {

            System.out.print("\nCongrats! Your guess is correct.");
            rounds++;

        }

        else if (guess <= no+5 && guess >= no-5) {

            System.out.print("\nYour guess is very close.");
            System.out.print("\nTry again!");
            cnt++;
            if (cnt < 5) {
                guessTheNumber(no);
            }
            else {
                System.out.println("");
                System.out.print("\nYour 5 attempts are over!");//5 attempts are given to user to guess the no.
                rounds++;
            }

        }//end else if

        else {

            if (guess < no) {

                System.out.print("\nYour guess is too low.");
                System.out.print("\nTry again!");
                cnt++;
                if (cnt < 5) {
                    guessTheNumber(no);
                }
                else {
                    System.out.println("");
                    System.out.print("\nYour 5 attempts are over!");//5 attempts are given to user to guess the no.
                    rounds++;
                }


            }//end if

            if (guess > no) {

                System.out.print("\nYour guess is too high.");
                System.out.print("\nTry again!");
                cnt++;
                if (cnt < 5) {
                    guessTheNumber(no);
                }
                else {
                    System.out.println("");
                    System.out.print("\nYour 5 attempts are over!");//5 attempts are given to user to guess the no.
                    rounds++;
                }


            }//end if

        }//end else

    }//end guessNo

    public static void main(String[] args) {

        Scanner s = new Scanner (System.in);

        System.out.print("\nGame details :");
        System.out.print("\n1) A random no. will be generated in the range 0 to 100.");
        System.out.print("\n2) You have to guess that no.");
        System.out.print("\n3) 5 attempts will be given for each round.");
        System.out.print("\n4) You can play multiple rounds.");
        System.out.println("");
        System.out.print("\nGood luck!");

        guessTheNumber(generateNumber());

        while (rounds >= 2) {//option for multiple rounds

            System.out.println("");
            System.out.print("\nDo you want to play again ? ( yes / no ) : ");
            String str = s.next();
            if (str.equals("yes")){

                cnt = 0;//reset attempts counter
                guessTheNumber(generateNumber());

            }

            else {

                System.out.print("\nThank you for playing our game!");
                System.out.print("\nTotal no. of rounds you have played : "+(rounds-1));
                break;

            }

        }

    }//end main method

}//end main class