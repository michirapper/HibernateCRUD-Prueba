package modelo;

public class Employee {

	private int empId;
	private String empName;
	private String empDescripcion;

	// Constructor
	public Employee() {

	}

	// Getters y setters

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDescripcion() {
		return empDescripcion;
	}

	public void setEmpDescripcion(String empDescripcion) {
		this.empDescripcion = empDescripcion;
	}

}
