package mainhtmlfrontendpackage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elearningproject.dao.admindao;
import elearningproject.daoimpl.admindaoimpl;
import elearningproject.module.admin;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out= resp.getWriter();
		long admin_id = Long.parseLong(req.getParameter("id"));
		String name= req.getParameter("name");
		
		String email= req.getParameter("email");
	
		
		String password=req.getParameter("password");
		
		admin admin=new admin(admin_id,name,email,password);
		admindao dao=new admindaoimpl();
		boolean check=dao.addadmin(admin);
		if(check) {
			out.println("Admin Added Successfully!");
		}
		
	}
}

