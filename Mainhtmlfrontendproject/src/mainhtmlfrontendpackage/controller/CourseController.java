package mainhtmlfrontendpackage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elearningproject.dao.coursedao;
import elearningproject.daoimpl.coursedaoimpl;
import elearningproject.module.course;


@WebServlet("/course")
public class CourseController extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out= resp.getWriter();
		long course_id = Long.parseLong(req.getParameter("course_id"));
		String c_name= req.getParameter("c_name");
		
		String c_desp= req.getParameter("c_desp");
		String c_fees= req.getParameter("c_fees");
		String c_resource=req.getParameter("c_resource");
		
		course course=new course(course_id,c_name,c_desp,c_fees,c_resource);
		coursedao dao=new coursedaoimpl();
		boolean check=dao.addcourse(course);
		if(check) {
			out.println("Course Added Successfully!");
		}
		
	}
}
