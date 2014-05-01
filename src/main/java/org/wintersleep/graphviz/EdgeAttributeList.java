package org.wintersleep.graphviz;

/*
 * #%L
 * Wintersleep GraphViz
 * %%
 * Copyright (C) 2008 - 2014 Davy Verstappen
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

public class EdgeAttributeList extends ENGCAttributeList<EdgeAttributeList> {

    public EdgeAttributeList setLabelFontName(String fontName) {
        return setQuoted("labelfontname", fontName);
    }

    public EdgeAttributeList setLabelFontSize(int fontSize) {
        return setUnquoted("labelfontsize", fontSize);
    }

    public EdgeAttributeList setDir(Direction direction) {
        return setUnquoted("dir", direction.name().toLowerCase());
    }

    public EdgeAttributeList setArrowTail(Arrow arrow) {
        return setEnum("arrowtail", arrow);
    }

    public EdgeAttributeList setLTail(DiGraph subGraph) {
        return setUnquoted("ltail", "cluster_" + subGraph.getId());
    }

    public EdgeAttributeList setArrowHead(Arrow arrow) {
        return setEnum("arrowhead", arrow);
    }

    public EdgeAttributeList setLHead(DiGraph subGraph) {
        return setUnquoted("lhead", "cluster_" + subGraph.getId());
    }

    public EdgeAttributeList setStyle(String... styles) {
        return setStrings("style", ",", styles);
    }

    public EdgeAttributeList setStyle(EdgeStyle... styles) {
        return setEnums("style", ",", styles);
    }

    public EdgeAttributeList setTailLabel(String label) {
        return setQuoted("taillabel", label);
    }

    public EdgeAttributeList setHeadLabel(String label) {
        return setQuoted("headlabel", label);
    }

    public EdgeAttributeList setLabelAngle(double angle) {
        return setUnquoted("labelangle", angle);
    }

    public EdgeAttributeList setLabelDistance(double distance) {
        return setUnquoted("labeldistance", distance);
    }

    public EdgeAttributeList setConstraint(boolean constraint) {
        return setUnquoted("constraint", Boolean.toString(constraint));
    }

}
