package org.wintersleep.graphviz;

public class EdgeAttributeList extends ENGCAttributeList<EdgeAttributeList> {

    public EdgeAttributeList setLabelFontName(String fontName) {
        return addQuoted("labelfontname", fontName);
    }

    public EdgeAttributeList setLabelFontSize(int fontSize) {
        return addUnquoted("labelfontsize", fontSize);
    }

    public EdgeAttributeList setDir(Direction direction) {
        return addUnquoted("dir", direction.name().toLowerCase());
    }

    public EdgeAttributeList setArrowTail(Arrow arrow) {
        return addEnum("arrowtail", arrow);
    }

    public EdgeAttributeList setLTail(DiGraph subGraph) {
        return addUnquoted("ltail", "cluster_" + subGraph.getId());
    }

    public EdgeAttributeList setArrowHead(Arrow arrow) {
        return addEnum("arrowhead", arrow);
    }

    public EdgeAttributeList setLHead(DiGraph subGraph) {
        return addUnquoted("lhead", "cluster_" + subGraph.getId());
    }

    public EdgeAttributeList setStyle(String... styles) {
        return addStrings("style", ",", styles);
    }

    public EdgeAttributeList setStyle(EdgeStyle... styles) {
        return addEnums("style", ",", styles);
    }

    public EdgeAttributeList setTailLabel(String label) {
        return addQuoted("taillabel", label);
    }

    public EdgeAttributeList setHeadLabel(String label) {
        return addQuoted("headlabel", label);
    }

    public EdgeAttributeList setLabelAngle(double angle) {
        return addUnquoted("labelangle", angle);
    }

    public EdgeAttributeList setLabelDistance(double distance) {
        return addUnquoted("labeldistance", distance);
    }

    public EdgeAttributeList setConstraint(boolean constraint) {
        return addUnquoted("constraint", Boolean.toString(constraint));
    }

}
