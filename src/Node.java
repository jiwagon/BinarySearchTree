public class Node <Album>{

    Album album;

    Node<Album> leftChild;

    Node<Album> rightChild;

    // constructor
    public Node(Album album1) {
        this.album = album1;
        this.leftChild = null;
        this.rightChild = null;
    }
}
