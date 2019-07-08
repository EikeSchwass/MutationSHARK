package de.ugoe.cs.smartshark.mutationSHARK.util.astar;

import java.util.List;

public interface INotifyPathFoundCallback<TNode,TMutation>
{
    void pathFound(List<Edge<TNode,TMutation>> edges);
}
