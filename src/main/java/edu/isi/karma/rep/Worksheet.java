/**
 * 
 */
package edu.isi.karma.rep;

import java.io.PrintWriter;

/**
 * @author szekely
 * 
 */
public class Worksheet extends RepEntity {

	private HTable headers;
	private Table dataTable;

	@Override
	public void prettyPrint(String prefix, PrintWriter pw, RepFactory factory) {
		pw.print(prefix);
		pw.println("Worksheet/" + id);
		headers.prettyPrint(prefix + "  ", pw, factory);
		dataTable.prettyPrint(prefix + "  ", pw, factory);
	}

	Worksheet(String id, HTable headers, Table dataTable) {
		super(id);
		this.headers = headers;
		this.dataTable = dataTable;
	}

	/**
	 * When a new HNode is added to a table or one of the nested tables, we need
	 * to go through and add place holders in the data table to hold the values
	 * for the new HNode.
	 * 
	 * @param newHNode
	 */
	void addNodeToDataTable(HNode newHNode, RepFactory factory) {
		dataTable.addNodeToDataTable(newHNode, factory);
	}

	public HTable getHeaders() {
		return headers;
	}

	public Table getDataTable() {
		return dataTable;
	}

	public String getTitle() {
		return headers.getTableName();
	}

	/**
	 * Convenience method to add rows to the top table.
	 * 
	 * @param factory
	 * @return the added row.
	 */
	public Row addRow(RepFactory factory) {
		return dataTable.addRow(factory);
	}

	/**
	 * Convenience method to add HNodes to the top table.
	 * 
	 * @param columnName
	 * @param factory
	 * @return The added HNode.
	 */
	public HNode addHNode(String columnName, RepFactory factory) {
		return headers.addHNode(columnName, this, factory);
	}

	/**
	 * This HNode received a new nested HTable. We need to go through the data
	 * table and make sure we have placeholders to hold values for this table.
	 * 
	 * @param hNode
	 * @param factory
	 */
	public void addNestedTableToDataTable(HNode hNode, RepFactory factory) {
		dataTable.addNestedTableToDataTable(hNode, factory);
	}

}
