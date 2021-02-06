package com.tl.servers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tl.bean.FactoryBean;
import com.tl.dao.FactoryDAOimpl;


@WebServlet("/GetUpdateFactory")
public class GetUpdateFactory extends HttpServlet {
	private static final long serialVersionUID = 1L;   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int facID=Integer.parseInt(request.getParameter("facID"));
		request.setCharacterEncoding("UTF-8");
		FactoryDAOimpl facimp=new FactoryDAOimpl();
		FactoryBean fac=facimp.getFactory(facID);
		request.setAttribute("fac",fac);
		request.getRequestDispatcher("/html/updateFactory.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
