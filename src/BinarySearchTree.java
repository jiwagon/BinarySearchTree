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
            if (current.album.compareTo(album1) > 0)
                current = current.leftChild;
            else if (current.album.compareTo(album1) < 0)
                current = current.rightChild;
        }
        else {
            current = new Node<>(album1);
        }
    }
    public Node<Album> insert(Album album1) {
        //Node<Album> insertNode = new Node<>(album1);
        //this.root = insert(this.root, album1);
        insert(this.root, album1);
        return this.root;
    }
}
