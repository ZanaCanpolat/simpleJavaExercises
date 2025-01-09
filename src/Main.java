import java.util.InputMismatchException;
//The Scanner class gives us a way to listen and get user input.
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        // Declaration of variables
        //Scanner creates instance of the Scanner object that gives us tool to read from keyboard
        Scanner scanner = new Scanner(System.in);
        int firstNumber;
        int secondNumber;
        int thirdNumber;
        float i;
        String name;


        //Exercise 1
        //System.out.println prints one line and goes down
        System.out.println("First exercise 1:");
        System.out.println("Hello");
        System.out.println("Zana");
        System.out.println(); // This code adds an empty line, just for keeping it nice and clean

        // Exercise II
        System.out.println("Second exercise 2:");
        System.out.println("Give me a number: ");
       // int leapYear = scanner.nextInt();

        if ((scanner.nextInt() % 4) == 0)
            System.out.println("It is a leap year!");
        else
            System.out.println("It is not a leap year!");


/*
        Using the controlInput method in this exercise creates a problem, asks twice to give a number
        // Check if the given year is a leap year
        if (controlInput() % 4 == 0) {
            System.out.println(controlInput() + " is a `leap year`!");
        } else {
            System.out.println(controlInput() + " is not a leap year !");
        }
 */

        // Exercise 3
        System.out.println();
        System.out.println("Third exercise 3: ");
        System.out.println("This exercise below is mathematical test!");

        firstNumber = controlInput();
        secondNumber = controlInput();

        System.out.println("Sum of: " + firstNumber + "+" + secondNumber + "=" + (firstNumber + secondNumber));
        System.out.println("Multiplication of: " + firstNumber + "*" + secondNumber + "=" + (firstNumber * secondNumber));
        // This line below uses a simple type cast to change integer to a float value
        i = (float) firstNumber / secondNumber;
        System.out.println("Division of: " + firstNumber + "/" + secondNumber + "=" + i);

        //Exercise IV
        System.out.println();
        System.out.println("Fourth exercise 4: ");
        System.out.println("This exercise prints the average of three numbers");
        firstNumber = controlInput();
        secondNumber = controlInput();
        thirdNumber = controlInput();
        i = (float) (firstNumber + secondNumber + thirdNumber) / 3;
        System.out.println("Average of: " + firstNumber + "+" + secondNumber + "+" + thirdNumber + "is: " + i);

        //Exercise V
        System.out.println();
        System.out.println("Fifth exercise 5: ");
        System.out.println("This exercise asks the user for an input, saves the input and prints it on the screen.");
        System.out.print("Your name? ");
        name = scanner.next();
        System.out.println("Hello " + name);

        //Exercise 6
        System.out.println();
        System.out.println("Sixth exercise 6: ");
        System.out.println("This takes two nr and gives result for addition, multiplication, division and subtraction");

        firstNumber = controlInput();
        secondNumber = controlInput();

        System.out.println("Sum of: " + firstNumber + "+" + secondNumber + "=" + (firstNumber + secondNumber));
        System.out.println("Multiplication of: " + firstNumber + "*" + secondNumber + "=" + (firstNumber * secondNumber));
        // This line below uses a simple type cast to change integer to a float value
        i = (float) firstNumber / secondNumber;
        System.out.println("Division of: " + firstNumber + "/" + secondNumber + "=" + i);
        System.out.println("Subtraction of: " +firstNumber + "-" +secondNumber + "=" + (firstNumber - secondNumber));

        //Exercise 7
        System.out.println();
        System.out.println("Seventh exercise 7: ");
        System.out.println("This asks for a number and returns the value converted to HH:MM:SS");
        System.out.println(convertSecondToHour());

        //Exercise 8
        System.out.println();
        System.out.println("Eight exercise 8: ");
        System.out.println("The program generates an random nr that user must guess");
        guessTheNumber();


    }

    public static Integer mathRandomNumber() {
        //For this function it is possible to also use Random
        // I choose to use Math.random, so I could receive an integer between 0 -99

        double randomNumber = Math.random(); //This line gives us a random nr between 0.0 and 1.0

        //Generating an random nr between 0 - 99
        return (int) (randomNumber * 100);
    }

    public static void guessTheNumber () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Guess a number between 0 and 99: ");

        int randomNumber = mathRandomNumber();
        int i = 1;
        int number = scanner.nextInt();

        while (number != randomNumber) {
            //System.out.println(randomNumber); //This is used for debugging
            if (number > randomNumber) {
                System.out.println("Guess a new number, tip `lower´");
                number = controlInput();
            }
            else {
                System.out.println("Guess a new number, tip `higher´");
                number = controlInput();
            }

            i++;
        }
        System.out.println("Congratulations you guessed it, it took you: " + i + " guesses");
    }

    public static String convertSecondToHour() {
        //This method is used to convert an input from the user to hours, minutes and seconds
        int hours;
        int seconds;
        int minutes;
        int input = controlInput(); //this line creates an integer and assigns it with calling of method

        hours = input / 3600;       // One hour is 3600sec
        minutes = (input % 3600) / 60;  // One minute is 60 sec
        seconds = input % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds); //

    }


    public static Integer controlInput() {

        //InputMismatchException page: https://labex.io/tutorials/java-how-to-handle-java-util-inputmismatchexception-417321

        //Creates a Scanner object to read the input and save it inside scanner, created local to save memory
        //this is a local version for the method, when exited, the memory released, how to use global?
        Scanner scanner = new Scanner(System.in);
        // this line will be used to check if the correct input is give, initialized to false for entering loop
        boolean checkInput = false;

        // The block below is error handling, it reads a line, problem will occur if reader inputs a string,
        // the block below handles the case so that the user enters expected input
        // in this method the scanner is reading and expecting an integer (scanner.nextInt()), possible to
        // read different objects such as double, float, string and so on

        while (!checkInput)
        {
            try {
                System.out.print("Give me a number:");
                checkInput = true;
                return scanner.nextInt(); // expects integer, if not an integer throws exception, check block below

            }
            // This block catches the exception if user enters something else than integer
            catch (InputMismatchException exception) {
                System.out.println("It needs to be a number, try again.");
                scanner.nextLine();
            }
        }
        return 0;
    }
}