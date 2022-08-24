package com.david.dao;

import com.david.model.EmployeeCategory;
import com.david.utils.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCategoryDao implements IEmployeeCategory{

    private Connection connection = new Database().createConnection();
    private ResultSet rs = null;
    private PreparedStatement pstmt = null;

    @Override
    public List<EmployeeCategory> getAll() {
        List<EmployeeCategory> employeeCategories = new ArrayList<EmployeeCategory>();
        String sql = "SELECT * FROM employee_category WHERE deleted = 0;";
        try {
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                employeeCategories.add(getObjectFromRs(rs));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return employeeCategories;
    }

    @Override
    public EmployeeCategory getById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EmployeeCategory getObjectFromRs(ResultSet rs) {
        EmployeeCategory empCategoryObj = null;
        try {
            empCategoryObj = new EmployeeCategory(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getBoolean("status"),
                    rs.getBoolean("deleted")
            );
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // TODO Auto-generated method stub
        return empCategoryObj;
    }

    @Override
    public List<String> getAllNames() {

        List<String> employeeNames = new ArrayList<String>();
        String sql = "SELECT name FROM employee_category WHERE deleted = 0;";
        try {
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                employeeNames.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return employeeNames;
    }

}
