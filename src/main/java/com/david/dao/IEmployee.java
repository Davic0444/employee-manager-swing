package com.david.dao;

import com.david.model.Employee;

import java.sql.ResultSet;
import java.util.List;

public interface IEmployee {

    List<Employee> getAll();

    Employee getById(int id);

    Employee getObjectFromRs(ResultSet rs);

    void save(Employee employee);

    void update(Employee employee);

    void delete(Employee employee);
}
