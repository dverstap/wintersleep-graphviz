package org.wintersleep.graphviz;

import org.apache.xmlbeans.XmlOptions;
import org.wintersleep.graphviz.html.TableDocument;

import java.awt.*;
import java.util.Collections;

public class ENGCAttributeList<T extends ENGCAttributeList> extends AttributeList<T> {
    public T setFontName(String fontName) {
        return addQuoted("fontname", fontName);
    }

    public T setFontColor(String fontColor) {
        return addQuoted("fontcolor", fontColor);
    }

    public T setFontColor(Color fontColor) {
        return addColor("fontcolor", fontColor);
    }

    public T setFontSize(double fontSize) {
        return addUnquoted("fontsize", fontSize);
    }

    public T setLabel(String label) {
        return addQuoted("label", label);
    }

    public T setLabel(TableDocument table) {
        XmlOptions options = new XmlOptions()
                .setUseDefaultNamespace()
                .setSaveImplicitNamespaces(Collections.singletonMap("html", "http://uml.org/graphviz/html"));
        String str = table.xmlText(options);

        return addUnquoted("label", "<" + str + ">");
    }

}
