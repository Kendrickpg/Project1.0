package Models;

public class ersUsers {
	private int employeeID;
	private String employeeUser;
	private String employeePassw;
	private String employeeFname;
	private String employeeLname;
	private String employeeEmail;
	private int employeeRoleId;
	
	
	
	public ersUsers(int employeeID, String employeeUser, String employeePassw, String employeeFname,
			String employeeLname, String employeeEmail, int employeeRoleId) {
		super();
		this.employeeID = employeeID;
		this.employeeUser = employeeUser;
		this.employeePassw = employeePassw;
		this.employeeFname = employeeFname;
		this.employeeLname = employeeLname;
		this.employeeEmail = employeeEmail;
		this.employeeRoleId = employeeRoleId;
	}
	
	public ersUsers() {
		
	}
	public ersUsers(int userId) {
		this.employeeID= userId;
	}

	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeUser() {
		return employeeUser;
	}
	public void setEmployeeUser(String employeeUser) {
		this.employeeUser = employeeUser;
	}
	public String getEmployeePassw() {
		return employeePassw;
	}
	public void setEmployeePassw(String employeePassw) {
		this.employeePassw = employeePassw;
	}
	public String getEmployeeFname() {
		return employeeFname;
	}
	public void setEmployeeFname(String employeeFname) {
		this.employeeFname = employeeFname;
	}
	public String getEmployeeLname() {
		return employeeLname;
	}
	public void setEmployeeLname(String employeeLname) {
		this.employeeLname = employeeLname;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public int getEmployeeRole() {
		return employeeRoleId;
	}
	public void setEmployeeRole(int employeeRole) {
		this.employeeRoleId = employeeRole;
	}
	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", employeeUser=" + employeeUser + ", employeePassw="
				+ employeePassw + ", employeeFname=" + employeeFname + ", employeeLname=" + employeeLname
				+ ", employeeEmail=" + employeeEmail + ", employeeRole=" + employeeRoleId + "]";
	}
	
	
}
