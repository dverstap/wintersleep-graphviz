package org.wintersleep.graphviz;

import java.awt.*;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * For the total list of attributes, their type and on which entity they are allowed, see:
 * http://www.graphviz.org/doc/info/attrs.html
 */
class AttributeList<T extends AttributeList> {
    // LinkedHashMap to keep the order for easy debugging
    private LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

    public T addQuoted(String key, Object value) {
        assert (value != null);
        map.put(key, "\"" + value + "\"");
        return (T) this;
    }

    public T addUnquoted(String key, Object value) {
        map.put(key, value == null ? null : value.toString());
        return (T) this;
    }

    public T addStrings(String key, String separator, String... strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            if (i > 0) {
                sb.append(separator);
            }
            sb.append(s);
        }
        return addQuoted(key, sb.toString());
    }

    public <E extends Enum<E>> T addEnum(String key, E e) {
        return addQuoted(key, e.name().toLowerCase());
    }

    public <E extends Enum<E>> T addEnums(String key, String separator, Enum<E>... enums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < enums.length; i++) {
            Enum<E> e = enums[i];
            if (i > 0) {
                sb.append(separator);
            }
            sb.append(e.name().toLowerCase());
        }
        return addQuoted(key, sb.toString());
    }

    protected T addColor(String attributeName, Color bgColor) {
        String s = "#" + toHex(bgColor.getRed(), 2) + "%" + toHex(bgColor.getGreen(), 2) + "%" + toHex(bgColor.getBlue(), 2) + "%";
        return addQuoted(attributeName, s);
    }

    protected String toHex(int i, int strLen) {
        String result = Integer.toHexString(i);
        while (result.length() < strLen) {
            result = "0" + result;
        }
        return result;
    }


    public void print(PrintWriter w) {
        print(w, "[", ", ", "]");
    }

    public void print(PrintWriter w, final String prologue, final String separator, final String epilogue) {
        if (prologue != null) {
            w.print(prologue);
        }
        boolean isFirst = true;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (isFirst) {
                isFirst = false;
            } else {
                w.print(separator);
            }
            w.print(entry.getKey());
            if (entry.getValue() != null) {
                w.print("=");
                w.print(entry.getValue());
            }
        }
        if (epilogue != null) {
            w.print(epilogue);
        }
    }

}
