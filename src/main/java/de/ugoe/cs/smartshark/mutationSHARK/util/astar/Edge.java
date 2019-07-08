package de.ugoe.cs.smartshark.mutationSHARK.util.astar;

public class Edge<TNode,TMutation>
{
    private final Node<TNode,TMutation> from;
    private final Node<TNode,TMutation> to;
    private final TMutation mutation;

    protected Edge(Node<TNode,TMutation> from, Node<TNode,TMutation> to, TMutation mutation)
    {
        this.from = from;
        this.to = to;
        this.mutation = mutation;
    }

    public Node<TNode,TMutation> getFrom()
    {
        return from;
    }

    public Node<TNode,TMutation> getTo()
    {
        return to;
    }

    public TMutation getMutation()
    {
        return mutation;
    }
}
