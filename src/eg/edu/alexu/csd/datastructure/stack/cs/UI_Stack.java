package eg.edu.alexu.csd.datastructure.stack.cs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI_Stack {

    private static Scanner in = new Scanner(System.in);
    static MyStack stack = new MyStack();

    /**
     * main method which run when the compiler start
     *
     * @param args .
     */
    public static void main(String[] args) {
        menu();
        int choice;
        boolean exit = false;
        while (!exit) {
            choice = getInt();
            switch (choice) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    Push();
                    break;
                case 2:
                    Pop();
                    break;
                case 3:
                    Peek();
                    break;
                case 4:
                    Get_size();
                    break;
                case 5:
                    Check_if_empty();
                    break;
                case 6:
                    menu();
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
    public static void menu() {
        System.out.println("\t\t\t\t WELCOME");
        System.out.println("Please choose an action.");
        System.out.println("\n-----------------------\n");
        System.out.println("1: Push\n" +
                "2: Pop\n" +
                "3: Peek\n" +
                "4: Get size\n" +
                "5: Check if empty\n" +
                "6:To show menu\n" +
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
        choice = in.next();
        in.nextLine();
        return choice;
    }

    /**
     * Pushes an item onto the top of this stack.
     */
    public static void Push(){
        String input;
        System.out.println("please enter the value you want to push in");
        input=getString();
        stack.push(input);

    }

    /**
     * Removes the element at the top of stack and returns that element.
     */

    public static void Pop (){
        Object output;
        output=stack.pop();
        System.out.println("The Poped Element is :"+output);
    }

    /**
     * Get the element at the top of stack without removing it from stack.
     */
    public static void Peek(){
        Object output;
        output=stack.peek();
        System.out.println("The Peeked Element is :"+output);
    }

    /**
     * Returns the number of elements in the stack.
     */

    public static void Get_size(){
        int output;
        output=stack.size();
        System.out.println("The size is :"+output);
    }

    /**
     * Tests if this stack is empty
     */

    public static void Check_if_empty(){
        boolean output;
        output=stack.isEmpty();
        if (output)
            System.out.println("The Stack is Empty");
        else
            System.out.println("The Stack is not Empty");
    }


}
