public class Node <Album>{

    Album data;

    Node<Album> leftChild;

    Node<Album> rightChild;

    // constructor
    public Node(Album data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }
}
