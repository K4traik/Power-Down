package service;

import dao.SessionProgressionDao;
import daoimpl.SessionProgressionDaoImpl;

public class SessionProgressionService {
	private SessionProgressionDao sessionProgressionDao;
	
	public SessionProgressionService() {
		this.sessionProgressionDao = new SessionProgressionDaoImpl();
	}
	
	public void initializeSaves() {
		
	}
}
