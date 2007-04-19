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

import org.apache.wicket.extensions.markup.html.repeater.data.grid.DataGridView;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.PropertyPopulator;

/**
 * demo page for the datatable component
 * 
 * @see org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable
 * 
 * @author igor
 */
public class DataGridPage extends BasePage
{
	/**
	 * constructor
	 */
	public DataGridPage()
	{
		ICellPopulator[] columns = new ICellPopulator[5];

		columns[0] = new PropertyPopulator("id");
		columns[1] = new PropertyPopulator("firstName");
		columns[2] = new PropertyPopulator("lastName");
		columns[3] = new PropertyPopulator("homePhone");
		columns[4] = new PropertyPopulator("cellPhone");

		add(new DataGridView("rows", columns, new SortableContactDataProvider()));
	}
}
