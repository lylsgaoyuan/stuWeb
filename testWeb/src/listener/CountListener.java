package listener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.sun.org.apache.regexp.internal.recompile;

import unity.Student;

public class CountListener implements HttpSessionListener,
		ServletContextListener, ServletRequestListener {

	public void sessionCreated(HttpSessionEvent se) {
		ServletContext application = se.getSession().getServletContext();
		// if (application.getAttribute("set") == null) {
		// Set<String> set = new HashSet<String>();
		// application.setAttribute("set", set);
		// }
		int num = 0;
		if (application.getAttribute("num") != null) {
			num = (Integer) application.getAttribute("num");
		}
		// String ip = request.getRemoteAddr();
		// Set<String> set=(Set<String>)application.getAttribute("set");
		// boolean flag = set.add(ip);
		// System.out.println(ip);
		// if (session.isNew()) {
		num++;
		// }

		application.setAttribute("num", num);

	}

	public void sessionDestroyed(HttpSessionEvent se) {

	}

	public void contextDestroyed(ServletContextEvent sce) {
		int num = (Integer) sce.getServletContext().getAttribute("num");
		//System.out.println("application销毁");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test?characterEncoding=utf-8",
					"root", "123456");
			Statement stat = conn.createStatement();
			int rs = stat.executeUpdate("update count set num=" + num
					+ " where id = 1");
			if (rs > 0) {
				System.out.println("保存成功");
			} else {
				System.out.println("保存失败");
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void contextInitialized(ServletContextEvent sce) {
		//System.out.println("application新建");
		int num = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test?characterEncoding=utf-8",
					"root", "123456");
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select num from count");
			if (rs.next()) {
				num = rs.getInt("num");
			}
			sce.getServletContext().setAttribute("num", num);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void requestInitialized(ServletRequestEvent sre) {
		//System.out.println("请求");

	}

	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub

	}

}
