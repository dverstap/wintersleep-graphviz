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

public class AttributeListList<T extends AttributeList> {

    private final Class<T> clazz;
    private final List<T> list = new ArrayList<T>();

    public AttributeListList(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T addAttributeList() {
        try {
            T result = clazz.newInstance();
            list.add(result);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void print(PrintWriter w) {
        for (T t : list) {
            t.print(w, "[", ", ", "]");
            w.print(" ");
        }
        w.println();
    }

}
