package com.tl.servers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Context context=new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn=ds.getConnection();
			String sql = "select * from factory";
			PreparedStatement pstmt =conn.prepareStatement(sql);
			boolean a = pstmt.execute();
			System.out.println(a);
			ResultSet rs = pstmt.getResultSet();
			rs.next();
			System.out.println(rs.getString(1)+rs.getString(2));
			
			
			
		/*<Resource driverClassName="com.microsoft.sqlserver.jdbc.SQLServerDriver" url="jdbc:sqlserver://localhost:1433;databasename = Tai"
    		 name="jdbc/servdb" username="watcher" password="P@55w0rd"
    		 type="javax.sql.DataSource" auth="Container"
    		 initialSize="5" maxtotal="8" maxIdle="5" maxWaitMillis="-1"
    		 poolPreparedStatement="true" validationQuery="select 1" />
    		 
    	<ResourceLink type="javax.sql.DataSource" global="jdbc/servdb" name="jdbc/servdb"/>	
		 */
			
			
		} catch (NamingException | SQLException e) {


			e.printStackTrace();
		}
		

		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
