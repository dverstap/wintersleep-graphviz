package org.wintersleep.graphviz;

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
