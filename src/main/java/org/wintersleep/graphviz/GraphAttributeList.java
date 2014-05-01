package org.wintersleep.graphviz;

import java.awt.*;

public class GraphAttributeList extends ENGCAttributeList<GraphAttributeList> {

    public GraphAttributeList setRankDir(RankDir rankDir) {
        return addUnquoted("rankdir", rankDir.name());
    }

    public GraphAttributeList setRankSep(int i) {
        return addUnquoted("ranksep", i);
    }

    public GraphAttributeList setBgColor(String colorName) {
        return addUnquoted("bgColor", colorName);
    }

    public GraphAttributeList setBgColor(Color bgColor) {
        return addColor("bgColor", bgColor);
    }

    public GraphAttributeList setSize(String size) {
        return addQuoted("size", size);
    }

    public GraphAttributeList setSize(double width, double height) {
        return addQuoted("size", width + "," + height);
    }

    public GraphAttributeList setOrdering(String ordering) {
        return addUnquoted("ordering", ordering);
    }

    public GraphAttributeList setRotate(int rotate) {
        return addUnquoted("rotate", rotate);
    }

    public GraphAttributeList setNodeSep(double nodeSep) {
        return addUnquoted("nodesep", nodeSep);
    }

    public GraphAttributeList setCompound(boolean compound) {
        return addUnquoted("compound", true);
    }

    public GraphAttributeList setStyle(String style) {
        return addQuoted("style", style);
    }

    public GraphAttributeList setOrientation(Orientation orientation) {
        return addUnquoted("orientation", orientation.name().toLowerCase());
    }
}