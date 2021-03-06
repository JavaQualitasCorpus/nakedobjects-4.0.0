package org.nakedobjects.runtime.testsystem;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.nakedobjects.runtime.context.NakedObjectsContext;
import org.nakedobjects.runtime.persistence.PersistenceSession;
import org.nakedobjects.runtime.persistence.adaptermanager.AdapterManager;
import org.nakedobjects.runtime.persistence.adaptermanager.AdapterManagerTestSupport;
import org.nakedobjects.runtime.session.NakedObjectSession;
import org.nakedobjects.runtime.transaction.NakedObjectTransactionManager;


public abstract class ProxyJunit4TestCase {

    protected TestProxySystem system;

    @Before
    public void setUpSystem() throws Exception {
        createSystem();
        initSystem();
    }

    protected void initSystem() {
        system.init();
    }

    protected void createSystem() {
        Logger.getRootLogger().setLevel(Level.OFF);
        system = new TestProxySystem();
    }

    
    protected static NakedObjectSession getSession() {
        return NakedObjectsContext.getSession();
    }

    protected static PersistenceSession getPersistenceSession() {
        return NakedObjectsContext.getPersistenceSession();
    }

    protected static AdapterManager getAdapterManager() {
        return getPersistenceSession().getAdapterManager();
    }
    
    protected static AdapterManagerTestSupport getAdapterManagerTestSupport() {
        return (AdapterManagerTestSupport) NakedObjectsContext.getPersistenceSession().getAdapterManager();
    }

    protected static NakedObjectTransactionManager getTransactionManager() {
        return getPersistenceSession().getTransactionManager();
    }


}

// Copyright (c) Naked Objects Group Ltd.
