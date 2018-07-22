package biz.zc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.zc.dao.studentDao;
import biz.zc.pojo.Page;

/**
 * Servlet implementation class findServlet
 */
public class findServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 String spage = request.getParameter("page");
		 Page page =new Page();
		 if(spage == null || spage =="") {
			 page.setPage(1);
		 }else {
			 page.setPage(Integer.parseInt(spage));
			 
		 }
		
	    studentDao find = new studentDao();
	    Page page2 = find.findstudent(page);
	    long tote = page2.getTote();
	    Integer pages =(int) (tote/page2.getSizi());
	    List<Integer> list = new ArrayList<Integer>();
	    if(tote%page2.getSizi() != 0) {
	    	pages++;
	    	
	    }
	    if(pages<=5) {
	    	for(int i = 1; i<=pages;i++) {
	    		list.add(i);
	    		
	    	}
	    	
	    }
	    if(pages>5) {
	    	for(int i = pages-2;i<=pages+2;i++) {
	    		list.add(i);
	    		
	    	}
	    	
	    }
	    page2.setPages(list);
//	    System.out.println(page2.getStudents()+"==="+page2.getTote());
	    request.setAttribute("page", page2);
	    response.setContentType("text/html; charset=utf-8");
	    request.getRequestDispatcher("test1.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
