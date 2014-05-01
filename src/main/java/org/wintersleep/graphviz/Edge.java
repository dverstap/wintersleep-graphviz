package org.wintersleep.graphviz;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Edge {

    private final DiGraph diGraph;
    private final Node from;
    private final String fromPort;
    private final Node to;
    private final String toPort;
    private final List<EdgeAttributeList> attributeList = new ArrayList<EdgeAttributeList>();

    public Edge(DiGraph diGraph, Node from, Node to) {
        this(diGraph, from, null, to, null);
    }

    public Edge(DiGraph diGraph, Node from, String fromPort, Node to) {
        this(diGraph, from, fromPort, to, null);
    }

    public Edge(DiGraph diGraph, Node from, Node to, String toPort) {
        this(diGraph, from, null, to, toPort);
    }

    public Edge(DiGraph diGraph, Node from, String fromPort, Node to, String toPort) {
        this.diGraph = diGraph;
        this.from = from;
        this.fromPort = fromPort;
        this.to = to;
        this.toPort = toPort;
    }


    public DiGraph getDiGraph() {
        return diGraph;
    }

    public Node getFrom() {
        return from;
    }

    public Node getTo() {
        return to;
    }

    public void print(PrintWriter w) {
        w.println(from.getId() + port(fromPort) + " -> " + to.getId() + port(toPort));
        w.print(" ");
        for (EdgeAttributeList list : attributeList) {
            list.print(w);
        }
        w.println(";");
    }

    private String port(String port) {
        if (port == null || port.length() == 0) {
            return "";
        } else {
            return ":" + port;
        }
    }

    public EdgeAttributeList addAttributeList() {
        EdgeAttributeList result = new EdgeAttributeList();
        attributeList.add(result);
        return result;
    }

}
