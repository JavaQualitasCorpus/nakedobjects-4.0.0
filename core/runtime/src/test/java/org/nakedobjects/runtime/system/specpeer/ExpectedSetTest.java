package org.nakedobjects.runtime.system.specpeer;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;


public class ExpectedSetTest extends TestCase {

    public static void main(final String[] args) {
        junit.textui.TestRunner.run(ExpectedSetTest.class);
    }

    private ExpectedSet set;

    @Override
    protected void setUp() throws Exception {
        set = new ExpectedSet();

        set.addExpected("test");
        set.addExpected("expected");
        set.addExpected("list");
    }

    public void testAddActuals() {
        set.addActual("test");
        set.addActual("expected");
        set.addActual("list");
        set.verify();
    }

    public void testAddActualsInWrongOrder() {
        try {
            set.addActual("test");
            set.addActual("list");
        } catch (final AssertionFailedError e) {
            return;
        }
        fail();
    }

    public void testAddInvalidActuals() {
        try {
            set.addActual("not");
            set.addActual("part");
        } catch (final AssertionFailedError e) {
            return;
        }
        fail();
    }

    public void testAddTooFewActuals() {
        try {
            set.addActual("test");
            set.addActual("expected");
            set.verify();
        } catch (final AssertionFailedError e) {
            return;
        }
        fail();
    }

    public void testAddTooManyActuals() {
        try {
            set.addActual("test");
            set.addActual("expected");
            set.addActual("list");
            set.addActual("overrun");
        } catch (final AssertionFailedError e) {
            return;
        }
        fail();
    }

    public void testNoActuals() {
        try {
            set.verify();
        } catch (final AssertionFailedError e) {
            return;
        }
        fail();
    }

    public void testNoExpectedNoActuals() {
        set = new ExpectedSet();
        set.verify();
    }

}
// Copyright (c) Naked Objects Group Ltd.
