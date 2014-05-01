package org.wintersleep.graphviz;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Node {

    private final DiGraph diGraph;
    private final String id;
    private final List<NodeAttributeList> attributeList = new ArrayList<NodeAttributeList>();

    public Node(DiGraph diGraph, String id) {
        this.diGraph = diGraph;
        this.id = id;
    }

    public DiGraph getDiGraph() {
        return diGraph;
    }

    public String getId() {
        return id;
    }

    public void print(PrintWriter w) {
        w.print(id);
        w.print(" ");
        for (NodeAttributeList list : attributeList) {
            list.print(w);
        }
        w.println();
    }

    public NodeAttributeList addAttributeList() {
        NodeAttributeList result = new NodeAttributeList();
        attributeList.add(result);
        return result;
    }

}
