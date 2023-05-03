import java.util.ArrayList;

public class BinarySearchTree {

    //Attribute
    Node<Album> root;

    Node<Album> data;

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

    public Node deleteNode(Node<Album> current, Album data){
        Node<Album> result = new Node<>(null);
        try{
            if (current == null) {
                throw new IndexOutOfBoundsException();
            }
            if (current.data.compareTo(data) == 0) {
                result.data = current.data;
                current.data = findMinValue(current.rightChild, current);
                return result;
            }
            // delete the item if it exists
            if (current.data.compareTo(data) == 1) {
                return deleteNode(current.leftChild, data);
            } else {
                return deleteNode(current.rightChild, data);
            }
        }
        // throw an IllegalArgumentException if it doesn't exist
        catch (Exception e){
            System.out.println("This Album to delete is not in the tree!!");
        }
        return null;
    }
    // this should run in O(log n) time
    public Node delete(Album data){
        return deleteNode(this.root, data);
    }

    public Album findMinValue(Node<Album> curr_root, Node<Album> pre_root){
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

    // Return true/false
    // True if the data is in the tree and false if it isn't
    public boolean contains(Album data){
        return this.containsHelper(this.root, data);
    }

    public boolean containsHelper(Node<Album> current, Album data){
        if(current != null){
            // Return true if the data is in the tree
            if(current.data == data){
                return true;
            }else{
                if(data.compareTo(current.data) == 1){
                    return containsHelper(current.rightChild, data);
                }
                else{
                    return containsHelper(current.leftChild, data);
                }
            }
        }
        // Return false if the data isn't in the tree
        return false;
    }

//    public String inOrderTraversal(){
//        return this.inOrder(this.root);
//    }
//
//    private String inOrder(Node current){
//        StringBuilder stringBuilder = new StringBuilder();
//
//        if(current != null){
//            //go left first because this is in order
//            stringBuilder.append(this.inOrder(current.leftChild));
//
//            //append the current node
//            stringBuilder.append(current.data);
//            stringBuilder.append(" ");
//
//            //go right
//            stringBuilder.append(this.inOrder(current.rightChild));
//        }
//        return stringBuilder.toString();
//    }

    public ArrayList<Album> getOrderArrayAlbum(){
        ArrayList<Node> nodes = this.getOrderArrayNode();
        ArrayList<Album> result = new ArrayList<>();
        for(int i = 0;i < nodes.size();i++){
            result.add((Album) nodes.get(i).data);
        }
        return result;
    }
    // Get the data of the tree through an ArrayList format
    public ArrayList<Node> getOrderArrayNode(){
        return this.getOrderArrayHelper(this.root);
    }

    private ArrayList<Node> getOrderArrayHelper(Node current){
        ArrayList<Node> result = new ArrayList<Node>();

        if(current != null){
            // Go left first because this is in order
            result.addAll(this.getOrderArrayHelper(current.leftChild));

            // Append the current node
            result.add(current);

            // Go right
            result.addAll(this.getOrderArrayHelper(current.rightChild));
        }
        return result;
    }

    // Rebalances an unbalanced tree
    public BinarySearchTree rebalance() {
        ArrayList<Node> old_tree = this.getOrderArrayNode();
        BinarySearchTree new_tree = new BinarySearchTree();
        Integer size = old_tree.size();
        Integer middle = size / 2;
        Node<Album> middle_node = old_tree.get(middle);
        new_tree.insert(middle_node.data);
        old_tree.remove(size / 2);
        for(int i =0; i< old_tree.size();i++){
            new_tree.insert((Album) old_tree.get(i).data);
        }
        // Return a new balanced tree instance
        return new_tree;
    }
}
