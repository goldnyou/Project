package mvc.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import mvc.controller.CommandHandler;
import mvc.model.Project;
import mvc.sevice.ProjectService;

public class ProjectReadHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		String no = req.getParameter("serialNo");
		int serialNo = Integer.parseInt(no);
		
/*		System.out.println("ProjectReadHandler serialNo-"+serialNo);*/
		
		ProjectService service = ProjectService.getInstance();
		
		Project project=service.selectBySerialNo(serialNo);

		
		req.setAttribute("project", project);

		return "/WEB-INF/view/read.jsp";
	}

}










