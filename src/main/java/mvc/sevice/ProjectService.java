package mvc.sevice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mvc.model.Project;
import mvc.model.ProjectDao;
import mvc.util.MySqlSessionFactory;

public class ProjectService {
	private static final ProjectService instance = new ProjectService();
	
	public static ProjectService getInstance(){
		return instance;
	}
	
	private ProjectService() {}
	
	
	// -2 : duplicatedId
	public int insertProject(Project project){
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			ProjectDao dao = session.getMapper(ProjectDao.class);			
			
			//id 중복 체크
			Project existProject = dao.selectBySerialNo(project.getSerialNo());
			if(existProject != null){
				return -2;
			}
			
			dao.insert(project);
			session.commit();
			return 0;// 정상 insert
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			MySqlSessionFactory.closeSession(session);
		}
		
		return -1;		
	}

	public List<Project> listAll() {
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			ProjectDao dao = session.getMapper(ProjectDao.class);
			
			return dao.listAll();		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MySqlSessionFactory.closeSession(session);
		}
		return null;
	}
	
	public Project selectBySerialNo(int serialNo){
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			ProjectDao dao = session.getMapper(ProjectDao.class);			
			
			return dao.selectBySerialNo(serialNo);
			 // 정상 처리;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			MySqlSessionFactory.closeSession(session);
		}
		
		return null;		
	}
	
	public int update(Project project){
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			ProjectDao dao = session.getMapper(ProjectDao.class);					
			dao.update(project);
			session.commit();
			return 0;// 정상update
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			MySqlSessionFactory.closeSession(session);
		}		
		return -1;		
	}
	
	public int delete(int serialNo){
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			ProjectDao dao = session.getMapper(ProjectDao.class);			
			
			dao.delete(serialNo);
			session.commit();
			return 0;// 정상  delete
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			MySqlSessionFactory.closeSession(session);
		}
		
		return -1;		
	}
	

	
}













