package mvc.handler;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.controller.CommandHandler;
import mvc.model.Project;
import mvc.sevice.ProjectService;

public class ProjectUpdateHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/update.jsp";
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
/*		System.out.println("UPDATE 진입");*/		
		ProjectService service = ProjectService.getInstance();
		String no = req.getParameter("serialNo");
		int serialNo = Integer.parseInt(no);
		
		if(req.getMethod().equalsIgnoreCase("get")){			
			Project project=service.selectBySerialNo(serialNo);			
			req.setAttribute("project", project);
			return FORM_VIEW;
		}else if(req.getMethod().equalsIgnoreCase("post")){					
			String projectName = req.getParameter("projectName");
			String projectContent = req.getParameter("projectContent");
			String sDate = req.getParameter("startDate");
			String eDate = req.getParameter("endDate");
			String processStatus = req.getParameter("processStatus");
			
			Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(sDate);
			Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(eDate);			
			
			Project project= new Project(serialNo, projectName, projectContent, startDate, endDate, processStatus);
			
			int result = service.update(project);			
			if(result < 0){
				req.setAttribute("error", "프로젝트 update에 실패하였습니다.");
				return FORM_VIEW;		
			}
			res.sendRedirect("read.do?serialNo="+serialNo);
			return null;
		}
		return null;
	}
}
	












