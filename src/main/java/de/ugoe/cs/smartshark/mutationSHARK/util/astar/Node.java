package de.ugoe.cs.smartshark.mutationSHARK.util.astar;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Node<TNode,TMutation>
{
    private final Edge<TNode,TMutation> previousEdge;

    public Node(Edge<TNode,TMutation> previousEdge)
    {
        this.previousEdge=previousEdge;
    }

    public List<Edge<TNode,TMutation>> getPathToStart()
    {
        Stack<Edge<TNode,TMutation>> path = new Stack<Edge<TNode,TMutation>>();
        Node current = this;
        while(current.previousEdge!=null)
        {
            path.push(current.previousEdge);
            current = current.previousEdge.getFrom();
        }
        return new ArrayList<Edge<TNode,TMutation>>(path);
    }
}
