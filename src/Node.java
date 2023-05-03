public class Node <T>{

    Album data;

    Node<T> leftChild;

    Node<T> rightChild;

    // constructor
    public Node(Album data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }
}
