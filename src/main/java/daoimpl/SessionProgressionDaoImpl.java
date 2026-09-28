package daoimpl;

import model.SessionProgression;

public class SessionProgressionDaoImpl extends SessionProgression {
	
	private SessionProgression[] progresslist = new SessionProgression[10];
    private int cantidad = 0;

    @Override
    public void save (SessionProgression s) {
        if (cantidad < progresslist.length) {
        	progresslist[cantidad] = s;
            cantidad++;
        }
    }

    @Override
    public SessionProgression[] getall() {
        return progresslist;
    }

    @Override
    public void racharge(SessionProgression s) {
        for (int i = 0; i < cantidad; i++) {
            if (progresslist[i] != null && progresslist[i].id == s.id) {
                progresslist[i] = s;
                break;
            }
        }
    }

    @Override
    public void delete (SessionProgression s) {
        for (int i = 0; i < cantidad; i++) {
            if (progresslist != null && progresslist[i].id == s.id) {
            	progresslist[i] = null;
                break;
            }
        }
    }
}
