package service;

import dao.SessionProgressionDao;
import daoimpl.SessionProgressionDaoImpl;
import exceptions.*;
import model.SessionProgression;

public class SessionProgressionService {
	private SessionProgressionDao sessionProgressionDao;
	
	public SessionProgressionService() {
		this.sessionProgressionDao = new SessionProgressionDaoImpl();
	}
	
	public SessionProgression initializeSaves() {
		try {
			return getSession(1);
		}catch(IdOutOfBoundsException ex) {
			System.out.println(ex.getMessage());
			return null;
		}catch(SessionNotFoundException ex) {
			try{
				saveSession(1, 1);
			}catch(InvalidLevelException ex1) {
				System.out.println(ex.getMessage());
			}
			return new SessionProgression(1, 1);
		}catch(InactiveSessionException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
	public SessionProgression getSession(int id) throws IdOutOfBoundsException, SessionNotFoundException, InactiveSessionException{
		if(id > 3 || id<= 0) {
			throw new IdOutOfBoundsException("No existen sesiones con ID mayor a 3 ni menores o iguales a 0.");
		}
		SessionProgression s = sessionProgressionDao.read(id);
		if(s == null) {
			throw new SessionNotFoundException("No existe una sesión con el id " + id + ".");
		}
		if(!s.isActive()) {
			throw new InactiveSessionException("La sesión de id " + id + " no está activa.");
		}
		return s;
	}
	public void turnOffSession(int id) throws AlreadyInactiveException{
		try {
			SessionProgression s = getSession(id);
			if(!s.isActive()) {
				throw new AlreadyInactiveException("La sesión de id " + id + " no se puede eliminar porque ya está inactiva.");
			}
			sessionProgressionDao.delete(id);
		}catch(IdOutOfBoundsException ex) {
			System.out.println(ex.getMessage());
		}catch(SessionNotFoundException ex) {
			System.out.println(ex.getMessage());
		}catch(InactiveSessionException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void saveSession(int id, int currentLevel) throws InvalidLevelException{
		try {
			if(currentLevel<=0 || currentLevel>5) {
				throw new InvalidLevelException("No pueden existir sesiones con niveles menores o iguales a 0 ");
			}
			SessionProgression s = getSession(id);
			s.setCurrentLevel(currentLevel);
			sessionProgressionDao.update(s);
		}catch(IdOutOfBoundsException ex) {
			System.out.println(ex.getMessage());
		}catch(SessionNotFoundException ex) {
			sessionProgressionDao.create(new SessionProgression(id, currentLevel));
		}catch(InactiveSessionException ex) {
			System.out.println(ex.getMessage());
			sessionProgressionDao.update(new SessionProgression(id, currentLevel));
		}
	}
}
