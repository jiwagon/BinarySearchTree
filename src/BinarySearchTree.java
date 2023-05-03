
public class BinarySearchTree {

    //Attribute
    Node<Album> root;

    //Constructor
    public BinarySearchTree() {
        root = null;
    }

    public Node<Album> insertNode(Node<Album> current, Album data) {
        if (current != null) {
            if (current.data.compareTo(data) > 0)
                current = current.leftChild;
            else if (current.data.compareTo(data) < 0)
                current = current.rightChild;
        }
        else {
            current = new Node<>(data);
        }
        return current;
    }
    public void insert(Album data) {
        this.root = insertNode(this.root, data);
    }

    public Node delete(Album data){
        return deleteNode(this.root, data);
    }

    public Node deleteNode(Node<Album> current, Album data){
        Node<Album> result = new Node<>(null);
        try{
            if (current == null) {
                throw new IndexOutOfBoundsException();
            }
            if (current.data.compareTo(data) == 0) {
                result.data = current.data;
                current.data = minValue(current.rightChild, current.data);
                return result;
            }
            if (current.data.compareTo(data) == 1) {
                return deleteNode(current.leftChild, data);
            } else {
                return deleteNode(current.rightChild, data);
            }
        }catch (Exception e){
            System.out.println("This Album to delete is not in the tree!!");
        }
        return null;
    }

    public Album minValue(Node<Album> curr_root, Node<Album> pre_root){
        Album minimum = curr_root.data;
        while (curr_root.leftChild != null){
            minimum = curr_root.leftChild.data;
            pre_root = curr_root;
            curr_root = curr_root.leftChild;
        }
        if(curr_root.rightChild != null){
            pre_root.rightChild = curr_root.rightChild;
        }
        else{
            pre_root.data = curr_root.data;
            pre_root.rightChild = curr_root.rightChild;
        }
        return minimum;
    }
}
