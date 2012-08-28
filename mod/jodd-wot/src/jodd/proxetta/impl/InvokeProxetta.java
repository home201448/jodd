// Copyright (c) 2003-2012, Jodd Team (jodd.org). All Rights Reserved.

package jodd.proxetta.impl;

import jodd.proxetta.InvokeAspect;
import jodd.proxetta.Proxetta;
import jodd.proxetta.asm.ProxettaInvokeCreator;
import jodd.proxetta.asm.ProxettaNaming;

/**
 * Proxetta that does method (i.e. invocation) replacements.
 */
public class InvokeProxetta extends Proxetta {

	protected final InvokeAspect[] invokeAspects;

	public InvokeProxetta(InvokeAspect... aspects) {
		this.invokeAspects = aspects;
		classNameSuffix = ProxettaNaming.INVOKE_PROXY_CLASS_NAME_SUFFIX;
	}

	/**
	 * Specifies invoke replacement aspects and creates this <code>Proxetta</code> instance.
	 */
	public static InvokeProxetta withAspects(InvokeAspect... aspects) {
		return new InvokeProxetta(aspects);
	}

	public InvokeAspect[] getAspects() {
		return invokeAspects;
	}

	// ---------------------------------------------------------------- implement

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProxettaInvokeCreator builder() {
		return new ProxettaInvokeCreator(this);
	}

	// ---------------------------------------------------------------- shortcuts

	public ProxettaInvokeCreator builder(Class target) {
		ProxettaInvokeCreator builder = builder();
		builder.setTarget(target);
		return builder;
	}

	public ProxettaInvokeCreator builder(Class target, String targetProxyClassName) {
		ProxettaInvokeCreator builder = builder();
		builder.setTarget(target);
		builder.setTargetProxyClassName(targetProxyClassName);
		return builder;
	}

}
