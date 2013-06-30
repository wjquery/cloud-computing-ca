package sg.edu.nus.iss.eleave.dao;

public interface DAOFactory {

	//public abstract ProductDAO getProductDAO();
//
//	private static DAOFactory instance;
//
//	public enum DAOType {JDO, JPA, DataStore}
//	
//	private static DAOType accessConfig = DAOType.DataStore; // by default access DB
//
//	public static DAOFactory getInstance() {
//
//		instance = loadInstance(accessConfig);
//
//		return instance;
//	}
//
//	public static DAOFactory getInstance(DAOType i) {
//
//		instance = loadInstance(i);
//
//		return instance;
//	}
//
//	private static DAOFactory loadInstance(DAOType acc) {
//
//		System.out.println("*****DAOFactory : LOADING *****" + acc);
//
//		switch (acc) {
//		case JPA:
//			return new gae.dao.gaejpa.DAOFactoryImpl();
//		case JDO:
//			return new gae.dao.gaejdo.DAOFactoryImpl();
//		case DataStore:
//			return new gae.dao.gaeds.DAOFactoryImpl();
//		default:
//			return new gae.dao.gaejpa.DAOFactoryImpl();
//		}
//	}
}
