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
import java.io.File;
import java.io.IOException;

public class Example {

    public static void main(String[] argv) throws IOException, InterruptedException {
        //// start-example
        DiGraph g = new DiGraph("Example");

        Node a = g.addNode("A");
        Node b = g.addNode("B");
        // add edge using node objects:
        g.addEdge(a, b);

        g.addNode("C");
        // add edge using node names:
        g.addEdge("B", "C");

        // set attribute using a type-safe setter:
        a.addAttributeList()
                .setColor(Color.RED);

        // set attribute using a generic string option:
        b.addAttributeList()
                .setUnquoted("shape", "octagon");

        File outputDir = new File("/tmp");
        g.makeImageFile(outputDir, "png");
        //// end-example
    }

}
