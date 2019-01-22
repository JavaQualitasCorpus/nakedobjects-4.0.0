package org.nakedobjects.runtime.help;

import org.nakedobjects.applib.Identifier;
import org.nakedobjects.metamodel.commons.component.ApplicationScopedComponent;


public interface HelpManager extends ApplicationScopedComponent {

    /**
     * Returns help text for the specified identifier. If no help text is available then an empty String
     * should be returned.
     */
    String help(Identifier identifier);
}
// Copyright (c) Naked Objects Group Ltd.
