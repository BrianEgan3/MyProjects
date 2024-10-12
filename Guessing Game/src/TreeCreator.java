public class TreeCreator {
    public static void createTree(BinaryTree<String> tree) //this creates a sample tree
    {
        BinaryTree<String> h = new BinaryTree<String>("Is it an Elephant?");
        BinaryTree<String> i = new BinaryTree<String>("Is it a Dog?");

        BinaryTree<String> j = new BinaryTree<String>("Is it a Crow?");
        BinaryTree<String> k = new BinaryTree<String>("Is it a Whale?");

        BinaryTree<String> l = new BinaryTree<String>("Is it a goldfish?");
        BinaryTree<String> m = new BinaryTree<String>("Is it a salmon?");

        BinaryTree<String> n = new BinaryTree<String>("Is it an Ant?");
        BinaryTree<String> o = new BinaryTree<String>("Are you thinking of an animal at all?");


        BinaryTree<String> d = new BinaryTree<String>("Is it a big animal?", h, i);
        BinaryTree<String> e = new BinaryTree<String>("Is it a bird?", j, k);

        BinaryTree<String> f = new BinaryTree<String>("Can it be a pet?", l, m);
        BinaryTree<String> g = new BinaryTree<String>("Are you thinking of an insect?", n, o);


        BinaryTree<String> b = new BinaryTree<String>("Is it a land animal?", d, e);//first left node
        BinaryTree<String> c = new BinaryTree<String>("Are you thinking of a fish?", f, g); //makes the first right node


        tree.setTree("Are you thinking of a mammal?", b, c); //sets the root of the tree
    }
}
