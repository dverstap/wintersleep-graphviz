/*
 * Copyright 2008 Davy Verstappen.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wintersleep.graphviz;

import org.junit.Test;
import org.wintersleep.test.util.FileTestUtil;

import java.io.File;
import java.io.IOException;

public class PassiveOpticalNetworkTest {

    private final File outputDir = FileTestUtil.makeOutputDir(PassiveOpticalNetworkTest.class, "test-diagrams");

    @Test
    public void test() throws IOException, InterruptedException {
        DiGraph g = makeSingleSplitter64();
        FileTestUtil.assertCreated(g.makeImageFile(outputDir, "png", true));

        g = make(4, 16);
        FileTestUtil.assertCreated(g.makeImageFile(outputDir, "png", true));

//        ImageViewer viewer = new ImageViewer("/tmp/PON.png");
//        viewer.view();

    }

    private static DiGraph makeSingleSplitter64() {
        DiGraph g = new DiGraph("PON_64");
        g.addGraphAttributeListList().addAttributeList()
                .setSize("10,10")
                .setOrdering("out");

        Node olt = g.addNode("OLT");
        Node splitter = g.addNode("splitter");
//        splitter.addAttributeList()
//                .setStart();
        g.addEdge(olt, splitter);

        for (int i = 0; i < 64; i++) {
            Node ont = g.addNode("ont" + i);
            ont.addAttributeList()
                    .setLabel(Integer.toString(i));

            g.addEdge(splitter, ont);
        }
        return g;
    }

    private static DiGraph make(int secondLevelSplitters, int ontsPerSplitter) {
        DiGraph g = new DiGraph("PON_" + secondLevelSplitters + "x" + ontsPerSplitter);
        g.addGraphAttributeListList().addAttributeList()
                //.setSize("10,10")
                .setOrdering("out")
                        //.setRotate(90)
                .setRankDir(RankDir.LR)
                .setNodeSep(0.05)
                ;

        Node olt = g.addNode("OLT");
        Node splitter = g.addNode("splitter");
        g.addEdge(olt, splitter);

        for (int i = 0; i < secondLevelSplitters; i++) {
            Node splitter2 = g.addNode("splitter_" + i);
            g.addEdge(splitter, splitter2);
            for (int j = 0; j < 64; j++) {
                Node ont = g.addNode("ont" + i + "_" + j);
                ont.addAttributeList()
                        .setLabel(Integer.toString(j))
                        .setShape("box")
                                //.setHeight(0.01)
                        .setLabelFontSize(148)
                        ;

                g.addEdge(splitter2, ont);
            }
        }
        return g;
    }

}
