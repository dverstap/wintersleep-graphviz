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

import org.apache.xmlbeans.XmlOptions;
import org.wintersleep.graphviz.html.TableDocument;

import java.awt.*;
import java.util.Collections;

public class ENGCAttributeList<T extends ENGCAttributeList> extends AttributeList<T> {
    public T setFontName(String fontName) {
        return setQuoted("fontname", fontName);
    }

    public T setFontColor(String fontColor) {
        return setQuoted("fontcolor", fontColor);
    }

    public T setFontColor(Color fontColor) {
        return _setColor("fontcolor", fontColor);
    }

    public T setFontSize(double fontSize) {
        return setUnquoted("fontsize", fontSize);
    }

    public T setLabel(String label) {
        return setQuoted("label", label);
    }

    public T setLabel(TableDocument table) {
        XmlOptions options = new XmlOptions()
                .setUseDefaultNamespace()
                .setSaveImplicitNamespaces(Collections.singletonMap("html", "http://uml.org/graphviz/html"));
        String str = table.xmlText(options);

        return setUnquoted("label", "<" + str + ">");
    }

    public T setColor(String color) {
        return setUnquoted("color", color);
    }

    public T setColor(Color color) {
        return _setColor("color", color);
    }

}
