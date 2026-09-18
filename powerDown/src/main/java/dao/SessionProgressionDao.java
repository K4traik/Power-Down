package dao;

import model.SessionProgression;

public interface SessionProgressionDao {
	public void create(SessionProgression s);
	public SessionProgression read(int id);
	public void update(SessionProgression s);
	public void delete(int id);
}