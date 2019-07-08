package de.ugoe.cs.smartshark.mutationSHARK.util.astar;

public interface INodeHeuristicCallback<TNode,TMutation> {
    double getHeuristicDistance(Node<TNode,TMutation> from, Node<TNode,TMutation> to);
}
