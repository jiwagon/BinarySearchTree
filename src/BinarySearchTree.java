import java.util.ArrayList;
import static java.lang.Math.*;

public class BinarySearchTree <T extends Comparable<T>>{
    protected Node<Album> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(Album data) {
        this.root = insertNode(this.root, data);
    }

    private Node insertNode(Node current, Album data) {
        //if the current is null, just return the node
        if (current == null) {
            return new Node(data);
        }
        if (data.compareTo(current.data) == -1) {
            current.left = this.insertNode(current.left, data);
        } else if (data.compareTo(current.data) == 1) {
            current.right = this.insertNode(current.right, data);
        }
        return current;
    }

    public Node delete(Album data){
        return deleteNode(this.root, data);
    }

    public Node deleteNode(Node current, Album data){
        Node<Album> result = new Node<>(null);
        try{
            if (current == null) {
                throw new IndexOutOfBoundsException();
            }
            if (current.data.compareTo(data) == 0) {
                result.data = current.data;
                current.data = findMinValue(current.right, current);
                return result;
            }
            if (current.data.compareTo(data) == 1) {
                return deleteNode(current.left, data);
            } else {
                return deleteNode(current.right, data);
            }
        }catch (Exception e){
            System.out.println("This Album to delete is not in the tree!");
        }
        return null;
    }

    public boolean contains(Album data){
        return this.containsHelper(this.root, data);
    }

    private boolean containsHelper(Node current, Album data){
        if(current != null){
            if(current.data == data){
                return true;
            }else{
                if(data.compareTo(current.data) == 1){
                    return containsHelper(current.right, data);
                }
                else{
                    return containsHelper(current.left, data);
                }
            }
        }
        return false;
    }

    public BinarySearchTree rebalance(){
        ArrayList<Node> old_tree = this.getOrderArrayNode();
        BinarySearchTree new_tree = new BinarySearchTree();
        Integer size = old_tree.size();
        Integer middle = size / 2;
        Node<Album> middle_node = old_tree.get(middle);
        new_tree.insert(middle_node.data);
        old_tree.remove(size / 2);
        for(int i =0; i< old_tree.size();i++){
            new_tree.insert(old_tree.get(i).data);
        }
        return new_tree;
    }

    public Album findMinValue(Node curr_root, Node pre_root){
        Album minimum = curr_root.data;
        while (curr_root.left != null){
            minimum = curr_root.left.data;
            pre_root = curr_root;
            curr_root = curr_root.left;
        }
        if(curr_root.right != null){
            pre_root.right = curr_root.right;
        }
        else{
            pre_root.data = curr_root.data;
            pre_root.right = curr_root.right;
        }
        return minimum;
    }

    public String inOrder(){
        return this.inOrder(this.root);
    }

    private String inOrder(Node current){
        StringBuilder stringBuilder = new StringBuilder();

        if(current != null){
            //go left first because this is in order
            stringBuilder.append(this.inOrder(current.left));

            //append the current node
            stringBuilder.append(current.data);
            stringBuilder.append(" ");

            //go right
            stringBuilder.append(this.inOrder(current.right));
        }
        return stringBuilder.toString();
    }

    public ArrayList<Album> getOrderArrayAlbum(){
        ArrayList<Node> node_list = this.getOrderArrayNode();
        ArrayList<Album> result = new ArrayList<>();
        for(int i = 0;i < node_list.size();i++){
            result.add(node_list.get(i).data);
        }
        return result;
    }
    // Get the data of the tree in ArrayList Format
    public ArrayList<Node> getOrderArrayNode(){
        return this.getOrderArrayHelper(this.root);
    }

    private ArrayList<Node> getOrderArrayHelper(Node current){
        ArrayList<Node> result = new ArrayList<Node>();

        if(current != null){
            // Go left first because this is in order
            result.addAll(this.getOrderArrayHelper(current.left));

            // Append the current node
            result.add(current);

            // Go right
            result.addAll(this.getOrderArrayHelper(current.right));
        }
        return result;
    }

    public int getMaxDepth(){
        return getMaxDepthHelper(this.root);
    }

    public int getMaxDepthHelper(Node current){
        if(current == null){
            return 0;
        }
        int left = getMaxDepthHelper(current.left);
        int right = getMaxDepthHelper(current.right);
        if(left > right){
            return 1+left;
        }
        else{
            return 1+right;
        }
    }

    // Get which position contain a node.
    // Return two arraylist, one contain all the position, one contain the node associate with the position.
    public ArrayList<ArrayList> getPosition(){
        return  getPositionHelper(this.root, 0);
    }

    private ArrayList<ArrayList> getPositionHelper(Node current, int position){
        if(current  != null) {
            ArrayList<Integer> position_list = new ArrayList<>();
            ArrayList<Node> content = new ArrayList<>();
            ArrayList<ArrayList> result = new ArrayList<>();

            position_list.add(position);
            content.add(current);

            if(current.left != null) {
                ArrayList<ArrayList> left_list = getPositionHelper(current.left, position * 2 + 1);
                position_list.addAll(left_list.get(0));
                content.addAll(left_list.get(1));
            }
            if(current.right != null){
                ArrayList<ArrayList> right_list = getPositionHelper(current.right,position*2+2);
                position_list.addAll(right_list.get(0));
                content.addAll(right_list.get(1));
            }

            result.add(position_list);
            result.add(content);

            return result;
        }
        return null;

    }

    public ArrayList<Album> partition(Album data){
        ArrayList<Album> compared = new ArrayList<Album>();
        ArrayList<Node> list = getOrderArrayNode();
        for(int i =0; i< list.size(); i++){
            if(data.compareTo(list.get(i).data) <= 0){
                compared.add(list.get(i).data);
            }
        }
        return compared;

    }

    //Extra credit toString()
    //Return a string representation
    @Override
    public String toString(){
        int depth = getMaxDepth();
        double total_node = Math.pow(2,depth)-1;
        ArrayList<Node> result = new ArrayList<>();

        ArrayList<ArrayList> tree_pos = this.getPosition();
        ArrayList<Node> nodes = tree_pos.get(1);
        ArrayList<Integer> node_pos = tree_pos.get(0);

        for(int i = 0; i < total_node; i++){
            if(node_pos.contains(i)){
                int index = node_pos.indexOf(i);
                result.add(nodes.get(index));
                if (nodes.get(index).equals(nodes.size())) {
                    break;
                }
            }
            else{
                result.add(null);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < result.size();i++){
            stringBuilder.append(result.get(i) + " ");
        }

        return stringBuilder.toString();
    }
}