package org.kohsuke.stapler;

import net.sf.json.JSONObject;

import java.beans.Introspector;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * Designates a setter method used to databind JSON vlues into objects in methods like
 * {@link StaplerRequest#bindJSON(Class, JSONObject)} and
 * {@link StaplerRequest#bindParameters(Class, String)}.
 *
 * <p>
 * Stapler will first invoke {@link DataBoundConstructor}-annotated constructor, and if there's any
 * remaining properties in JSON, it'll try to find a matching {@link DataBoundSetter}-annotated setter.
 *
 * <p>
 * The setter method is discovered through {@link Introspector}, so setter method name must match
 * the property name (such as <tt>setFoo</tt> for the <tt>foo</tt> property.)
 *
 * @author Kohsuke Kawaguchi
 */
@Retention(RUNTIME)
@Target(METHOD)
@Documented
public @interface DataBoundSetter {
}
