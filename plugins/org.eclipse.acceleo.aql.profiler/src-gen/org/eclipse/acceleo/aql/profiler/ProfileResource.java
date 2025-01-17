/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.acceleo.aql.profiler;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Profile Resource</b></em>'. <!--
 * end-user-doc --> <!-- begin-model-doc --> The root {@link ProfileEntry} container. Can be extended by
 * connectors to fit needs. <!-- end-model-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.acceleo.aql.profiler.ProfileResource#getEntry <em>Entry</em>}</li>
 * </ul>
 *
 * @see org.eclipse.acceleo.aql.profiler.ProfilerPackage#getProfileResource()
 * @model
 * @generated
 */
public interface ProfileResource extends EObject {
	/**
	 * Returns the value of the '<em><b>Entry</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc --> The root {@link ProfileEntry}. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Entry</em>' containment reference.
	 * @see #setEntry(ProfileEntry)
	 * @see org.eclipse.acceleo.aql.profiler.ProfilerPackage#getProfileResource_Entry()
	 * @model containment="true"
	 * @generated
	 */
	ProfileEntry getEntry();

	/**
	 * Sets the value of the '{@link org.eclipse.acceleo.aql.profiler.ProfileResource#getEntry
	 * <em>Entry</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Entry</em>' containment reference.
	 * @see #getEntry()
	 * @generated
	 */
	void setEntry(ProfileEntry value);

} // ProfileResource
