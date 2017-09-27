package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unity.Student;
import dao.StudentDao;

public class StudentServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			int nums = 2;// 一页多少条
			StudentDao std = new StudentDao();
			int total = std.searcCount();
			int maxYe = 0;
			// if (total % nums == 0) {
			// maxYe = total / nums;
			// } else {
			// maxYe = total / nums + 1;
			// }
			maxYe = total % nums == 0 ? total / nums : total / nums + 1;

			int ye = 1;
			if (request.getParameter("ye") != null) {
				ye = Integer.parseInt(request.getParameter("ye"));
			}
			if (ye < 1) {
				ye = 1;
			}
			if (ye > maxYe) {
				ye = maxYe;
			}
			int begin = 2 * (ye - 1);

			List<Student> list = std.searcByBegin(begin, nums);
			request.setAttribute("list", list);
			request.setAttribute("ye", ye);
			request.setAttribute("maxYe", maxYe);
			request.getRequestDispatcher("WEB-INF/student2.jsp").forward(
					request, response);
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
