package managers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.hibernate.SessionFactory;
import dao.CourseDAO;
import dao.EmployeeDAO;
import objects.Course;
import objects.Employee;

public class DocumentManager {
	// Static variable reference of single_instance
    // of type Singleton
    private static DocumentManager instance = null;
    
    private PageType pageType = PageType.EMPLOYEE_PAGE;
    private int selectedFilterIndex = -1;
    private String searchFilter = null;
    
	private SessionFactory dbFactory;
	
	private List<Employee> employeeList = Collections.emptyList();
	private List<Course> courseList = Collections.emptyList();
	
	private int selectedItemIndex = -1;
	
	private int selectedCourseFilter = -1;
    
	private String savingMode = "add";

	// Static method
    // Static method to create instance of Singleton class
    public static DocumentManager getInstance()
    {
        if (instance == null)
        	instance = new DocumentManager();
 
        return instance;
    }

	public int getSelectedCourseFilter() {
		return selectedCourseFilter;
	}

	public void setSelectedCourseFilter(int selectedCourseFilter) {
		this.selectedCourseFilter = selectedCourseFilter;
	}

	public PageType getPageType() {
		return pageType;
	}

	public void setPageType(PageType pageType) {
		this.pageType = pageType;
	}
	
	public String getSavingMode() {
		return savingMode;
	}

	public void setSavingMode(String savingMode) {
		this.savingMode = savingMode;
	}

	public SessionFactory getFactory() {
		return dbFactory;
	}

	public void setFactory(SessionFactory factory) {
		this.dbFactory = factory;
	}

	public int getSelectedFilterIndex() {
		return selectedFilterIndex;
	}

	public void setSelectedFilterIndex(int selectedFilterIndex) {
		this.selectedFilterIndex = selectedFilterIndex;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public int getSelectedItemIndex() {
		return selectedItemIndex;
	}

	public void setSelectedItemIndex(int selectedItemIndex) {
		this.selectedItemIndex = selectedItemIndex;
	}
	
	public Integer getSelectedItemId() {
		if (selectedItemIndex != -1) {

			if(pageType.equals(PageType.EMPLOYEE_PAGE)) {
				return employeeList.get(selectedItemIndex).getId();
			} else {
				return courseList.get(selectedItemIndex).getIdCourse();
			}
		} else {
			return null;
		}
	}
	
	public void deleteItem() {
		if(pageType.equals(PageType.EMPLOYEE_PAGE)) {
			EmployeeDAO.delete(getSelectedItemId());
		} else {
			CourseDAO.deleteCourse(getSelectedItemId());
		}
	}

	public List<Employee> getFilteredEmployeeList() {
		EmployeeDAO.getEmployees();
		if (selectedFilterIndex == -1 || searchFilter == null) {
			return EmployeeDAO.getEmployees();
		} else if(selectedFilterIndex == EmployeeFilters.NAME.ordinal()) {
			return EmployeeDAO.getEmployeesByName(searchFilter);
		} else if(selectedFilterIndex == EmployeeFilters.FIRM.ordinal()) {
			return EmployeeDAO.getEmployeesByFirm(searchFilter);
		} else if(selectedFilterIndex == EmployeeFilters.POSITION.ordinal()) {
			return EmployeeDAO.getEmployeesByPosition(searchFilter);
		} else if(selectedFilterIndex == EmployeeFilters.MINMONTH.ordinal()) {
			try {
				Date date = new SimpleDateFormat("dd-MM-yy").parse(searchFilter);
				return EmployeeDAO.getEmployeesLessThanDate(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else if(selectedFilterIndex == EmployeeFilters.MAXMONTH.ordinal()) {
			try {
				Date date = new SimpleDateFormat("dd-MM-yy").parse(searchFilter);
				return EmployeeDAO.getEmployeesBiggerThanDate(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else if(selectedFilterIndex == EmployeeFilters.COURSE.ordinal()) {
			int id = getCourseIdByRow(selectedCourseFilter);
			return EmployeeDAO.getEmployeesThatMatchCourse(id);
		}
		return null;
	}
	
	public List<Course> getFilteredCourseList() {
		if (selectedFilterIndex == -1 || searchFilter == null) {
			return CourseDAO.getCourses();
		} else if(selectedFilterIndex == CourseFilters.NAME.ordinal()) {
			return CourseDAO.getCoursesByName(searchFilter);
		} else if(selectedFilterIndex == CourseFilters.HOURS.ordinal()) {
			try {
				int value = Integer.parseInt(searchFilter);
				return CourseDAO.getCoursesByHours(value);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		} else if(selectedFilterIndex == CourseFilters.MINVALUE.ordinal()) {
			try {
				int value = Integer.parseInt(searchFilter);
				return CourseDAO.getCoursesLessThanValue(value);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		} else if(selectedFilterIndex == CourseFilters.MAXVALUE.ordinal()) {
			try {
				int value = Integer.parseInt(searchFilter);
				return CourseDAO.getCoursesBiggerThanValue(value);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public String getSearchFilter() {
		return searchFilter;
	}

	public void setSearchFilter(String searchFilter) {
		this.searchFilter = searchFilter;
	}
	
	public Date convertToDate(String dateString) {
		try {
			Date date = new SimpleDateFormat("dd-MM-yy").parse(dateString);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Employee getEmployeByRow(int row) {
		return employeeList.get(row);
	}
	
	public Course getCourseByRow(int row) {
		return courseList.get(row);
	}
	
	public int getCurrentSelectedEmployeeId() {
		return employeeList.get(selectedItemIndex).getId();
	}
	
	public int getCurrentSelectedCourseId() {
		return courseList.get(selectedItemIndex).getIdCourse();
	}
	
	public int getCourseIdByRow(int row) {
		return courseList.get(row).getIdCourse();
	}
}
