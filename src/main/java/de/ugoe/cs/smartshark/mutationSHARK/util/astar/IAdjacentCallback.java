package de.ugoe.cs.smartshark.mutationSHARK.util.astar;

import java.util.List;

public interface IAdjacentCallback<TNode,TMutation>
{
    List<Node> getAdjacentNodes(Node<TNode,TMutation> currentNode);
}

