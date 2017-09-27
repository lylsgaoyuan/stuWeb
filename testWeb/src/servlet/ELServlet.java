package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import unity.Student;

public class ELServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		ServletContext application=request.getSession().getServletContext();
		HttpSession session=request.getSession();
//		application.setAttribute("name", "Ð¡Ã÷");
//		session.setAttribute("sex", "ÄÐ");
//		request.setAttribute("age", 20);
		Student stu=new Student();
		stu.setName("ÍõÂ½");
		stu.setSex("ÄÐ");
		stu.setAge(20);
		application.setAttribute("stu", stu);
		try {
			request.getRequestDispatcher("testEL.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}
}
