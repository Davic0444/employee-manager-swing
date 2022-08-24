package com.david.dao;

import com.david.model.Employee;
import com.david.utils.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao implements IEmployee {

    private Connection connection = new Database().createConnection();

    private ResultSet rs = null;

    private PreparedStatement pstmt = null;

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<Employee>();
        String sql = "SELECT * FROM employee INNER JOIN employee_category ON employee.employee_category_id = employee_category.id ORDER BY employee.id;";
        try {
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                employees.add(getObjectFromRs(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    @Override
    public Employee getById(int id) {
        Employee employee = null;
        String sql = "SELECT * FROM empoyee WHERE id = ?;";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                employee = getObjectFromRs(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }

    @Override
    public Employee getObjectFromRs(ResultSet rs) {
        Employee empObj = null;
        try {
            empObj = new Employee(
                    rs.getInt("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getDate("birth_of_date").toLocalDate(),
                    rs.getString("identity_card"),
                    rs.getInt("salary"),
                    rs.getInt("employee_category_id"),
                    rs.getBoolean("status"),
                    rs.getBoolean("deleted")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return empObj;
    }

    @Override
    public void save(Employee employee) {

        String sql = "INSERT INTO employee (first_name, last_name, birth_of_date, "
                + "identity_card, salary, employee_category_id, status) "
                + "VALUES (?,?,?,?,?,?,?);";

        try {
            pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, employee.getFirstName());
            pstmt.setString(2, employee.getLastName());
            pstmt.setString(3, employee.getBirthOfDate().toString());
            pstmt.setString(4, employee.getIdentityCard());
            pstmt.setInt(5, employee.getSalary());
            pstmt.setInt(6, employee.getEmployeeCategoryId());
            pstmt.setInt(7, employee.isStatus() ? 1 : 0);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void update(Employee employee) {
        String sql = "UPDATE employee SET "
                + "first_name = ?, last_name = ?, birth_of_date = ?, identity_card = ?, "
                + "salary = ?, employee_category_id=?, status=? WHERE id = ?;";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, employee.getFirstName());
            pstmt.setString(2, employee.getLastName());
            pstmt.setString(3, employee.getBirthOfDate().toString());
            pstmt.setString(4, employee.getIdentityCard());
            pstmt.setInt(5, employee.getSalary());
            pstmt.setInt(6, employee.getEmployeeCategoryId());
            pstmt.setInt(7, employee.isStatus() ? 1 : 0);
            pstmt.setInt(8, employee.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Employee employee) {
        String sql = "UPDATE employee SET deleted=1 WHERE id = ?;";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, employee.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
