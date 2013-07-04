package sg.edu.nus.iss.eleave.util;

import com.google.appengine.api.datastore.Entity;

public class DataMapper {
	
	public Object buildDTO(Entity entity, Class<?> dto) {
		// TODO
		try {
			dto.newInstance();
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Entity buildEntity(Object dto) {
		return null;
	}
}
