package mvc.handler;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.controller.CommandHandler;
import mvc.model.Project;
import mvc.sevice.ProjectService;

public class ProjectWriterHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/writeForm.jsp";
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub		
/*		System.out.println("write 진입");*/
		if(req.getMethod().equalsIgnoreCase("get")){
			return FORM_VIEW;
		}else if(req.getMethod().equalsIgnoreCase("post")){
			String projectName = req.getParameter("projectName");
			String projectContent = req.getParameter("projectContent");
			String sDate = req.getParameter("startDate");
			String eDate = req.getParameter("endDate");
			String processStatus = req.getParameter("processStatus");
			
			Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(sDate);
			Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(eDate);
			
			ProjectService service = ProjectService.getInstance();
			
			int serialNo=0;
			Project project=new Project(serialNo, projectName, projectContent, startDate, endDate,processStatus);
			int result = service.insertProject(project);			
			if(result < 0){
				req.setAttribute("error", "프로젝트 저장에 실패하였습니다.");
				return FORM_VIEW;		
			}
			return FORM_VIEW;
		}
		return null;
	}
}
	












