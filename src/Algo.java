import java.util.*;
import java.util.stream.Collectors;

public class Algo {

    List<Node> graph = new ArrayList<>();
    Color r = new Color('r'), b = new Color('b'), c = new Color('c');
    void setup()
    {
        for (int i=0;i<8;i++)
        {
            graph.add(new Node(i,new HashSet<>(Arrays.asList(r,b,c))));
        }
        graph.get(0).setNeighbors(Arrays.asList(graph.get(1), graph.get(2), graph.get(3)));
        graph.get(1).setNeighbors(Arrays.asList(graph.get(0), graph.get(3), graph.get(5)));
        graph.get(2).setNeighbors(Arrays.asList(graph.get(0), graph.get(3), graph.get(6)));
        graph.get(3).setNeighbors(Arrays.asList(graph.get(0), graph.get(1), graph.get(2), graph.get(4)));
        graph.get(4).setNeighbors(Arrays.asList(graph.get(3), graph.get(5), graph.get(6)));
        graph.get(5).setNeighbors(Arrays.asList(graph.get(1), graph.get(4), graph.get(6), graph.get(7)));
        graph.get(6).setNeighbors(Arrays.asList(graph.get(2), graph.get(4), graph.get(5), graph.get(7)));
        graph.get(7).setNeighbors(Arrays.asList(graph.get(5), graph.get(6)));


    }

    void assign(List<Node> nodes, List<Color> colors)
    {
        for (int i=0;i<nodes.size();i++) nodes.get(i).set(colors.get(i));
    }

    boolean satisfiable(Color c, Set<Color> s)
    {
        return (s.size() - (s.contains(c)?1:0))>0;
    }

    boolean removeInconsistencies(Node a, Node b)
    {
        boolean res = false;

        for (Color c : a.domain.stream().collect(Collectors.toList()))
        {
            if (!satisfiable(c, b.domain))
            {
                a.remove(c);
                res = true;
            }
        }

        return res;

    }

    boolean ac3()
    {
        Queue<Node> left = new ArrayDeque<>(), right = new ArrayDeque<>();

        for (Node n : graph)
        {
            for (Node n2 : n.neighbors)
            {
                left.add(n); right.add(n2);
            }
        }

        while(!left.isEmpty())
        {
            Node l = left.remove(), r = right.remove();
            if (removeInconsistencies(l,r))
            {
                for (Node k :l.neighbors)
                {
                    if (k!= r)
                    {
                        left.add(l); right.add(k);
                    }
                }
            }
        }
        return graph.stream().map(x -> x.domain.size()).filter(x-> x==0).count()==0;
    }

}


