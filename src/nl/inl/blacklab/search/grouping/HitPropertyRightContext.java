/*******************************************************************************
 * Copyright (c) 2010, 2012 Institute for Dutch Lexicology
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package nl.inl.blacklab.search.grouping;

import nl.inl.blacklab.search.Hit;

/**
 * A hit property for grouping on the context of the hit. Requires HitConcordances as input (so we
 * have the hit text available).
 */
public class HitPropertyRightContext extends HitProperty {
	boolean lowerCase;

	public HitPropertyRightContext(boolean lowerCase) {
		super();
		this.lowerCase = lowerCase;
	}

	public HitPropertyRightContext() {
		this(false);
	}

	@Override
	public String get(Hit result) {
		if (result.conc == null) {
			throw new RuntimeException("Can only sort/group on context if results are concordances");
		}
		// NOTE: disabled XML stripping because we use the forward index or term vector for
		// sorting/grouping!
		return lowerCase ? result.conc[2].toLowerCase() : result.conc[2];
		// return Utilities.xmlToSortable(result.conc[2], lowerCase);
	}

	@Override
	public boolean needsConcordances() {
		return true;
	}

	@Override
	public String getName() {
		return "right context";
	}

}