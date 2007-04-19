/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.wicket.examples.repeater;

import java.util.Iterator;

import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;


/**
 * implementation of IDataProvider for contacts that keeps track of sort
 * information
 * 
 * @author igor
 * 
 */
public class SortableContactDataProvider extends SortableDataProvider
{
	/**
	 * constructor
	 */
	public SortableContactDataProvider()
	{
		// set default sort
		setSort("firstName", true);
	}

	protected ContactsDatabase getContactsDB()
	{
		return DatabaseLocator.getDatabase();
	}

	/**
	 * @see org.apache.wicket.markup.repeater.data.IDataProvider#iterator(int, int)
	 */
	public Iterator iterator(int first, int count)
	{
		SortParam sp = getSort();
		return getContactsDB().find(first, count, sp.getProperty(), sp.isAscending()).iterator();
	}

	/**
	 * @see org.apache.wicket.markup.repeater.data.IDataProvider#size()
	 */
	public int size()
	{
		return getContactsDB().getCount();
	}

	/**
	 * @see org.apache.wicket.markup.repeater.data.IDataProvider#model(java.lang.Object)
	 */
	public IModel model(Object object)
	{
		return new DetachableContactModel((Contact)object);
	}

}
