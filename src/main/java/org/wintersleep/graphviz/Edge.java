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

public class Edge {

    private final DiGraph diGraph;
    private final Node from;
    private final String fromPort;
    private final Node to;
    private final String toPort;
    private final List<EdgeAttributeList> attributeList = new ArrayList<EdgeAttributeList>();

    public Edge(DiGraph diGraph, Node from, Node to) {
        this(diGraph, from, null, to, null);
    }

    public Edge(DiGraph diGraph, Node from, String fromPort, Node to) {
        this(diGraph, from, fromPort, to, null);
    }

    public Edge(DiGraph diGraph, Node from, Node to, String toPort) {
        this(diGraph, from, null, to, toPort);
    }

    public Edge(DiGraph diGraph, Node from, String fromPort, Node to, String toPort) {
        this.diGraph = diGraph;
        this.from = from;
        this.fromPort = fromPort;
        this.to = to;
        this.toPort = toPort;
    }


    public DiGraph getDiGraph() {
        return diGraph;
    }

    public Node getFrom() {
        return from;
    }

    public Node getTo() {
        return to;
    }

    public void print(PrintWriter w) {
        w.println(from.getId() + port(fromPort) + " -> " + to.getId() + port(toPort));
        w.print(" ");
        for (EdgeAttributeList list : attributeList) {
            list.print(w);
        }
        w.println(";");
    }

    private String port(String port) {
        if (port == null || port.length() == 0) {
            return "";
        } else {
            return ":" + port;
        }
    }

    public EdgeAttributeList addAttributeList() {
        EdgeAttributeList result = new EdgeAttributeList();
        attributeList.add(result);
        return result;
    }

}
