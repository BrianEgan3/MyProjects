import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Stack;

public class TreeSaver {
     String fileName = "treeGame.txt";
     FileOutputStream file;

    public void saveTree(BinaryTree<String> testTree) {

        Stack<BinaryNode> stack = new Stack<BinaryNode>(); //stack which containes binary nodes
        stack.push((BinaryNode) testTree.getRootNode()); //pushes the first node in the tree into a stack
        StringBuilder stringBuilder = new StringBuilder();//string builder object

        while (!stack.isEmpty()) { //works if the first node is in the stack
            BinaryNode h = stack.pop();
            if (h != null) {
                stringBuilder.append(h.getData() + ","); //, sets a node in the tree as a left child
                stack.push((BinaryNode) h.getRightChild());
                stack.push((BinaryNode) h.getLeftChild());
            } else {
                stringBuilder.append("~,");//anything right in the tree is seperated by a ~
            }
        }

        try {//needed for exceptions in the file classes
            file = new FileOutputStream(fileName);
            ObjectOutputStream outputStream = new ObjectOutputStream(file);//objects to add things to the file

            outputStream.writeObject(stringBuilder.toString().substring(0, stringBuilder.length() - 1));
            outputStream.close();//stops more stuff being saved to the file
            file.close();//saves the file

            System.out.println("Save Complete\n Data Stored: "); //message if the file saves properly
        }
        catch (IOException ex) {//error message
            System.out.println("IOException caught");
        }

    }
}
