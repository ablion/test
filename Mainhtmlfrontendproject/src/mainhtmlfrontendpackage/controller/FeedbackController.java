package mainhtmlfrontendpackage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elearningproject.dao.feedbackdao;
import elearningproject.daoimpl.feedbackdaoimpl;
import elearningproject.module.feedback;


@WebServlet("/feedback")
public class FeedbackController extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out= resp.getWriter();
		long user_id = Long.parseLong(req.getParameter("user_id"));
		String name= req.getParameter("name");
		
		String email= req.getParameter("email");
		Long f_id= Long.parseLong(req.getParameter("f_id"));
		String userfeedback=req.getParameter("userfeedback");
		
		feedback feedback=new feedback(user_id,name,email,f_id,userfeedback);
		feedbackdao dao=new feedbackdaoimpl();
		boolean check=dao.addfeedback(feedback);
		if(check) {
			out.println("Feedback Added Successfully!");
		}
		
	}
}
