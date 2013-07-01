package sg.edu.nus.iss.eleave.dao;

import java.util.List;

import sg.edu.nus.iss.eleave.dto.Company;
import sg.edu.nus.iss.eleave.dto.Department;
import sg.edu.nus.iss.eleave.exception.DAOException;

public interface DepartmentDao {
	public Department findDepartment(String companyId, String departmentId) throws DAOException;
	public List<Department> findAllDepartments() throws DAOException;
	public List<Department> findAllDepartmentsByCompany(Company company) throws DAOException;
    public void insertDepartment(Department department) throws DAOException;
    public void updateDepartment(Department department) throws DAOException;
    public void deleteDepartment(Department department) throws DAOException;
}
