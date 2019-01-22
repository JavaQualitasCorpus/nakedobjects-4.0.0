package org.nakedobjects.plugins.dnd;

import org.nakedobjects.metamodel.adapter.NakedObject;
import org.nakedobjects.metamodel.consent.Consent;


public interface ObjectContent extends Content {

    Consent canClear();

    Consent canSet(final NakedObject dragSource);

    void clear();

    NakedObject getObject();

    void setObject(final NakedObject object);

}

// Copyright (c) Naked Objects Group Ltd.
