package com.tl.servers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tl.dao.FactoryDAOimpl;

/**
 * Servlet implementation class Starthere
 */
@WebServlet("/Starthere")
public class Starthere extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FactoryDAOimpl facimp=new FactoryDAOimpl();
		facimp.csvIn();
		facimp.createTable();
		facimp.insertData();
	
	
		request.getRequestDispatcher("ShowFactory").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
