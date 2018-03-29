package mvc.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import mvc.controller.CommandHandler;
import mvc.sevice.ProjectService;

public class ProjectDeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
/*		System.out.println("delete 진입");*/
		
		ProjectService service = ProjectService.getInstance();
		
		String no = req.getParameter("serialNo");
		int serialNo = Integer.parseInt(no);
		
		service.delete(serialNo);

		return "list.do";
	}

}
