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
package nl.inl.blacklab.perdocument;

/**
 * For grouping DocResult objects by the value of a stored field in the Lucene documents. The field
 * name is given when instantiating this class, and might be "author", "year", and such.
 */
public class DocPropertyStoredField extends DocProperty {
	private String fieldName;
	private String friendlyName;

	public DocPropertyStoredField(String fieldName) {
		this(fieldName, fieldName);
	}

	public DocPropertyStoredField(String fieldName, String friendlyName) {
		this.fieldName = fieldName;
		this.friendlyName = friendlyName;
	}

	@Override
	public String get(DocResult result) {
		return result.getDocument().get(fieldName);
	}

	@Override
	public String getName() {
		return friendlyName;
	}

}