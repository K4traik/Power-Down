package service;

import dao.SessionProgressionDao;
import daoimpl.SessionProgressionDaoImpl;
import exceptions.*;
import gui.ProblemWindow;
import javafx.stage.Stage;
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
				try {
					new ProblemWindow("Error", ex.getMessage()).start(new Stage());
				} catch (Exception e) {
					e.printStackTrace();
				}
				saveSession(1, 1);
			}catch(InvalidLevelException ex1) {
				try {
					new ProblemWindow("Error", ex1.getMessage()).start(new Stage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return new SessionProgression(1, 1);
		}catch(InactiveSessionException ex) {
			try{
				saveSession(1, 1);
			}catch(InvalidLevelException ex1) {
				try {
					new ProblemWindow("Error", ex1.getMessage()).start(new Stage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return new SessionProgression(1, 1);
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
	public void turnOffSession(int id){
		try {
			SessionProgression s = getSession(id);
			sessionProgressionDao.delete(s.getId());
		}catch(IdOutOfBoundsException ex) {
			try {
				new ProblemWindow("Error", ex.getMessage()).start(new Stage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}catch(SessionNotFoundException ex) {
			try {
				try {
					new ProblemWindow("Error", ex.getMessage()).start(new Stage());
				} catch (Exception e) {
					e.printStackTrace();
				}
				saveSession(id, 1);
			}catch(InvalidLevelException ex2) {
				ex2.printStackTrace();
			}
		}catch(InactiveSessionException ex) {
			try {
				new ProblemWindow("Error", ex.getMessage()).start(new Stage());
			} catch (Exception e) {
				e.printStackTrace();
			}
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
			try {
				new ProblemWindow("Error", ex.getMessage()).start(new Stage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}catch(SessionNotFoundException ex) {
			sessionProgressionDao.create(new SessionProgression(id, currentLevel));
		}catch(InactiveSessionException ex) {
			try {
				new ProblemWindow("Aviso", ex.getMessage() + " Actualizandola al nivel 1.").start(new Stage());
			} catch (Exception e) {
				e.printStackTrace();
			}
			sessionProgressionDao.update(new SessionProgression(id, currentLevel));
		}
	}
}
