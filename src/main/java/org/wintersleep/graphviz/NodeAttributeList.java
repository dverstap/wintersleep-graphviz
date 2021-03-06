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

public class NodeAttributeList extends ENGCAttributeList<NodeAttributeList> {

    public NodeAttributeList setShape(String shape) {
        return setUnquoted("shape", shape);
    }

    public NodeAttributeList setStyle(String style) {
        return setQuoted("style", style);
    }

    public NodeAttributeList setWidth(double width) {
        return setUnquoted("width", width);
    }

    public NodeAttributeList setHeight(double height) {
        return setUnquoted("height", height);
    }

    public NodeAttributeList setLabelFontSize(int labelFontSize) {
        return setQuoted("labelfontsize", labelFontSize);
    }
}
