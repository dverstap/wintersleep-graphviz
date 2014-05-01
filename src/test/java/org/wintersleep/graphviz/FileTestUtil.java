/*
 * Copyright 2009 Davy Verstappen.
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

import org.junit.Assert;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public abstract class FileTestUtil {

    public static File getTargetDir(Class testClass) {
        File classFile = getClassFile(testClass);
        File result = findTargetDir(classFile);
        if (result == null) {
            throw new IllegalStateException("Could not find 'target' dir as a parent of " + classFile);
        }
        return result;
    }

    private static File findTargetDir(File classFile) {
        File dir = classFile.getParentFile();
        while (dir != null) {
            if (dir.getName().equals("target")) {
                return dir;
            }
            dir = dir.getParentFile();
        }
        return null;
    }

    private static File getClassFile(Class testClass) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        URL url = cl.getResource(testClass.getName().replace('.', '/') + ".class");
        if (url == null) {
            throw new IllegalArgumentException("class file not found for: " + testClass);
        }
        File classFile;
        try {
            classFile = new File(url.toURI());
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
        if (!classFile.exists()) {
            throw new IllegalStateException(classFile + " does not exist.");
        }
        return classFile;
    }

    @SuppressWarnings({"ResultOfMethodCallIgnored"})
    public static File makeOutputDir(Class testClass, String subDir) {
        File classFile = getClassFile(testClass);
        File buildDir = findTargetDir(classFile);
        if (buildDir == null) {
            // probably running in a IntelliJ 11.1 project, directly imported from gradle,
            // which does not seem to (easily) support having a directory per module,
            // so we create a dedicated directory for this class itself
            buildDir = new File("intellij-test/" + testClass.getName());
        }
        File result = new File(buildDir, subDir);
        result.mkdirs();
        return result;
    }

    public static void assertCreated(File file) {
        Assert.assertTrue("File not created:" + file, file.exists());
        Assert.assertTrue(file + " size is " + file.length(), file.length() > 0);
    }

    public static File changeExtension(File file, String newExtension) {
        int i = file.getName().lastIndexOf(".");
        String firstPart = file.getName();
        if (i >= 0) {
            firstPart = file.getName().substring(0, i);
        }
        return new File(file.getParentFile(), firstPart + "." + newExtension);
    }

}
