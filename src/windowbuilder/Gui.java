package windowbuilder;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import dao.CourseDAO;
import dao.EmployeeDAO;
import managers.CourseFilters;
import managers.DocumentManager;
import managers.EmployeeFilters;
import managers.PageType;
import objects.Course;
import objects.Employee;

import javax.swing.JMenuBar;
import javax.swing.JTextPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Date;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Gui {

	private JFrame frame;
	private JTable tableWithTabInformation;
	private JTable selectCourseTable;

	// JLabels
	private JLabel currentPageInformation = new JLabel("Employee information:");
	private JLabel selectCourseLabel = new JLabel("Select course from the list:");

	// Buttons
	private JButton add;
	private JButton remove;
	private JButton edit;
	private JButton filterByCourse;
	private JButton coursesInformationButton;
	private JButton employeeInformationButton;
	private JButton searchButton;
	private JButton refresh;
	JButton addCourseClose;
	JButton addCourseSave;

	private JTextPane searchBar;
	private JLayeredPane layeredPane;
	private JLabel addUserlbl2;
	private JLabel addUserlbl3;
	private JLabel lblNewLabel_3;
	private JTextField addUserNameTextField;
	private JTextField addUserFirmTextField;
	private JTextField addUserPositionTextField;
	private JTextField addUserDateTextField;
	private JLabel addSavePanelLabel;
	private JButton addUserSave;
	private JScrollPane mainPanel;

	private JComboBox<String> searchFilters;
	private JLabel emptyLbl0;
	private JLabel errorLabel;
	private JPanel removeConfirmationPanel;
	private JPanel addUserPanel;
	private JScrollPane scrollPane;
	private JLabel removeConfirmationLbl;
	private JButton removeConfirmationYes;
	private JButton removeConfirmationNo;
	private JButton addUserClose;
	private JPanel panel_1;
	private JLabel space;
	private JButton searchSelectedCourse;
	private JButton btnNewButton;
	private JPanel addCoursePanel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField addCourseNameTxt;
	private JTextField addCourseHourTxt;
	private JTextField addCourseDiplomaTxt;
	private JTextField addCourseValueTxt;
	private JTextField addCourseUserId;

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1017, 568);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// initialize filter buttons
		filterByCourse = new JButton("Filter employees by courses");
		filterByCourse.setFocusPainted(false);

		layeredPane = new JLayeredPane();

		mainPanel = new JScrollPane();

		removeConfirmationPanel = new JPanel();
		removeConfirmationPanel.setVisible(false);

		panel_1 = new JPanel();

		errorLabel = new JLabel("Error: Selected item is invalid.");
		errorLabel.setVisible(false);
		errorLabel.setForeground(Color.RED);
		
		searchSelectedCourse = new JButton("Search");
		searchSelectedCourse.setFocusPainted(false);
		
		btnNewButton = new JButton("Close");
		btnNewButton.setFocusPainted(false);
	
		// create groupLayout
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(currentPageInformation)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(filterByCourse))
						.addComponent(mainPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
						.addComponent(removeConfirmationPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(70)
							.addComponent(errorLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(87)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(selectCourseLabel)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnNewButton)
									.addGap(18)
									.addComponent(searchSelectedCourse)))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(currentPageInformation)
						.addComponent(filterByCourse)
						.addComponent(selectCourseLabel)
						.addComponent(searchSelectedCourse)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(layeredPane)
						.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(removeConfirmationPanel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(errorLabel)
							.addGap(14))))
		);

		space = new JLabel("");
		space.setPreferredSize(new Dimension(20, 0));
		panel_1.add(space);

		// initialize edit button
		edit = new JButton("");
		panel_1.add(edit);
		edit.setFocusPainted(false);
		edit.setIcon(new ImageIcon("C:\\Users\\bochi\\Downloads\\Java Tech\\Images\\outline_edit_black_24dp.png"));
		edit.setPreferredSize(new Dimension(35, 35));
		edit.setForeground(Color.WHITE);
		edit.setBackground(Color.WHITE);

		// initialize remove button
		remove = new JButton("");
		panel_1.add(remove);
		remove.setFocusPainted(false);
		remove.setIcon(new ImageIcon("C:\\Users\\bochi\\Downloads\\Java Tech\\Images\\outline_delete_black_18dp.png"));
		remove.setPreferredSize(new Dimension(35, 35));
		remove.setForeground(Color.WHITE);
		remove.setBackground(Color.WHITE);

		// initialize add button
		add = new JButton("");
		panel_1.add(add);
		add.setFocusPainted(false);
		add.setIcon(new ImageIcon("C:\\Users\\bochi\\Downloads\\Java Tech\\Images\\outline_add_circle_outline_black_24dp.png"));
		add.setPreferredSize(new Dimension(35, 35));
		add.setForeground(Color.WHITE); 
		add.setBackground(Color.WHITE);

		removeConfirmationLbl = new JLabel("Do you want to remove this item?");
		removeConfirmationPanel.add(removeConfirmationLbl);

		removeConfirmationYes = new JButton("Yes");
		removeConfirmationYes.setFocusPainted(false);
		removeConfirmationPanel.add(removeConfirmationYes);

		removeConfirmationNo = new JButton("No");
		removeConfirmationNo.setFocusPainted(false);
		removeConfirmationPanel.add(removeConfirmationNo);

		// add main table
		tableWithTabInformation = new JTable();
		tableWithTabInformation.setDefaultEditor(Object.class, null);
		tableWithTabInformation.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		mainPanel.setViewportView(tableWithTabInformation);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 373, 345);
		layeredPane.add(scrollPane);
		
		selectCourseTable = new JTable();
		selectCourseTable.setDefaultEditor(Object.class, null);
		selectCourseTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(selectCourseTable);

		addUserPanel = new JPanel();
		layeredPane.setLayer(addUserPanel, 4);
		addUserPanel.setBounds(0, 0, 373, 345);
		layeredPane.add(addUserPanel);

		JLabel addUserlbl1 = new JLabel("Employee name:");

		addUserlbl2 = new JLabel("Firm:");

		addUserlbl3 = new JLabel("Position:");

		lblNewLabel_3 = new JLabel("Date of employement:");

		addUserNameTextField = new JTextField();
		addUserNameTextField.setColumns(10);

		addUserFirmTextField = new JTextField();
		addUserFirmTextField.setColumns(10);

		addUserPositionTextField = new JTextField();
		addUserPositionTextField.setColumns(10);

		addUserDateTextField = new JTextField();
		addUserDateTextField.setColumns(10);

		addSavePanelLabel = new JLabel("Add user");

		addUserSave = new JButton("Save");

		addUserSave.setFocusPainted(false);

		addUserClose = new JButton("Close");

		addUserClose.setFocusPainted(false);
		GroupLayout gl_addUserPanel = new GroupLayout(addUserPanel);
		gl_addUserPanel.setHorizontalGroup(
				gl_addUserPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_addUserPanel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_addUserPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_addUserPanel.createSequentialGroup()
										.addComponent(addUserClose)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(addUserSave))
								.addGroup(gl_addUserPanel.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_addUserPanel.createSequentialGroup()
												.addGroup(gl_addUserPanel.createParallelGroup(Alignment.LEADING)
														.addComponent(addUserlbl1)
														.addComponent(addUserlbl2)
														.addComponent(addUserlbl3))
												.addGap(46)
												.addGroup(gl_addUserPanel.createParallelGroup(Alignment.LEADING, false)
														.addComponent(addUserPositionTextField)
														.addComponent(addUserFirmTextField)
														.addComponent(addUserNameTextField, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
														.addComponent(addSavePanelLabel)))
										.addGroup(gl_addUserPanel.createSequentialGroup()
												.addComponent(lblNewLabel_3)
												.addGap(18)
												.addComponent(addUserDateTextField))))
						.addContainerGap(83, Short.MAX_VALUE))
				);
		gl_addUserPanel.setVerticalGroup(
				gl_addUserPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_addUserPanel.createSequentialGroup()
						.addContainerGap()
						.addComponent(addSavePanelLabel)
						.addGap(36)
						.addGroup(gl_addUserPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(addUserlbl1)
								.addComponent(addUserNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(30)
						.addGroup(gl_addUserPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(addUserFirmTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(addUserlbl2))
						.addGap(32)
						.addGroup(gl_addUserPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(addUserlbl3)
								.addComponent(addUserPositionTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(32)
						.addGroup(gl_addUserPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(addUserDateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(26)
						.addGroup(gl_addUserPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(addUserSave)
								.addComponent(addUserClose))
						.addContainerGap(61, Short.MAX_VALUE))
				);
		addUserPanel.setLayout(gl_addUserPanel);
		
		addCoursePanel = new JPanel();
		layeredPane.setLayer(addCoursePanel, 3);
		addCoursePanel.setBounds(0, 0, 373, 345);
		layeredPane.add(addCoursePanel);
		
		lblNewLabel = new JLabel("Add Course");
		
		lblNewLabel_1 = new JLabel("Name");
		
		lblNewLabel_2 = new JLabel("Hour");
		
		lblNewLabel_4 = new JLabel("Diploma");
		
		lblNewLabel_5 = new JLabel("Value");
		
		addCourseNameTxt = new JTextField();
		addCourseNameTxt.setColumns(10);
		
		addCourseHourTxt = new JTextField();
		addCourseHourTxt.setColumns(10);
		
		addCourseDiplomaTxt = new JTextField();
		addCourseDiplomaTxt.setColumns(10);
		
		addCourseValueTxt = new JTextField();
		addCourseValueTxt.setColumns(10);
		
		addCourseClose = new JButton("Close");
		addCourseSave = new JButton("Save");
		
		JLabel lblNewLabel_6 = new JLabel("UserId");
		
		addCourseUserId = new JTextField();
		addCourseUserId.setColumns(10);
		GroupLayout gl_addCoursePanel = new GroupLayout(addCoursePanel);
		gl_addCoursePanel.setHorizontalGroup(
			gl_addCoursePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_addCoursePanel.createSequentialGroup()
					.addGroup(gl_addCoursePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_addCoursePanel.createSequentialGroup()
							.addGap(158)
							.addComponent(lblNewLabel))
						.addGroup(gl_addCoursePanel.createSequentialGroup()
							.addGap(46)
							.addGroup(gl_addCoursePanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_6))
							.addGap(52)
							.addGroup(gl_addCoursePanel.createParallelGroup(Alignment.LEADING)
								.addComponent(addCourseUserId, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
								.addComponent(addCourseValueTxt, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
								.addComponent(addCourseNameTxt, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
								.addComponent(addCourseHourTxt, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
								.addComponent(addCourseDiplomaTxt, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
							.addGap(5)))
					.addGap(60))
				.addGroup(Alignment.TRAILING, gl_addCoursePanel.createSequentialGroup()
					.addContainerGap(230, Short.MAX_VALUE)
					.addComponent(addCourseClose)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(addCourseSave)
					.addGap(21))
		);
		gl_addCoursePanel.setVerticalGroup(
			gl_addCoursePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_addCoursePanel.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel)
					.addGap(28)
					.addGroup(gl_addCoursePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(addCourseNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(31)
					.addGroup(gl_addCoursePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(addCourseHourTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_addCoursePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(addCourseDiplomaTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_addCoursePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(addCourseValueTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_addCoursePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(addCourseUserId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_addCoursePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(addCourseClose)
						.addComponent(addCourseSave))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		addCoursePanel.setLayout(gl_addCoursePanel);
		frame.getContentPane().setLayout(groupLayout);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		employeeInformationButton = new JButton("Employee information");
		employeeInformationButton.setFocusPainted(false);
		menuBar.add(employeeInformationButton);

		coursesInformationButton = new JButton("Courses information");
		coursesInformationButton.setFocusPainted(false);
		menuBar.add(coursesInformationButton);

		// initialize search bar
		searchBar = new JTextPane();

		searchBar.setText("Write here...");
		searchBar.setToolTipText("");
		searchBar.setCaretColor(new Color(0, 0, 139));
		menuBar.add(searchBar);

		// initialize search filters
		searchFilters = new JComboBox<String>();

		menuBar.add(searchFilters);

		emptyLbl0 = new JLabel("");
		emptyLbl0.setPreferredSize(new Dimension(5, 0));
		menuBar.add(emptyLbl0);

		searchButton = new JButton("Search");
		searchButton.setFocusPainted(false);
		menuBar.add(searchButton);

		JLabel emptyLbl1 = new JLabel("");
		emptyLbl1.setPreferredSize(new Dimension(5, 0));
		menuBar.add(emptyLbl1);

		refresh = new JButton("");
		refresh.setIcon(new ImageIcon("C:\\Users\\bochi\\Downloads\\Java Tech\\Images\\outline_refresh_black_24dp.png"));
		refresh.setPreferredSize(new Dimension(30, 20));
		refresh.setForeground(Color.WHITE);
		refresh.setFocusPainted(false);
		refresh.setBackground(Color.WHITE);
		menuBar.add(refresh);

		JLabel emptyLbl2 = new JLabel("");
		emptyLbl2.setPreferredSize(new Dimension(5, 0));
		menuBar.add(emptyLbl2);

		initializeFirstState();
		initializeActions();
	}

	private void initializeFirstState() {
		employeeInformationButton.setBackground(Color.GRAY);
		coursesInformationButton.setBackground(null);
		currentPageInformation.setText("Employee's Information");

		// set layered pane to invisible
		layeredPane.setVisible(false);
		selectCourseLabel.setVisible(false);
		searchSelectedCourse.setVisible(false);
		btnNewButton.setVisible(false);
		
		initializeEmployeesTable();
		initializeEmployeesFilters();

		//selectCourseLabel.setVisible(false);
	}

	private void initializeActions() {
		searchBarAction();
		modifyDbContentActions();
		filterActions();
		pageLevelActions();
		refreshButtonActions();
		filterComboActions();
		removeConfirmationActions();
		addSearchAction();
		addUserActions();
		addSearchSelectedCourseAction();
		addCourseActions();
	}

	private void addCourseActions() {
		addCourseClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.setVisible(false);
			}
		});
		addCourseSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameString = addCourseNameTxt.getText();
				String hourString = addCourseHourTxt.getText();
				String diplomaString = addCourseDiplomaTxt.getText();
				String valueString = addCourseValueTxt.getText();
				String userIdString = addCourseUserId.getText();
								
				if (nameString != "" && hourString != "" && diplomaString != "" && valueString != "" && userIdString != "") {
					try{
			            int id = Integer.parseInt(userIdString);
			            int hour = Integer.parseInt(hourString);
			            int value = Integer.parseInt(valueString);
			            
			            Employee employee = EmployeeDAO.getEmployeesById(id);
			            if(employee != null) {
			            	if(DocumentManager.getInstance().getSavingMode().equals("add")) {
			            		CourseDAO.insert(id, nameString, hour, value, diplomaString, 2021, employee);
							} else {
								int idCourse = DocumentManager.getInstance().getCurrentSelectedCourseId();
								CourseDAO.update(idCourse, nameString, hour, value, diplomaString, 2021, employee);
							}
			            	
			            	addCourseNameTxt.setText("");
			            	addCourseHourTxt.setText("");
			            	addCourseDiplomaTxt.setText("");
			            	addCourseValueTxt.setText("");
			            	addCourseUserId.setText("");
							initializeCoursesTable();
			            }	
			        }
			        catch (NumberFormatException ex){
			            ex.printStackTrace();
			        }
					
				}
			}
		});
	}

	// SEARCH
	private void addSearchAction() {
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DocumentManager.getInstance().setSearchFilter(searchBar.getText());
				initializeMainTable();
			}
		});
	}

	private void removeConfirmationActions() {
		removeConfirmationYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DocumentManager.getInstance().deleteItem();
				removeConfirmationPanel.setVisible(false);
				tableWithTabInformation.setEnabled(true);
				initializeMainTable();
			}
		});

		removeConfirmationNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeConfirmationPanel.setVisible(false);
				tableWithTabInformation.setEnabled(true);
			}
		});
	}
	private void initializeMainTable() {
		PageType pg = DocumentManager.getInstance().getPageType();
		if(pg.equals(PageType.EMPLOYEE_PAGE)) {
			initializeEmployeesTable();
		} else {
			initializeCoursesTable();
		}
	}

	private void initializeEmployeesTable() {
		Object[] columns = {"Id", "Name", "Firm", "Position", "Date Of Employement"};
		DefaultTableModel model = new DefaultTableModel();

		List<Employee> employees = DocumentManager.getInstance().getFilteredEmployeeList();

		model.setColumnIdentifiers(columns);

		if(employees != null) {
			model.setRowCount(0);
			Object row[] = new Object[columns.length];
			for(Employee e : employees) {
				row[0] = e.getId();
				row[1] = e.getName();
				row[2] = e.getFirm();
				row[3] = e.getPosition();
				row[4] = e.getDateOfEmployement();
				model.addRow(row);
			}

			tableWithTabInformation.setModel(model);
		}		
	}


	private void initializeEmployeesFilters() {

		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>( EmployeeFilters.options );
		searchFilters.setModel( model );
		searchFilters.setRenderer(new MyComboBoxRenderer("Filter"));
		searchFilters.setSelectedIndex(-1); 
	}

	private void initializeCourseFilters() {

		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>( CourseFilters.options );
		searchFilters.setModel( model );
		searchFilters.setRenderer(new MyComboBoxRenderer("Filter"));
		searchFilters.setSelectedIndex(-1); 
	}

	private void initializeCoursesTable() {
		Object[] columns = {"id_course", "name", "hours", "diploma", "year", "value", "id_employee"};
		DefaultTableModel model = new DefaultTableModel();
		List<Course> courses = DocumentManager.getInstance().getFilteredCourseList();

		model.setColumnIdentifiers(columns);

		if(courses != null) {
			model.setRowCount(0);
			Object row[] = new Object[columns.length];
			for(Course c : courses) {
				row[0] = c.getIdCourse();
				row[1] = c.getName();
				row[2] = c.getNumberOfHours();
				row[3] = c.getGraduationDiploma();
				row[4] = c.getYear();
				row[5] = c.getValue();
				row[6] = c.getEmployeeId();
				model.addRow(row);
			}

			tableWithTabInformation.setModel(model);
		}
	}
	
	private void initializeSecondCoursesTable() {
		Object[] columns = {"id_course", "name", "hours", "diploma", "year", "value"};
		DefaultTableModel model = new DefaultTableModel();
		List<Course> courses = DocumentManager.getInstance().getFilteredCourseList();

		model.setColumnIdentifiers(columns);

		if(courses != null) {
			model.setRowCount(0);
			Object row[] = new Object[columns.length];
			for(Course c : courses) {
				row[0] = c.getIdCourse();
				row[1] = c.getName();
				row[2] = c.getNumberOfHours();
				row[3] = c.getGraduationDiploma();
				row[4] = c.getYear();
				row[5] = c.getValue();
				model.addRow(row);
			}

			selectCourseTable.setModel(model);
		}
	}

	private void filterComboActions() {
		searchFilters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DocumentManager.getInstance().setSelectedFilterIndex(searchFilters.getSelectedIndex());
			}
		});
	}

	private void refreshButtonActions() {
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (DocumentManager.getInstance().getPageType().equals(PageType.EMPLOYEE_PAGE)) {
					initializeEmployeesFilters();
					initializeEmployeesTable();
				} else {
					initializeCourseFilters();
					initializeCoursesTable();
				}
				searchBar.setText("Write here...");
				errorLabel.setVisible(false);
				removeConfirmationPanel.setVisible(false);
			}
		});
	}

	private void pageLevelActions() {

		employeeInformationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employeeInformationButton.setBackground(Color.GRAY);
				coursesInformationButton.setBackground(null);
				currentPageInformation.setText("Employee's Information");
				DocumentManager.getInstance().setPageType(PageType.EMPLOYEE_PAGE);

				// initialize table
				initializeEmployeesTable();

				// initialize filters for employees
				initializeEmployeesFilters();

				filterByCourse.setVisible(true);

				searchBar.setText("Write here...");
			}
		});

		coursesInformationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coursesInformationButton.setBackground(Color.GRAY);
				employeeInformationButton.setBackground(null);
				currentPageInformation.setText("Course's Information:");
				DocumentManager.getInstance().setPageType(PageType.COURSES_PAGE);

				// initialize table
				initializeCoursesTable();

				// initialize filters for course
				initializeCourseFilters();

				filterByCourse.setVisible(false);

				searchBar.setText("Write here...");
			}
		});
	}

	private void filterActions() {

		filterByCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.setVisible(true);
				layeredPane.setVisible(true);
				searchSelectedCourse.setVisible(true);
				btnNewButton.setVisible(true);
				switchScrollPanels(scrollPane);
				initializeSecondCoursesTable();
			}
		});
	}

	private void modifyDbContentActions() {

		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tableWithTabInformation.getSelectedRow();

				if(checkValidEntry(selectedRow)) {
					DocumentManager.getInstance().setSavingMode("save");
					if(DocumentManager.getInstance().getPageType() == PageType.EMPLOYEE_PAGE) {
						Employee employee = DocumentManager.getInstance().getEmployeByRow(selectedRow);
						initializeUpdateEmployeePanel(employee);
					} else {
						Course course = DocumentManager.getInstance().getCourseByRow(selectedRow);
						initializeUpdateCoursePanel(course);
					}
				}
			}
			private void initializeUpdateEmployeePanel(Employee employee) {
				layeredPane.setVisible(true);
				switchPanels(addUserPanel);
				addUserNameTextField.setText(employee.getName());
				addUserFirmTextField.setText(employee.getFirm());
				addUserPositionTextField.setText(employee.getPosition());
			    addUserDateTextField.setText(employee.getDateOfEmployement());
			}
			
			private void initializeUpdateCoursePanel(Course course) {
				layeredPane.setVisible(true);
				switchPanels(addCoursePanel);
				addCourseNameTxt.setText(course.getName());
            	addCourseHourTxt.setText(Integer.toString(course.getNumberOfHours()));
            	addCourseDiplomaTxt.setText(course.getGraduationDiploma());
            	addCourseValueTxt.setText(Integer.toString(course.getValue()));
            	addCourseUserId.setText(Integer.toString(course.getEmployeeId()));
				
			}
		});

		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tableWithTabInformation.getSelectedRow();

				if(checkValidEntry(selectedRow)) {
					DocumentManager.getInstance().setSelectedItemIndex(selectedRow);
					removeConfirmationPanel.setVisible(true);
					tableWithTabInformation.setEnabled(false);
				}
			}
		});

		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DocumentManager.getInstance().setSavingMode("add");
				if (DocumentManager.getInstance().getPageType() == PageType.EMPLOYEE_PAGE) {
					initializeAddNewEmployeePanel();
					searchSelectedCourse.setVisible(false);
					btnNewButton.setVisible(false);
				} else {
					initializeAddNewCoursePanel();
				}

			}

			private void initializeAddNewEmployeePanel() {
				layeredPane.setVisible(true);
				switchPanels(addUserPanel);
				addUserNameTextField.setText("");
				addUserFirmTextField.setText("");
				addUserPositionTextField.setText("");
			    addUserDateTextField.setText("");
			}

			private void initializeAddNewCoursePanel() {
				layeredPane.setVisible(true);
				switchPanels(addCoursePanel);
				addCourseNameTxt.setText("");
            	addCourseHourTxt.setText("");
            	addCourseDiplomaTxt.setText("");
            	addCourseValueTxt.setText("");
            	addCourseUserId.setText("");
			}
		});
	}

	private boolean checkValidEntry(int number) {
		if(number == -1) {
			errorLabel.setVisible(true);
			return false;
		} else {
			DocumentManager.getInstance().setSelectedItemIndex(number);
			errorLabel.setVisible(false);
			return true;
		}
	}

	private void searchBarAction() {
		searchBar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				searchBar.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				//searchBar.setText("Write here...");
			}
		});
	}

	private void addUserActions() {
		addUserClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.setVisible(false);
			}
		});

		addUserSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameString = addUserNameTextField.getText();
				String firmString = addUserFirmTextField.getText();
				String positionString = addUserPositionTextField.getText();
				String dateString = addUserDateTextField.getText();
				
				Date date = DocumentManager.getInstance().convertToDate(dateString);
				
				if (nameString != "" && firmString != "" && positionString != "" && date != null) {
					if(DocumentManager.getInstance().getSavingMode().equals("add")) {
						EmployeeDAO.insert(nameString, firmString, positionString, date);
					} else {
						int id = DocumentManager.getInstance().getCurrentSelectedEmployeeId();
						EmployeeDAO.update(id, nameString, firmString, positionString, date);
					}
					addUserNameTextField.setText("");
					addUserFirmTextField.setText("");
					addUserPositionTextField.setText("");
				    addUserDateTextField.setText("");
					initializeEmployeesTable();
				}
			}
		});
	}
	
	private void addSearchSelectedCourseAction() {
		searchSelectedCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = selectCourseTable.getSelectedRow();
				if(checkValid(selectedRow)) {
					DocumentManager.getInstance().setSelectedCourseFilter(selectedRow);
					DocumentManager.getInstance().setSearchFilter("Course Filter");
					DocumentManager.getInstance().setSelectedFilterIndex(EmployeeFilters.COURSE.ordinal());
					initializeEmployeesTable();
				}
			}
			
			public boolean checkValid(int number) {
				if(number == -1) {
					return false;
				} else {
					return true;
				}
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.setVisible(false);
				searchSelectedCourse.setVisible(false);
				btnNewButton.setVisible(false);
			}
		});

	}

	private void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	private void switchScrollPanels(JScrollPane panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
}
