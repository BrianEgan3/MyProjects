import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TreeLoader {
    public static BinaryTree<String> loadTree () {
        try {
            FileInputStream file = new FileInputStream("treeGame.txt"); //file which contains the tree
            ObjectInputStream in = new ObjectInputStream(file); //class that reads and writes strings to a file

            // Method for deserialization of object
            String serializedData = (String)in.readObject(); //file saved as a striing

            in.close();//stops the object input stream from doing any more
            file.close();

           // System.out.println("Object has been deserialized ");
            //System.out.println("String loaded = " + serializedData);

            BinaryTree<String> loadedData = deserialize(serializedData);

            return loadedData;

        }

        catch (IOException ex) {//file error exception
            System.out.println("IOException is caught");
        }

        catch(ClassNotFoundException ex) {//file error exception

            System.out.println("ClassNotFoundException is caught");
        }
        return null;
    }
    public static BinaryTree<String> deserialize(String data) {//makes the data readable
        if(data == null) {
            return null; //returns null if theres no data or when its all done
        }
        int[] position = {0}; //tracks the current index in the recursion
        String[] nodeValues = data.split(","); //seperates the string into an array. Breaks it wherever there is ,

        return treeFromArray(nodeValues, position);
    }

    public static BinaryTree<String> treeFromArray(String[] nodeValues, int[] position) {//this method creates a tree from the array given to it in the other method
        if(nodeValues[position[0]].equals("~")) {
            return null;
        }

        BinaryTree<String> root = new BinaryTree<String>(nodeValues[position[0]], treeFromArray(nodeValues, position), treeFromArray(nodeValues, position)); //recursion

        return root;
    }
}