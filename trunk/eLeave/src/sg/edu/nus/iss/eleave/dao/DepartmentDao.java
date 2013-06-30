package sg.edu.nus.iss.eleave.dao;

import java.util.List;

import sg.edu.nus.iss.eleave.dto.Department;
import sg.edu.nus.iss.eleave.exception.DAOException;

public interface DepartmentDao {
	public Department findCompany(String departmentId) throws DAOException;
    public List<Department> findAllDepartments() throws DAOException;
    public void insertProduct(Department department) throws DAOException;
    public void updateProduct(Department department) throws DAOException;
    public void deleteProduct(Department department) throws DAOException;
}
