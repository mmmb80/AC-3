import java.util.*;

public class Node {

    int id;
    Set<Color> domain;
    List<Node> neighbors;

    public Node(int id, Set<Color> domain) {
        this.id = id;
        this.domain = domain;
        this.neighbors = new ArrayList<>();

    }

    public void setNeighbors(List<Node> neighbors) {
        this.neighbors = neighbors;
    }

    void set(Color c)
    {

        domain = new HashSet<>(Arrays.asList(c));

    }

    void remove (Color c)
    {
        domain.remove(c);
    }

}
