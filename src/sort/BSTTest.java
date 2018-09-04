package sort;

public class BSTTest {
    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(8,5);
        bst.insert(2,5);
        bst.insert(5,5);
        bst.insert(7,5);
        bst.insert(6,5);
        bst.insert(4,5);

        System.out.println(bst.floor(4));

    }
}
