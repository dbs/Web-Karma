/**
 * 
 */
package edu.isi.karma.view;

import edu.isi.karma.rep.Workspace;

/**
 * @author szekely
 * 
 */
public class VWorkspace {

	private final Workspace workspace;

	private final ViewFactory viewFactory = new ViewFactory();

	private final VWorksheetList vWorksheets = new VWorksheetList();

	private final ViewPreferences preferences = new ViewPreferences();

	public VWorkspace(Workspace workspace) {
		super();
		this.workspace = workspace;
	}

	public Workspace getWorkspace() {
		return workspace;
	}

	public ViewFactory getViewFactory() {
		return viewFactory;
	}

	public VWorksheetList getVWorksheetList() {
		return vWorksheets;
	}

	public ViewPreferences getPreferences() {
		return preferences;
	}
	
	/**
	 * View all worksheets.
	 */
	public void addAllWorksheets() {
		vWorksheets.addWorksheets(workspace.getWorksheets(), this);
	}

	public VWorksheet getVWorksheet(String worksheetId) {
		return vWorksheets.getVWorksheet(worksheetId);
	}
}
