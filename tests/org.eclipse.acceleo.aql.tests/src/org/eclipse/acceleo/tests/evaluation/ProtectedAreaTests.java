/*******************************************************************************
 *  Copyright (c) 2023 Obeo. 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *   
 *   Contributors:
 *       Obeo - initial API and implementation
 *  
 *******************************************************************************/
package org.eclipse.acceleo.tests.evaluation;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.acceleo.tests.utils.AbstractEvaluationTestSuite;
import org.junit.runners.Parameterized.Parameters;

/**
 * Tests {@link org.eclipse.acceleo.ForStatement ForStatement}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class ProtectedAreaTests extends AbstractEvaluationTestSuite {

	/**
	 * Constructor.
	 * 
	 * @param testFolder
	 *            the test folder
	 * @throws IOException
	 *             if the tested template can't be read
	 * @throws DocumentParserException
	 *             if the tested template can't be parsed
	 */
	public ProtectedAreaTests(String testFolder) throws IOException {
		super(testFolder);
	}

	/**
	 * Gets test folders from resources/feature.
	 * 
	 * @return test folders from resources/feature
	 */
	@Parameters(name = "{0}")
	public static Collection<Object[]> retrieveTestFolders() {
		return retrieveTestFolders("resources/evaluation/protectedArea");
	}

}
