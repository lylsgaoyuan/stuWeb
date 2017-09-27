package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import unity.User;
import dao.UserDao;

public class UserServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			String type = request.getParameter("type");
			if (type == null || type.equals("showLogin")) {
				showLogin(request, response);
			} else if (type.equals("doLogin")) {
				doLogin(request, response);
			}

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}

	public void showLogin(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String name = "";
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					if (cookies[i].getName().equals("username")) {
						name = cookies[i].getValue();
						break;
					}
				}
			}
			request.setAttribute("name", name);
			request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,
					response);

		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doLogin(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("name");
		// username = new String(username.getBytes("ISO-8859-1"), "utf-8");
		String password = request.getParameter("password");
		int time = Integer.parseInt(request.getParameter("time"));
		try {
			UserDao ud = new UserDao();
			User searchUser = new User();
			searchUser.setUsername(username);
			searchUser.setPassword(password);
			User user = ud.searchByUserNameAndPassword(searchUser);
			// System.out.println(username);
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				Cookie cookie = new Cookie("username", user.getUsername());
				if (time == 1) {
					cookie.setMaxAge(-1);
				} else if (time == 2) {
					cookie.setMaxAge(30);
				} else if (time == 3) {
					cookie.setMaxAge(60);
				}
				response.addCookie(cookie);
				// response.sendRedirect("success.jsp");//重定向

				request.getRequestDispatcher("WEB-INF/success.jsp").forward(
						request, response);// 转发

			} else {
				request.getRequestDispatcher("WEB-INF/fail.jsp").forward(
						request, response);// 重定向d
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
