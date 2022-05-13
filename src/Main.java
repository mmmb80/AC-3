import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Main {



    public static void main(String[] args) {
        Algo algo = new Algo();
        algo.setup();
        Color r = algo.r, b = algo.b, c = algo.c;
        algo.assign(Arrays.asList(0,3,4).stream().map(x -> algo.graph.get(x)).collect(Collectors.toList()), Arrays.asList(r,c,r));
        System.out.println(algo.ac3());
        for (Node n : algo.graph)
        {
            System.out.println(n.id+1 + "->" + n.domain.stream().map(x -> x.name).collect(Collectors.toList()).toString());
        }
    }
}
