package com.tl.servers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tl.bean.FactoryBean;
import com.tl.dao.FactoryDAOimpl;
@WebServlet("/AddFactory")
public class AddFactory extends HttpServlet {
	private static final long serialVersionUID = 1L;
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		int facID=Integer.parseInt(request.getParameter("facID"));
		String facLocation=request.getParameter("facLocation");
		String facCountry=request.getParameter("facCountry");
		String facName=request.getParameter("facName");
		String facAddress=request.getParameter("facAddress");
		String facPhone=request.getParameter("facPhone");
		String facUrl=request.getParameter("facID");
		
		FactoryBean fac = new FactoryBean(facID,facLocation,facCountry,facName,facAddress,facPhone,facUrl);
		FactoryDAOimpl facimp=new FactoryDAOimpl();
		facimp.addFactory(fac);
		request.getRequestDispatcher("ShowFactory").forward(request, response);
  		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
