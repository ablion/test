package mainhtmlfrontendpackage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elearningproject.dao.userdao;
import elearningproject.daoimpl.UserDAOImpl;
import elearningproject.module.user1;



@WebServlet("/register")
public class RegisterController extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out= resp.getWriter();
		long user_id = Long.parseLong(req.getParameter("id"));
		String name= req.getParameter("name");
		Double phone_no = Double.parseDouble(req.getParameter("phone"));
		String email= req.getParameter("email");
		String address= req.getParameter("address");
		String reg_date=req.getParameter("reg_date");
		String password=req.getParameter("password");
		String upload_photo=req.getParameter("upload_photo");
		user1 user=new user1(user_id,name,phone_no,email,address,reg_date,password,upload_photo);
		userdao dao=new UserDAOImpl();
		boolean check=dao.addUser(user);
		if(check) {
			out.println("User Added Successfully!");
		}
		
	}
}
