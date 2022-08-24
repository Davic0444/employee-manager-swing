package com.david.dao;

import com.david.model.EmployeeCategory;

import java.sql.ResultSet;
import java.util.List;

public interface IEmployeeCategory {

    List<EmployeeCategory> getAll();
    List<String> getAllNames();
    EmployeeCategory getById(int id);
    EmployeeCategory getObjectFromRs(ResultSet rs);
}
