package mainhtmlfrontendpackage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elearningproject.dao.Contactdao;
import elearningproject.daoimpl.ContactDAOImpl;
import elearningproject.module.Contact;




@WebServlet("/contact")
public class ContactController extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out= resp.getWriter();
		long user_id = Long.parseLong(req.getParameter("user_id"));
		String name= req.getParameter("name");
	
		String email= req.getParameter("email");
		Double phone_no = Double.parseDouble(req.getParameter("phone"));
		String message= req.getParameter("message");
		Long contact_id=Long.parseLong(req.getParameter("contact_id"));
		String password=req.getParameter("password");
		String upload_photo=req.getParameter("upload_photo");
		Contact contact=new Contact(user_id,name,email,phone_no,message,contact_id);
		Contactdao dao=new ContactDAOImpl();
		boolean check=dao.addContact(contact);
		if(check) {
			out.println("Contact Added Successfully!");
		}
}
}
