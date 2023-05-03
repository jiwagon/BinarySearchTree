public class BinarySearchTree {

    //Attribute
    Node<Album> root;

    //Constructor
    public BinarySearchTree() {
        root = null;
    }

    public Node<Album> insertNode(Node<Album> current, Album album1) {
        if (current != null) {
            if (current.album.compareTo(album1) > 0)
                current = current.leftChild;
            else if (current.album.compareTo(album1) < 0)
                current = current.rightChild;
        }
        else {
            current = new Node<>(album1);
        }
        return current;
    }
    public void insert(Album album1) {
        this.root = insertNode(this.root, album1);
    }
}
