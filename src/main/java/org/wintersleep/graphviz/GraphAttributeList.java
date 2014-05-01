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
