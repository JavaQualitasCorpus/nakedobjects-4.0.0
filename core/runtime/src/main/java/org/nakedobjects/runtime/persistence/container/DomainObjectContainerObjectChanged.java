package org.nakedobjects.runtime.persistence.container;

import org.nakedobjects.metamodel.adapter.NakedObject;
import org.nakedobjects.metamodel.services.ServicesInjector;
import org.nakedobjects.runtime.context.NakedObjectsContext;
import org.nakedobjects.runtime.objectstore.inmemory.InMemoryObjectStore;
import org.nakedobjects.runtime.persistence.PersistenceSession;
import org.nakedobjects.runtime.persistence.adaptermanager.AdapterManager;

/**
 * Helper class that encapsulates the processing performed by domain object
 * containers that are performing an objectChanged.
 * 
 * <p>
 * Implementation note: rather than inject in its dependencies, we instead look
 * up dependencies from the {@link NakedObjectsContext}. This is necessary, for
 * the {@link PersistenceSession} at least, because class enhancers may hold a
 * reference to the factory as part of the generated bytecode. Since the
 * {@link PersistenceSession} could change over the lifetime of the instance (eg
 * when using the {@link InMemoryObjectStore}), we must always look the
 * {@link PersistenceSession} from the {@link NakedObjectsContext}. The same
 * applies to the {@link ServicesInjector}.
 */
public class DomainObjectContainerObjectChanged {

	public DomainObjectContainerObjectChanged() {
	}

	public void objectChanged(final Object object) {
		if (object != null) {
			final NakedObject adapter = adapterFor(object);
			getPersistenceSession().objectChanged(adapter);
		}
	}

	private NakedObject adapterFor(final Object object) {
		return getAdapterManager().adapterFor(object);
	}

	// /////////////////////////////////////////////////////////////////
	// Dependencies (looked up from context)
	// /////////////////////////////////////////////////////////////////

	protected PersistenceSession getPersistenceSession() {
		return NakedObjectsContext.getPersistenceSession();
	}

	protected AdapterManager getAdapterManager() {
		return getPersistenceSession().getAdapterManager();
	}

}
