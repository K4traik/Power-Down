package dao;

public interface SessionProgressionDao {
	void guardar(SessionProgression s);
    SessionProgression buscarPorId(int id);
    SessionProgression[] obtenerTodos();
    void actualizar(SessionProgression s);
    void eliminar(SessionProgression s);
}