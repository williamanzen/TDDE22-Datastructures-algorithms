public class AVLTry {
    
    public static void main(String[] args) {
    
        AVLTree<Integer> tree = new AVLTree<>();
        //First case, left left
        tree.insert(20);
        tree.insert(15);
        tree.insert(10);
        tree.print();

        //second case, left right
        tree.insert(5);
        tree.insert(7);
        tree.print();

        //third case, right right
        tree.insert(30);
        tree.print();

        //fourth case, right left
        tree.insert(35);
        tree.insert(31);
        tree.print();

        //fifth case bigger tree imbalance left left
        tree.insert(13);
        tree.print();

        
        

    }
}
