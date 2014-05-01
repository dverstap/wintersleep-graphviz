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

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Node {

    private final DiGraph diGraph;
    private final String id;
    private final List<NodeAttributeList> attributeList = new ArrayList<NodeAttributeList>();

    public Node(DiGraph diGraph, String id) {
        this.diGraph = diGraph;
        this.id = id;
    }

    public DiGraph getDiGraph() {
        return diGraph;
    }

    public String getId() {
        return id;
    }

    public void print(PrintWriter w) {
        w.print(id);
        w.print(" ");
        for (NodeAttributeList list : attributeList) {
            list.print(w);
        }
        w.println();
    }

    public NodeAttributeList addAttributeList() {
        NodeAttributeList result = new NodeAttributeList();
        attributeList.add(result);
        return result;
    }

}
