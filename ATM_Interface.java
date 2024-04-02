
import java.util.Scanner;

interface ATMProgramProcessable {

    void deposit (double amt);
    void withdrawal (double amt);
    void checkBalance ();

}

class ATMMachine implements ATMProgramProcessable {

    double ownerBalance;

    public void setOwnerBalance (double ownerBalance) {

        this.ownerBalance = ownerBalance;

    }

    public double  getOwnerBalance () {

        return ownerBalance;
    }

    @Override
    public void deposit (double amt) {

        ownerBalance = ownerBalance + amt;
        setOwnerBalance(ownerBalance);

    }//end deposite

    @Override
    public void withdrawal (double amt) {

        ownerBalance = ownerBalance - amt;
        setOwnerBalance(ownerBalance);

    }//end withdrawal

    @Override
    public void  checkBalance () {

        System.out.print("\nYour current balance is : "+getOwnerBalance()+" Rs. ");

    }//end checkBalance

}//end ATM_machine

class ATMProcesses extends ATMMachine {

    Scanner s = new Scanner (System.in);

    private String ownerPassword;

    public void setOwnerPassword (String ownerPassword) {

        this.ownerPassword = ownerPassword;

    }

    public String getOwnerPassword () {

        return ownerPassword;

    }

    public void processes () {

        while (true) { 

            System.out.print("\n1 Deposit\n2 Withdrawal\n3 Check balance\n4 Exit");
            System.out.print("\nEnter your choice : ");
            int ch = s.nextInt();

            if(ch == 4) {//for exit option
                System.out.print("\nThank you for using our ATM.");
                break;
            }

            switch (ch) {

                case 1 :System.out.print("\nEnter amount to deposit : ");
                        double depositAmt = s.nextDouble();
                        deposit(depositAmt);
                        System.out.print("Amount "+depositAmt+" Rs. deposited successfully.");
                        System.out.println("");
                        break;

                case 2 :System.out.print("\nEnter amount to withdraw : ");
                        double withdrawalAmt = s.nextDouble();

                        if(withdrawalAmt <= ownerBalance) {
                            //checking for sufficient balance to withdraw required amount
                            withdrawal(withdrawalAmt);
                            System.out.println("Withdrawal of "+ withdrawalAmt +" Rs. successful.");
                            System.out.println("");
                        }

                        else {

                            System.out.print("\nInsufficient balance...!!");
                            System.out.println("");
                        }

                        break;

                case 3 :checkBalance();
                        System.out.println("");
                        break;

                default:System.out.print("\nInvalid choice...!!");
                        System.out.print("\nPlease try again.");
                        System.out.println("");
                        break;

            }//end switch

        }//end while loop

    }//end processes

    public void closeScanner () {
        s.close();
    }

}//end ATMProcesses

public class ATM_Interface {

    public static void main(String[] args) {

        Scanner s = new Scanner (System.in);

        ATMProcesses atmprocesses = new ATMProcesses ();
        System.out.print("\nEnter initial balance : ");
        double initialBalance = s.nextDouble();
        atmprocesses.setOwnerBalance(initialBalance);
        atmprocesses.setOwnerPassword("6789");

        while (true) {

            System.out.print("\nEnter password : ");
            String password = s.next();

            if(password.equals(atmprocesses.getOwnerPassword())) {

                System.out.print("\nLogged in successfully!");
                System.out.println("");
                atmprocesses.processes();
                break;

            }

            else {

                System.out.print("\nInvalid password! Try again!");
                System.out.println("");

            }

        }//end while

        s.close();

    }//end main method

}//end main class 