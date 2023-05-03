public class Node<T> {
    Node<T> left;
    Node<T> right;
    Album data;

    public Node(Album data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString(){
        return data.toString();
    }
}