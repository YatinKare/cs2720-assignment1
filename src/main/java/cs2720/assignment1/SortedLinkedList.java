package cs2720.assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.NullPointerException;
import java.util.NoSuchElementException;

/**
 * A class that holds a sorted linked list structure of ItemType objects using NodeTypes.
 */
public class SortedLinkedList {
    private NodeType head;



    /**
     * Initializes head variable for first node.
     */
    public SortedLinkedList() {
        setNodes();

    }
    /**
     * Sets the inital nodes by inserting them into the current list from the file.
     */
    private void setNodes() {
        String listFromFile = "";

        try {
            Scanner s = new Scanner(new File("resources/input.txt"));
            listFromFile = s.nextLine();
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } // try - catch
        String[] initialStrings = listFromFile.split(" ");

        NodeType current = head;


        for (String s : initialStrings) {
            this.insertValue(s);

        } // for


    }


    /**
     * returns the length of the list.
     *
     * @returns list length;
     */
    public int getLength() {
        NodeType n = this.head;
        int count = 1;
        if (n == null) {
            return 0;
        }
        while (n.next != null) {
            count++;
            n = n.next;
        } // while

        return count;
    } // getLength

    // Prints the whole list from the file
    public String printAll() {
        String listFromFile = "";

        try {
            Scanner s = new Scanner(new File("resources/input.txt"));
            if (s.hasNextLine()) {
                listFromFile = s.nextLine();
            }
            s.close();
            return listFromFile;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } // try - catch
        return "";

    } // printAll

    // Prints the length of the list using the getLength method.
    public String printLength() {
        return ("The length of the list is: " + String.valueOf(getLength()));
    } // printLength

    // Searches the list using value of and returns an integer of its pos.
    // if the list is empty return 0.
    // if item not found return -1.
    public int searchValue(int s) {
        NodeType n = head;
        int count = 1;

        if (getLength() == 0 ) {
            return 0;
        }

        while (n != null) {
            if (n.info.equals(s)) {
                return count;
            }
            n = n.next;
            count++;
        } // while
        return -1;
    } // searchValue

    // inserts a number into the current list based on its order.
    // searches for number greater than inputed choice and puts the new node behind the above node.
    // if the item exists, do nothing.
    public void insertValue(String insertChoice) {
        try {
            int val = Integer.parseInt(insertChoice);
            NodeType n = head;
            NodeType newNode = new NodeType();

            newNode.info = new ItemType();
            newNode.info.initialize(val);

            if (searchValue(val) > 0 ) {
                System.out.println("Item already exists");
                return;
            }
            if (head == null) {
                head = newNode;
            } else if (head.info.getValue() > val) {
                newNode.next = head;
                head = newNode;
            } else {
                while (n.next != null && n.next.info.getValue() < val) {
                    n = n.next;
                }

                newNode.next = n.next;
                n.next = newNode;

            }

            String writeToFile = "";
            NodeType temp = head;
            while (temp != null) {
                writeToFile += String.valueOf(temp.info.getValue()) + " ";

                temp = temp.next;

            };

            FileWriter w = new FileWriter("resources/input.txt");
            BufferedWriter bw = new BufferedWriter(w);
            bw.write(writeToFile);
            bw.close();
        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
        } // try - catch
    }
    // deltes the value given
    // if no item exists, do not delete anything.
    public void deleteValue(String deleteChoice) {

        int val = Integer.parseInt(deleteChoice);
        if (this.head == null) {
            System.out.println("You cannot delete from an empty list");
            return;
        }

        if (this.head.info.getValue() == val) {
            this.head = this.head.next;
            this.saveToFile();
            return;
        }

        NodeType n = this.head;
        NodeType prev = null;

        while (n != null && n.info.getValue() != val) {
            prev = n;
            n = n.next;
        }

        if (n == null) {
            System.out.println("The item is not present in the list");
            return;
        }

        prev.next = n.next;
        this.saveToFile();

        System.out.println("New list: " + this.printAll());
    }
    // saves current list to file.
    public void saveToFile() {
        try {
            String writeToFile = "";
            NodeType temp = this.head;


            while (temp != null) {
                writeToFile += String.valueOf(temp.info.getValue()) + " ";

                temp = temp.next;

            };

            FileWriter w = new FileWriter("resources/input.txt");
            BufferedWriter bw = new BufferedWriter(w);
            bw.write(writeToFile);
            bw.close();
            System.out.println("New list: " + this.printAll());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // delete alternate value in O(n) tme complexity of current list.
    public void deleteAltValue() {

        if (this.head == null) {
            System.out.println("The list is empty");
            return;
        }

        NodeType prev = head;
        NodeType n = head.next;

        while (prev != null && n != null) {
            prev.next = n.next;

            n = null;

            prev = prev.next;
            if (prev != null) {
                n = prev.next;
            }
        }

        this.saveToFile();

    }
    // mergest two list via user input
    public void mergeLists(String mergeChoice) {
        String[] list2 = mergeChoice.split(" ");

        for ( String s : list2) {
            this.insertValue(s);
        }

        this.saveToFile();
    }
    // intersects two list via user input.
    public void intersection(String intersectionChoice) {
        System.out.println("List 2: " + intersectionChoice);
        String[] list2 = intersectionChoice.split(" ");
        NodeType n = head;
        String finalList = "";

        for (String num : list2) {
            if (this.searchValue(Integer.parseInt(num)) > 0) {
                finalList += num + " ";
            }
        }

        System.out.println("Intersection of Lists: " + finalList);
    }

    public NodeType getHead() {
        return head;
    }
} // SortedLinkedList
