package de.ugoe.cs.smartshark.mutationSHARK.util.astar;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class AStar<TNode,TMutation>{

    private final IAdjacentCallback<TNode,TMutation> adjacentCallback;
    private final INodeHeuristicCallback<TNode,TMutation> nodeIHeuristicCallback;

    public AStar(IAdjacentCallback<TNode,TMutation> adjacentCallback, INodeHeuristicCallback<TNode,TMutation> nodeIHeuristicCallback){

        this.adjacentCallback = adjacentCallback;
        this.nodeIHeuristicCallback = nodeIHeuristicCallback;
    }

    public boolean calculatePath(Node<TNode,TMutation> start, Node<TNode,TMutation> end, INotifyPathFoundCallback<TNode,TMutation> notifyPathFoundCallback)
    {
        boolean pathFound = false;
        final HashMap<Node<TNode,TMutation>, Double> g = new HashMap<>();
        final HashMap<Node<TNode,TMutation>, Double> h = new HashMap<>();
        final HashSet<Node<TNode,TMutation>> searched = new HashSet<>();
        final PriorityQueue<Node<TNode,TMutation>> unsearched = new PriorityQueue<>((o1, o2) ->
        {
            if (o1.equals(o2))
                return 0;
            double d1 = h.get(o1) + g.get(o1);
            double d2 = h.get(o2) + g.get(o2);
            return d1 > d2 ? 1 : -1;
        });

        h.put(start, 0.0);
        g.put(start, 0.0);
        unsearched.add(start);
        Node<TNode,TMutation> current = start;

        while (!unsearched.isEmpty())
        {
            current = unsearched.poll();
            if (current.equals(end))
            {
                pathFound = true;
                notifyPathFoundCallback.pathFound(current.getPathToStart());
            }
        }
        return pathFound;
    }
}