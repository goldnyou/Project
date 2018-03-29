package mvc.model;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import mvc.util.MySqlSessionFactory;

public class ProjectDaoTest {

	//@Test
	public void testInsert(){
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();			
			ProjectDao dao = session.getMapper(ProjectDao.class);
			
			Project project = new Project(0,"aaa","aaa_content",new Date() ,new Date(),"준비");
			dao.insert(project);
			
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MySqlSessionFactory.closeSession(session);
		}				
	}
	
	//@Test
	public void testListAll(){
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();			
			ProjectDao dao = session.getMapper(ProjectDao.class);
			
			List<Project> list = dao.listAll();
			if(list.size() > 0){
				for(Project project : list){
					System.out.println(project);
				}
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MySqlSessionFactory.closeSession(session);
		}
	}
	
	//@Test
	public void testselectBySerialNo(){
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();			
			ProjectDao dao = session.getMapper(ProjectDao.class);
			
			Project list = dao.selectBySerialNo(1);	
					System.out.println(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MySqlSessionFactory.closeSession(session);
		}
	}
		
	//@Test
	public void testUpdate(){
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();			
			ProjectDao dao = session.getMapper(ProjectDao.class);
			
			Project project = new Project(5,"eee","aaa_content",new Date() ,new Date(),"준비");
			dao.update(project);
			
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MySqlSessionFactory.closeSession(session);
		}				
	}
	
	@Test
	public void testDelete(){
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();			
			ProjectDao dao = session.getMapper(ProjectDao.class);
			
			dao.delete(1);
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MySqlSessionFactory.closeSession(session);
		}
	}
}