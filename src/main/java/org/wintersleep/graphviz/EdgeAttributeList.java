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
