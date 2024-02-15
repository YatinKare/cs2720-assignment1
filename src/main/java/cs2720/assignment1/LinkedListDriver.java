package cs2720.assignment1;

import java.util.Scanner;

/**
 * Hello world!.
 *
 */
public class LinkedListDriver {
    public static void main( String[] args ) {
        SortedLinkedList s = new SortedLinkedList();
        Scanner scan = new Scanner(System.in);
        String userChoice = "";
        Boolean v = true;
        String[] choices = {"i", "d", "s", "a", "m", "t", "p", "l", "q"};


        while (true) {
            if (userChoice.equals("q")) {
                break;
            } else if (containsChoice(userChoice, choices) || userChoice == "") {
                if (v) {
                    System.out.print("Enter a command: ");
                    userChoice = scan.nextLine();
                }

                if (userChoice.equals("p")) {
                    System.out.println("The list is: " + s.printAll());
                    v = true;
                } else if (userChoice.equals("l")) {
                    System.out.println(s.printLength());
                    v = true;
                } else if (userChoice.equals("s")) {
                    System.out.print("Enter a number to search: ");
                    String searchChoice = scan.nextLine();
                    System.out.println("Original list: " + s.printAll());
                    searchValue(searchChoice, s);
                    v = true;
                } else if (userChoice.equals("i")) {
                    System.out.print("Enter a number to insert: ");
                    String insertChoice = scan.nextLine();
                    System.out.println("Original list: " + s.printAll());
                    s.insertValue(insertChoice);
                    System.out.println("New list: " + s.printAll());
                } else if (userChoice.equals("d")) {
                    System.out.print("Enter a number to delete: ");
                    String deleteChoice = scan.nextLine();
                    System.out.println("Original list: " + s.printAll());
                    s.deleteValue(deleteChoice);

                    System.out.println("New list: " + s.printAll());

                } else if (userChoice.equals("a")) {
                    System.out.println("Original list: " + s.printAll());
                    s.deleteAltValue();
                } else if (userChoice.equals("m")) {
                    System.out.print("Enter the length of the new list: ");
                    String u = scan.nextLine();
                    System.out.print("Enter the numbers: ");
                    String mergeChoice = scan.nextLine();

                    System.out.println("List 1: " + s.printAll());
                    System.out.println("List 2: " + mergeChoice);

                    s.mergeLists(mergeChoice);

                } else if (userChoice.equals("t")) {
                    System.out.print("Enter the length of the new list: ");
                    String u = scan.nextLine();
                    System.out.print("Enter the numbers: ");
                    String intersectionChoice = scan.nextLine();

                    System.out.println("List 1: " + s.printAll());
                    s.intersection(intersectionChoice);

                }

            } else {
                System.out.print("Invalid command try again: ");
                userChoice = scan.nextLine();
                v = false;
            }
        } // while

        System.out.println("Exiting the program..." );
        System.out.println(s);
        scan.close();
    }

    private static boolean containsChoice(String s, String[] c) {
        for (int i = 0; i < c.length - 1; i++) {
            if (s.equals(c[i])) {
                return true;
            }
        }
        return false;
    } // containsChoice

    private static void searchValue(String userChoice, SortedLinkedList s) {

        int val = s.searchValue(Integer.parseInt(userChoice));
        System.out.println(val);
        if (val == -1) {
            System.out.println("Item is not present in the list");
        } else if (val == 0) {
            System.out.println("The list is empty");
        } else {
            System.out.println("The item is present at index: " + val);
        }
    } // searchValue
}
