package daoimpl;

import dao.SessionProgressionDao;
import model.SessionProgression;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SessionProgressionDaoImpl implements SessionProgressionDao{
	private final String url = "jdbc:mysql://localhost:3306/Power_Down?useSSL=false&serverTimezone=UTC";
	private final String user = "root";
	private final String pw = "usbw";
	
	public Connection  connect() throws SQLException {
		return DriverManager.getConnection(url, user, pw);
	}
	
	@Override
	public void create(SessionProgression s) {
		String query = "INSERT INTO Sessions_Progressions(currentLevel) VALUES (?)";
		try (PreparedStatement ps = connect().prepareStatement(query)){
			ps.setInt(1, s.getCurrentLevel());
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Affected: " + rowsAffected);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	@Override
	public SessionProgression read(int id) {
		String query = "SELECT currentLevel FROM Sessions_Progressions WHERE id = ?";
		try (PreparedStatement ps = connect().prepareStatement(query)){
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()){
				return new SessionProgression(id, rs.getInt("currentLevel"));
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	@Override
	public void update(SessionProgression s) {
		String query = "UPDATE Sessions_Progressions SET currentLevel = ? WHERE id = ?";
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
