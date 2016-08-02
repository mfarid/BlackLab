package nl.inl.blacklab.server.jobs;

import nl.inl.blacklab.perdocument.DocGroups;
import nl.inl.blacklab.perdocument.DocResults;
import nl.inl.blacklab.server.dataobject.DataObjectMapElement;
import nl.inl.blacklab.server.exceptions.BlsException;
import nl.inl.blacklab.server.search.SearchManager;

/**
 * Represents a hits search and sort operation.
 */
public class JobDocsGrouped extends Job {

	public static class JobDescDocsGrouped extends JobDescription {

		DocGroupSettings groupSettings;

		public JobDescDocsGrouped(JobDescription docsToGroup, DocGroupSettings groupSettings) {
			super(JobDocsGrouped.class, docsToGroup);
			this.groupSettings = groupSettings;
		}

		@Override
		public DocGroupSettings getDocGroupSettings() {
			return groupSettings;
		}

		@Override
		public String uniqueIdentifier() {
			return super.uniqueIdentifier() + groupSettings + ")";
		}

		@Override
		public DataObjectMapElement toDataObject() {
			DataObjectMapElement o = super.toDataObject();
			o.put("groupSettings", groupSettings);
			return o;
		}

	}

	private DocGroups groups;

	private DocResults docResults;

	public JobDocsGrouped(SearchManager searchMan, User user, JobDescription par) throws BlsException {
		super(searchMan, user, par);
	}

	@Override
	public void performSearch() throws BlsException {
		docResults = ((JobWithDocs)inputJob).getDocResults();
		setPriorityInternal();
		DocGroupSettings groupSett = jobDesc.getDocGroupSettings();
		DocGroups theGroups = docResults.groupedBy(groupSett.groupBy());

		DocGroupSortSettings sortSett = jobDesc.getDocGroupSortSettings();
		if (sortSett != null)
			theGroups.sort(sortSett.sortBy(), sortSett.reverse());

		groups = theGroups; // we're done, caller can use the groups now
	}

	public DocGroups getGroups() {
		return groups;
	}

	public DocResults getDocResults() {
		return docResults;
	}

	@Override
	public DataObjectMapElement toDataObject(boolean debugInfo) throws BlsException {
		DataObjectMapElement d = super.toDataObject(debugInfo);
		d.put("numberOfDocResults", docResults == null ? -1 : docResults.size());
		d.put("numberOfGroups", groups == null ? -1 : groups.numberOfGroups());
		return d;
	}

	@Override
	protected void cleanup() {
		groups = null;
		docResults = null;
		super.cleanup();
	}

	@Override
	protected DocResults getObjectToPrioritize() {
		return docResults;
	}

}