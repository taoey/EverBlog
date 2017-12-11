package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//解决表单提交乱码造成的表单错误问题
		response.setContentType("text/html;charset=utf-8");
		
		String name=request.getParameter("name");
		String password=request.getParameter("pwd");
		 
		
		if(AdminDao.valiNamepsw(name,password)) {
			request.getSession().setAttribute("error","False");
			request.getRequestDispatcher("/WEB-INF/adminPage/dashBoard.jsp").forward(request,response); 
			//response.sendRedirect(request.getContextPath()+"/WEB-INF/adminPage/admin.jsp");
			return;//写重定向代码时的习惯，即写完重定向就写return，防止重定向之后的代码仍然执行
		}
		else {
			request.getSession().setAttribute("error","True");
			response.sendRedirect(request.getContextPath()+"/admin.jsp");
			return;
		}		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
