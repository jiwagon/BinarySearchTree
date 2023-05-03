import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    @Test
    void insertNode() {
        BinarySearchTree tree = new BinarySearchTree();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        list.add("Halsey");
        list.add("Cashmere Cat");
        list2.add("Kanzaki Iori");
        Album a1 = new Album(1,list,"Dreamland",8);
        Album a2 = new Album(2,list2,"Killian",4);
        Album a3 = new Album(3,list,"Manic",5);
        tree.insert(a1);
        tree.insert(a2);
        tree.insert(a3);
        ArrayList<Album> result= new ArrayList<Album>();
        result.add(a2);
        result.add(a3);
        result.add(a1);
        //assertEquals(result, tree.getOrderArrayAlbum());
        //System.out.println(tree.getOrderArrayNode());
        System.out.println(tree);
    }
}