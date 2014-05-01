package org.wintersleep.graphviz;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class DiGraph {

    private final DiGraph parent;
    private final String id;
    private String[] message;
    private final GraphAttributeList attributeList = new GraphAttributeList();
    private final LinkedHashMap<String, AttributeListList> attributeListListList = new LinkedHashMap<String, AttributeListList>();
    private final Map<String, Node> nodeMap = new LinkedHashMap<String, Node>();
    private final Map<String, DiGraph> childGraphMap = new LinkedHashMap<String, DiGraph>();
    private final Set<Edge> edgeSet = new LinkedHashSet<Edge>();

    public DiGraph(String id) {
        this.parent = null;
        this.id = id;
    }

    public DiGraph(DiGraph parent, String id) {
        this.parent = parent;
        this.id = id;
    }

    public Node addNode(String id) {
        if (nodeMap.containsKey(id)) {
            throw new IllegalArgumentException("Graph already contains a Node with id=" + id);
        }
        Node node = new Node(this, id);
        nodeMap.put(id, node);
        return node;
    }

    public DiGraph addSubGraph(String id) {
        if (childGraphMap.containsKey(id)) {
            throw new IllegalStateException("There is already a subgraph with id=" + id);
        }
        DiGraph result = new DiGraph(this, id);
        childGraphMap.put(id, result);
        return result;
    }

    public Edge addEdge(Node from, Node to) {
        return addEdge(from, null, to, null);
    }

    public Edge addEdge(Node from, String fromPort, Node to) {
        return addEdge(from, fromPort, to, null);
    }

    public Edge addEdge(Node from, Node to, String toPort) {
        return addEdge(from, null, to, toPort);
    }

    public Edge addEdge(Node from, String fromPort, Node to, String toPort) {
        Edge edge = new Edge(this, from, fromPort, to, toPort);
        edgeSet.add(edge);
        return edge;
    }

    public Edge addEdge(String fromId, String toId) {
        return addEdge(fromId, null, toId, null);
    }

    public Edge addEdge(String fromId, String fromPort, String toId, String toPort) {
        Node from = findNode(fromId);
        Node to = findNode(toId);
        return addEdge(from, fromPort, to, toPort);
    }

    // TODO this wrong: should look from the root graph
    private Node findNode(String id) {
        Node result = doFindNode(id);
        if (result != null) {
            return result;
        }
        throw new IllegalArgumentException("Couldn't find node " + id);
    }

    private Node doFindNode(String id) {
        Node result = nodeMap.get(id);
        if (result != null) {
            return result;
        }
        for (DiGraph childGraph : childGraphMap.values()) {
            result = childGraph.doFindNode(id);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    public String getId() {
        return id;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String... message) {
        this.message = message;
    }

    public AttributeListList<GraphAttributeList> addGraphAttributeListList() {
        AttributeListList<GraphAttributeList> result = new AttributeListList<GraphAttributeList>(GraphAttributeList.class);
        attributeListListList.put("graph", result);
        return result;
    }

    public AttributeListList<NodeAttributeList> addNodeAttributeListList() {
        AttributeListList<NodeAttributeList> result = new AttributeListList<NodeAttributeList>(NodeAttributeList.class);
        attributeListListList.put("node", result);
        return result;
    }

    public AttributeListList<EdgeAttributeList> addEdgeAttributeListList() {
        AttributeListList<EdgeAttributeList> result = new AttributeListList<EdgeAttributeList>(EdgeAttributeList.class);
        attributeListListList.put("edge", result);
        return result;
    }

    public GraphAttributeList getAttributeList() {
        return attributeList;
    }

    public void print(PrintWriter w) {
        w.println("#!/bin/env dot");
        doPrint(w);
    }

    private void doPrint(PrintWriter w) {
        if (message != null) {
            w.println();
            for (String line : message) {
                w.print("# ");
                w.println(line);
            }
            w.println();
        }
        if (parent == null) {
            w.println("digraph " + id + " {");
        } else {
            w.println("subgraph cluster_" + id + " {");
        }

        w.println("# attributeListListList:");
        for (Map.Entry<String, AttributeListList> entry : attributeListListList.entrySet()) {
            w.print(entry.getKey());
            w.print(" ");
            entry.getValue().print(w);
        }
        w.println();

        w.println("# attributeList:");
        attributeList.print(w, null, "\n", null);
        w.println();
        w.println();

        w.println("# child graphs:");
        for (DiGraph graph : childGraphMap.values()) {
            graph.doPrint(w);
        }

        w.println("# nodes:");
        for (Node node : nodeMap.values()) {
            node.print(w);
        }
        w.println();

        w.println("# edges:");
        for (Edge edge : edgeSet) {
            edge.print(w);
        }
        w.println("}");
    }

    public void makeDotFile(File file) throws IOException {
        FileWriter w = new FileWriter(file);
        try {
            print(new PrintWriter(w));
        } finally {
            w.close();
        }
    }

    public File makeImageFile(File dir, String format) throws IOException, InterruptedException {
        return makeImageFile(dir, format, false);
    }

    public File makeImageFile(File dir, String format, boolean keepDotFile) throws IOException {
        File dotFile = makeFileName(dir, "dot");
        makeDotFile(dotFile);
        File imageFile = makeFileName(dir, format);
        Process process = Runtime.getRuntime().exec("dot -T" + format + " -o " + imageFile + " " + dotFile);
        int result = 0;
        try {
            result = process.waitFor();
        } catch (InterruptedException e) {
            throw new RuntimeException("Got InterruptedException while waiting for dot to finish processing '" + dotFile + "'.", e);
        }
        if (!keepDotFile) {
            dotFile.delete();
        }
        if (result != 0) {
            throw new RuntimeException("Got process return code '" + result + "' while for dot file '" + dotFile + "'.");
        }
        return imageFile;
    }

    public File makeFileName(File dir, String format) {
        return new File(dir, id + "." + format);
    }

}
