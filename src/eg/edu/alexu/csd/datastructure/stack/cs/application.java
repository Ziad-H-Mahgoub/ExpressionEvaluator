package eg.edu.alexu.csd.datastructure.stack.cs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class application {
    private static Scanner in = new Scanner(System.in);

    /**
     * the main method which run by the compiler
     *
     * @param args .
     */
    public static void main(String[] args) {
        menu1();
        int choice;
        boolean exit = false;
        while (!exit) {
            choice = getInt();
            switch (choice) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    Full_Aplication();
                    break;
                case 2:
                    Splitted_Aplication();
                    break;
                default:
                    System.out.println("Error enter valid choice!");
            }
        }
        System.out.println("Press any key to continue.");
        in.nextLine();

    }

    /**
     * this method use to display only user interface
     */
    public static void menu1() {
        System.out.println("\t\t\t\t WELCOME");
        System.out.println("Please choose an action.");
        System.out.println("\n-----------------------\n");
        System.out.println("1: Full Application \n" +
                "2: Splitted Application\n" +
                "0-To Exit"
        );
    }

    /**
     * this method use to display only user interface
     */

    public static void menu2() {
        System.out.println("Please choose an action.");
        System.out.println("\n-----------------------\n");
        System.out.println("1: infixToPostfix \n" +
                "2: evaluate\n" +
                "0-To Exit"
        );
    }

    /**
     * this method use to display only user interface
     */
    public static void menu3() {
        System.out.println("Please choose an action.");
        System.out.println("\n-----------------------\n");
        System.out.println("1: ExpressionEvaluator \n" +
                "0-To Exit"
        );
    }


    /**
     * get the value as integer from the user
     *
     * @return the integer input
     */

    public static int getInt() {
        while (true) {
            System.out.print("Enter your choice: \r");
            int choice;
            try {
                choice = in.nextInt();
                in.nextLine();
                return choice;
            } catch (InputMismatchException e) {
                in.nextLine();
                System.out.println("Enter valid integer!");
            }
        }
    }

    /**
     * get the value as string from the user
     *
     * @return the value input from user as string
     */
    public static String getString() {
        System.out.print("Enter your choice: \r");
        String choice;
        choice = in.nextLine();
        return choice;
    }

    /**
     * this method test every interal method alone
     */
    public static void Splitted_Aplication(){
        menu2();
        int choice;
        boolean exit = false;
        while (!exit) {
            choice = getInt();
            switch (choice) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    infixToPostfix();
                    break;
                case 2:
                    evaluate();
                    break;
                default:
                    System.out.println("Error enter valid choice!");
            }
        }
        System.out.println("Press any key to continue.");
        in.nextLine();
    }

    /**
     * Takes a symbolic/numeric infix expression as input and converts it to
     * postfix notation. There is no assumption on spaces between terms or the
     * length of the term (e.g., two digits symbolic or numeric term)
     *
     * infix expression
     * postfix expression
     */
    public static void infixToPostfix(){
         ExpressionEvaluator test = new ExpressionEvaluator();
        String input,output;
        System.out.println("please enter your input");
        input = getString();
        output=test.infixToPostfix(input);
        System.out.println("The Expression after change is : "+ output);
    }

    /**
     * Evaluate a postfix numeric expression, with a single space separator
     * postfix expression
     *
     *  the expression evaluated value .
     */

    public static void evaluate(){
         ExpressionEvaluator test = new ExpressionEvaluator();
        String input;
        int output;
        System.out.println("please enter your input");
        input = getString();
        output=test.evaluate(input);
        System.out.println("The Expression value is : "+ output);
    }

    /**
     * test the two internal methods at one step
     */
    public static void Full_Aplication(){
        menu3();
        int choice;
        boolean exit = false;
        while (!exit) {
            choice = getInt();
            switch (choice) {
                case 0:
                    exit = true;
                    break;
                case 1:
                   Expression_Evaluator();
                    break;
                default:
                    System.out.println("Error enter valid choice!");
            }
        }
        System.out.println("Press any key to continue.");
        in.nextLine();

    }

    /**
     *
     *  Takes a symbolic/numeric infix expression as input and converts it to
     *  postfix notation. There is no assumption on spaces between terms or the
     *  length of the term (e.g., two digits symbolic or numeric term)
     * Evaluate a postfix numeric expression, with a single space separator
     *
     *   postfix expression
     *   the expression evaluated value
     *
     */
    public static void Expression_Evaluator(){
        ExpressionEvaluator test = new ExpressionEvaluator();
        int i=0,j;
        String input,temp;
        char ch;
        boolean check = false;
        SingleLinked list1 = new SingleLinked();
        SingleLinked list2 = new SingleLinked();


        System.out.println("please enter your input");
        input = getString();
        temp=test.infixToPostfix(input);



        while (i<input.length()){
            ch=input.charAt(i);
            if ((ch <= 'z' && ch >= 'a')||(ch >= 'A' && ch <= 'Z')) {
                j = 0;
                while (j<list1.size()) {
                    if (ch == (char) list1.get(j)) {
                        check = true;
                        break;
                    }
                    j++;
                }
                if (!check) {
                    list1.add(ch);
                }
                check = false;
            }
            i++;
        }
        j=0;

        while (j<list1.size()){
            System.out.println("please enter the Value of "+list1.get(j)+" = ");
            temp = getString();
            list2.add(temp);
            j++;
        }

        i=0;
        char ch1;
        StringBuilder new_input = new StringBuilder();
        check=false;


        while (i<input.length()){
            ch1=input.charAt(i);
            if ((ch1 <= 'z' && ch1 >= 'a')||(ch1 >= 'A' && ch1 <= 'Z')) {
                j = 0;
                while (j<list1.size()) {
                    if (ch1 == (char) list1.get(j)) {
                        check = true;
                        break;
                    }
                    j++;
                }
                if (check)
                    new_input.append(list2.get(j));
                check = false;
            }
            else {
                new_input.append(ch1);
            }
            i++;
        }
        System.out.println("//////////////////////////////////////////////////////");
        System.out.println("\t\t\tYour Input is :");
        System.out.println("\t\t\t"+new_input);
        System.out.println("//////////////////////////////////////////////////////");
        new_input = new StringBuilder(test.infixToPostfix(new_input.toString()));
        System.out.println("\t\t\tThe Postfix Expression is : ");
        System.out.println("\t\t\t"+new_input);
        System.out.println("//////////////////////////////////////////////////////");
        System.out.println("\t\t\tthe result is :");
        System.out.println("\t\t\t"+test.evaluate(new_input.toString()));

    }


}
