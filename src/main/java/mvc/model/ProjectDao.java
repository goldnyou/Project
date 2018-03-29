package mvc.model;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public interface ProjectDao {
	public void insert(Project project) throws SQLException;
	public Project selectBySerialNo(int serialNo) throws SQLException;
	public List<Project> listAll() throws SQLException;
	public void update(Project project) throws SQLException;
	public void delete(int serialNo) throws SQLException;
	}
