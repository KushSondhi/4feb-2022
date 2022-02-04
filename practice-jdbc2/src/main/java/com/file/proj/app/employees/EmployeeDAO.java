package com.file.proj.app.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.file.proj.app.db.AppDB;

public class EmployeeDAO {

	public Employee findEmployee(int empId) {

		Employee employee = null;
		String sql = "SELECT * FROM employee WHERE emp_id=" + empId;

		try {
			Connection connection = AppDB.getConnection();
			Statement stmnt = connection.createStatement();

			ResultSet rs = stmnt.executeQuery(sql);

			if (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String doj = rs.getString(3);
				double salary = rs.getDouble(4);

				employee = new Employee(id, name, doj,salary);
			}

		} catch (Exception ex) {

		}

		return employee;
	}

	public List<Employee> allEmployees() {

		List<Employee> employeeList = new ArrayList<>();
		String sql = "SELECT * FROM employee";

		try {
			Connection connection = AppDB.getConnection();
			Statement stmnt = connection.createStatement();

			ResultSet rs = stmnt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String doj = rs.getString(3);
				double salary = rs.getDouble(4);

				Employee employee = new Employee(id, name, doj,salary);
				employeeList.add(employee);
			}

		} catch (Exception ex) {

		}

		return employeeList;
	}

	public boolean deleteEmployee(int empId) {

		boolean result = false;
		String sql = "DELETE FROM employee WHERE emp_id=" + empId;

		try {
			Connection connection = AppDB.getConnection();
			Statement stmnt = connection.createStatement();

			int count = stmnt.executeUpdate(sql); // dml queries only.
			result = count > 0;
		} catch (Exception ex) {

		}

		return result;

	}

	public boolean addEmployee(Employee emp) {

		boolean res = false;

		// Prepare statement-
		String sql = "INSERT INTO employee VALUES(?,?,?,?)";

		Connection connection = AppDB.getConnection();

		try {

			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, emp.getEmpId());
			ps.setString(2, emp.getEmpName());
			ps.setString(3, emp.getEmpDoj());
			ps.setDouble(4, emp.getEmpSalary());

			int count = ps.executeUpdate();

			res = count > 0;
			ps.clearParameters();

		} catch (Exception ex) {

		}

		return res;
	}

}
