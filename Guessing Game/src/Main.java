//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    static TreeSaver treeSaver = new TreeSaver(); //object to save trees
    static TreeLoader treeLoader = new TreeLoader(); //object which has methods to load trees
    static TreeCreator treeCreator; //object which calls methods that create trees
    static Scanner scanner = new Scanner(System.in); //scanner to get user input

    public static void main(String[] args) {
        BinaryTree<String> testTree = new BinaryTree<String>();
        treeCreator.createTree(testTree); //creates a tree


        //playing the game
        while (true) { //infinite loop so the game will always run unless break is called
            BinaryNodeInterface<String> currentNode = testTree.getRootNode();//sets current node to the root node

            while (currentNode.isLeaf() == false) { //checks if its the final node
                System.out.println(currentNode.getData());
                String userInput = scanner.nextLine();

                if (userInput.equals("yes") || userInput.equals("Yes") || userInput.equals("YES")) { //checks for yes
                    currentNode = currentNode.getLeftChild();//moves to the left child node

                    if (currentNode.isLeaf()) {//if its the final node it makes the user input a new question
                        guess(currentNode, scanner);
                        displayOptions(scanner, testTree);
                    }
                }
                else if (userInput.equals("no")|| userInput.equals("NO")||userInput.equals("No")) {//checks for no
                    currentNode = currentNode.getRightChild(); //moves to the right child node

                    if (currentNode.isLeaf()) {//if its the final node it makes the user input a new question
                        System.out.println(currentNode.getData());
                        String finalUserInput = scanner.nextLine();

                        if (finalUserInput == "no") {//if its the final node it makes the user input a new question
                            guess(currentNode, scanner);
                        }

                        boolean playAgain = false;
                        while (playAgain == false) {
                            playAgain = displayOptions(scanner, testTree); //gives option to play again or quit
                        }
                        break;
                    }
                }
                else { //if something other than yes or no is entered it makes the user enter it again
                    System.out.println("Invalid Input, 'yes' and 'no' are the only valid userInputs");
                }
            }
        }
    }


    public static void guess(BinaryNodeInterface<String> currentNode, Scanner scanner) {//called whenever the final node is reached

        System.out.println(currentNode.getData());
        String guess = scanner.nextLine();

        //if the guess is correct
        if (guess.equals("yes")||guess.equals("YES")||guess.equals("Yes")) {
            System.out.println("Correct guess!!\n");
        } else if (guess.equals("no")||guess.equals("No")||guess.equals("NO")) {
            System.out.println("What is the correct answer?");
            BinaryNode correctAnswer = new BinaryNode(scanner.nextLine());//creates a new node with the next animal as its string

            System.out.println("Enter a question to expand the tree");
            String newQuestion = scanner.nextLine(); //calls for the user tp input a question

            BinaryNode no = new BinaryNode(currentNode.getData()); //sets new nodes as the last nodes left and right nodes
            currentNode.setData(newQuestion);
            currentNode.setLeftChild(no);
            currentNode.setRightChild(correctAnswer);
        }
    }

    private static boolean displayOptions(Scanner scanner, BinaryTree<String> testTree) { //called when main is finished
        System.out.println("Enter 1 to play again");
        System.out.println("Enter 2 to quit");
        System.out.println("Enter 3 to load a tree");
        System.out.println("Enter 4 to save the current tree");

        String C = scanner.nextLine(); //prompts user input

        switch (C) { //switch case for each possible input
            case "1":
                return true; //returns true to play again
            case "2":
                System.exit(0); //ends the program
            case "3":
                testTree = treeLoader.loadTree(); //loads a tree from the file
            case "4":
                treeSaver.saveTree(testTree); //saves the tree
                break;
        }
        return false;
    }
}