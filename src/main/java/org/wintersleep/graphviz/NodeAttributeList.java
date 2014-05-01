package org.wintersleep.graphviz;

public class NodeAttributeList extends ENGCAttributeList<NodeAttributeList> {

    public NodeAttributeList setShape(String shape) {
        return addUnquoted("shape", shape);
    }

    public NodeAttributeList setStyle(String style) {
        return addQuoted("style", style);
    }

    public NodeAttributeList setWidth(double width) {
        return addUnquoted("width", width);
    }

    public NodeAttributeList setHeight(double height) {
        return addUnquoted("height", height);
    }

    public NodeAttributeList setLabelFontSize(int labelFontSize) {
        return addQuoted("labelfontsize", labelFontSize);
    }
}