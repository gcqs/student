package biz.zc.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.zc.dao.studentDao;
import biz.zc.pojo.Student;

/**
 * Servlet implementation class alterServlet
 */
public class alterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public alterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");;
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		String description = request.getParameter("description");
		String avg = request.getParameter("avg");
	    String id = request.getParameter("id");
	    
	    Student student = new Student();
	    student.setId(id);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = sdf.parse(birthday);
			student.setBirthday(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		student.setAvg(Integer.parseInt(avg));
		student.setDescription(description);
		student.setName(name);
	    
	    studentDao alter = new studentDao();
	    alter.alterDao(student);

		response.sendRedirect("findServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
