package managers;

public enum CourseFilters {
	NAME, HOURS, MINVALUE, MAXVALUE;
	
	public static String[] options = { "Name", "Hours", "< Value", "> Value" };
	
	CourseFilters getFilterName(int place) {
		if( place != -1) {
			for(CourseFilters filter : CourseFilters.values()) {
				if(filter.ordinal() == place) {
					return filter;
				}
			}
		}
		return null;
	}
}
