/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.acceleo.query.runtime;

import java.util.Map;
import java.util.Set;

import org.eclipse.acceleo.query.validation.type.IType;

/**
 * Interface to be implemented by query validation engine implementations.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public interface IQueryValidationEngine extends IQueryEngine {
	/**
	 * Validates an expression given a validation context made of variable-type mappings.
	 * 
	 * @param expression
	 *            the expression to validate.
	 * @param variableTypes
	 *            the set of defined variables.
	 * @return a {@link IValidationResult}.
	 */
	IValidationResult validate(String expression, Map<String, Set<IType>> variableTypes);

	/**
	 * When set to <code>true</code> validation will log validation impossibilities that lead to the nothing
	 * type.
	 * 
	 * @param log
	 *            log when <code>true</code>.
	 */
	void setDoLog(boolean log);
}