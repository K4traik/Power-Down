package daoimpl;

import dao.SessionProgressionDao;
import model.SessionProgression;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SessionProgressionDaoImpl implements SessionProgressionDao{
	private final String url = "jdbc:mysql://localhost:3306/Power_Down?useSSL=false&serverTimezone=UTC";
	private final String user = "root";
	private final String pw = "root";
	
	public Connection  connect() throws SQLException {
		return DriverManager.getConnection(url, user, pw);
	}
	
	@Override
	public void create(SessionProgression s) {
		String query = "INSERT INTO Sessions_Progressions(id, currentLevel) VALUES (?, ?)";
		try (PreparedStatement ps = connect().prepareStatement(query)){
			ps.setInt(1, s.getId());
			ps.setInt(2, s.getCurrentLevel());
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Affected: " + rowsAffected);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	@Override
	public SessionProgression read(int id) {
		String query = "SELECT currentLevel, isActive FROM Sessions_Progressions WHERE id = ?";
		try (PreparedStatement ps = connect().prepareStatement(query)){
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					return new SessionProgression(id, rs.getInt("currentLevel"), rs.getBoolean("isActive"));
				}
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	@Override
	public ArrayList<SessionProgression> readAll(){
		String query = "SELECT * FROM Sessions_Progressions WHERE isActive = true";
		try(ResultSet rs = connect().prepareStatement(query).executeQuery()){
			ArrayList<SessionProgression> sessions = new ArrayList<SessionProgression>();
			while(rs.next()) {
				sessions.add(new SessionProgression(rs.getInt("id"), rs.getInt("currentLevel")));
			}
			return sessions;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	@Override
	public void update(SessionProgression s) {
		String query = "UPDATE Sessions_Progressions SET currentLevel = ?, isActive = true WHERE id = ?";
		try (PreparedStatement ps = connect().prepareStatement(query)){
			ps.setInt(1, s.getCurrentLevel());
			ps.setInt(2, s.getId());
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Affected: " + rowsAffected);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	@Override
	public void delete(int id) {
		String query = "UPDATE Sessions_Progressions SET isActive = false WHERE id = ?";
		try (PreparedStatement ps = connect().prepareStatement(query)){
			ps.setInt(1, id);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Affected: " + rowsAffected);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}
