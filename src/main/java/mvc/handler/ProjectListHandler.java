package mvc.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import mvc.controller.CommandHandler;
import mvc.model.Project;
import mvc.sevice.ProjectService;

public class ProjectListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
/*		System.out.println("LIST 진입");*/
		// TODO Auto-generated method stub
		ProjectService service = ProjectService.getInstance();
		List<Project> list = service.listAll();
		req.setAttribute("list", list);
		return "/WEB-INF/view/list.jsp";
	}

}
