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
        return setUnquoted("rankdir", rankDir.name());
    }

    public GraphAttributeList setRankSep(int i) {
        return setUnquoted("ranksep", i);
    }

    public GraphAttributeList setBgColor(String colorName) {
        return setUnquoted("bgColor", colorName);
    }

    public GraphAttributeList setBgColor(Color bgColor) {
        return _setColor("bgColor", bgColor);
    }

    public GraphAttributeList setSize(String size) {
        return setQuoted("size", size);
    }

    public GraphAttributeList setSize(double width, double height) {
        return setQuoted("size", width + "," + height);
    }

    public GraphAttributeList setOrdering(String ordering) {
        return setUnquoted("ordering", ordering);
    }

    public GraphAttributeList setRotate(int rotate) {
        return setUnquoted("rotate", rotate);
    }

    public GraphAttributeList setNodeSep(double nodeSep) {
        return setUnquoted("nodesep", nodeSep);
    }

    public GraphAttributeList setCompound(boolean compound) {
        return setUnquoted("compound", true);
    }

    public GraphAttributeList setStyle(String style) {
        return setQuoted("style", style);
    }

    public GraphAttributeList setOrientation(Orientation orientation) {
        return setUnquoted("orientation", orientation.name().toLowerCase());
    }
}
