package managers;

public enum EmployeeFilters {
	NAME, FIRM, POSITION, MINMONTH, MAXMONTH, COURSE;
	
	public static String[] options = { "Name", "Firm", "Position","< Date(dd-MM-yy)", "> Date(dd-MM-yy)"};
	
	EmployeeFilters getFilterName(int place) {
		if( place != -1) {
			for(EmployeeFilters filter : EmployeeFilters.values()) {
				if(filter.ordinal() == place) {
					return filter;
				}
			}
		}
		return null;
	}
}
