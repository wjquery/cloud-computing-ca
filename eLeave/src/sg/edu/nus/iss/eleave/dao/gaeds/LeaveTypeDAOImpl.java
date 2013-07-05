package sg.edu.nus.iss.eleave.dao.gaeds;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import sg.edu.nus.iss.eleave.controller.EmployeeAction;
import sg.edu.nus.iss.eleave.dao.LeaveTypeDAO;
import sg.edu.nus.iss.eleave.dto.Company;
import sg.edu.nus.iss.eleave.dto.LeaveType;
import sg.edu.nus.iss.eleave.exception.DAOException;

public class LeaveTypeDAOImpl implements LeaveTypeDAO {

	private static Logger log = Logger.getLogger(LeaveTypeDAOImpl.class.getCanonicalName());
	
	@Override
	public LeaveType findLeaveTypeById(String leaveTypeId) {
		// TODO: should return the list of all leaveTypes by company first, then find by leaveTypeId in the list
		Entity entity = Util.findFirstMatch(LeaveType.KIND, "leaveTypeId", leaveTypeId);
		if (entity != null) {
			LeaveType leaveType = buildLeaveTypeDTO(entity);
			return leaveType;
		}
		return null;
	}

	@Override
	public List<LeaveType> findAllLeaveTypesByCompany(String companyId) {
		log.log(Level.INFO, "CompanyId: " + companyId);
		Key ancestorKey = KeyFactory.createKey(Company.KIND, companyId); 
		log.log(Level.INFO, "Key: " + ancestorKey.getName());
		Iterable<Entity> entities = Util.listChildren(LeaveType.KIND, ancestorKey);
		log.log(Level.INFO, "@@@@@@@@: " + entities);
		List<LeaveType> leaveTypes = new ArrayList<LeaveType>();
		for(Entity entity : entities) {
			leaveTypes.add(buildLeaveTypeDTO(entity));
			log.log(Level.INFO, "LeaveType found: " + buildLeaveTypeDTO(entity).getName());
		}
		return leaveTypes;
	}

	@Override
	public List<LeaveType> findAllLeaveTypesByCompany(String companyId,
			int offset, int fetchSize) {
		return findAllLeaveTypesByCompany(companyId).subList(offset, offset + fetchSize + 1);
	}

	@Override
	public void insertLeaveType(LeaveType leaveType) throws DAOException {
		Key companyKey = KeyFactory.createKey(Company.KIND, leaveType.getCompanyId());
		Entity e = new Entity(LeaveType.KIND, companyKey);
		log.log(Level.INFO, "###############" + companyKey.getName());
		e.setProperty("leaveTypeId", leaveType.getLeaveTypeId());
		e.setProperty("companyId", leaveType.getCompanyId());
		e.setProperty("name", leaveType.getName());
		e.setProperty("defaultEntitlememt", leaveType.getDefaultEntitlement());
		log.log(Level.INFO, "########$$$$$$$$######" + companyKey.getName());
		Util.persistEntity(e);
	}

	@Override
	public void updateLeaveType(LeaveType leaveType) throws DAOException {
		Entity e = Util.findFirstMatch(LeaveType.KIND, "leaveTypeId", leaveType.getLeaveTypeId());
		e.setProperty("name", leaveType.getName());
		e.setProperty("defaultEntitlememt", leaveType.getDefaultEntitlement());
		Util.persistEntity(e);
	}

	@Override
	public void deleteLeaveType(LeaveType leaveType) throws DAOException {
		Entity entity = Util.findFirstMatch(LeaveType.KIND, "leaveTypeId", leaveType.getLeaveTypeId());
		if(entity != null) {
			Util.deleteEntity(entity.getKey());
		}
	}
	
	private LeaveType buildLeaveTypeDTO(Entity entity) {
		LeaveType l = new LeaveType();
		l.setCompanyId((String)entity.getProperty("companyId"));
		l.setLeaveTypeId((String)entity.getProperty("leaveTypeId"));
		l.setName((String)entity.getProperty("name"));
		l.setDefaultEntitlement((Double)entity.getProperty("defaultEntitlememt"));
		return l;
	}

}
