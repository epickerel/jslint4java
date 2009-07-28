package com.googlecode.jslint4java;

import java.io.IOException;
import java.io.Reader;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

/**
 * A collection of useful routines.
 * 
 * @author dom
 * @version $Id$
 */
class Util {

    /**
     * Return the integer value of a JavaScript variable.
     * 
     * @param name
     *                the JavaScript variable
     * @param scope
     *                the JavaScript scope to read from
     * @return the value of <i>name</i> as an integer, or zero.
     */
    static int intValue(String name, Scriptable scope) {
        if (scope == null)
            return 0;
        Object o = scope.get(name, scope);
        return o == Scriptable.NOT_FOUND ? 0 : (int) Context.toNumber(o);
    }

    /**
     * Returns the value of a JavaScript variable, or null.
     * 
     * @param name
     *                the JavaScript variable.
     * @param scope
     *                the JavaScript scope to read from
     * @return the value of <i>name</i> or null.
     */
    static String stringValue(String name, Scriptable scope) {
        if (scope == null)
            return null;
        Object o = scope.get(name, scope);
        return o instanceof String ? (String) o : null;
    }

    /**
     * Read all of a {@link Reader} into memory as a {@link String}.
     * 
     * @param reader
     * @return
     * @throws IOException
     */
    static String readerToString(Reader reader) throws IOException {
        StringBuffer sb = new StringBuffer();
        int c;
        while ((c = reader.read()) != -1) {
            sb.append((char) c);
        }
        return sb.toString();
    }

}