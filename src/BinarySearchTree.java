public class BinarySearchTree {

    //Attribute
    Node<Album> root;

    //Constructor
    public BinarySearchTree() {
        root = null;
    }

    //method overloading
//    public Node<Album> insert(Node<Album> root, Album album1) {
//        return root;
//    }

    public void insert(Node<Album> current, Album album1) {
        if (current != null) {
        }
    }
    public Node<Album> insert(Album album1) {
        //Node<Album> insertNode = new Node<>(album1);
        //this.root = insert(this.root, album1);
        insert(this.root, album1);
        return this.root;
    }
}
