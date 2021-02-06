package com.tl.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.tl.bean.FactoryBean;



public class FactoryDAOimpl implements FactoryDAO {
	private List<FactoryBean> factoryArr = new ArrayList<FactoryBean>();
	private String[] FacColumn;

	public void csvIn() {
		try {
			URL url = new URL("https://taiwanplace21.org.tw/Download_File.php?fileName=190902112139_M5.csv");
			URLConnection urlcn = url.openConnection();	
//			File file = new File("D:\\JavaClass\\factory.csv");
//			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(urlcn.getInputStream(),"Big5");
			BufferedReader br = new BufferedReader(isr);
			String str;
			String[] body;
			str=br.readLine();
			FacColumn=str.split(",");
			
			while((str = br.readLine())!=null) {
				str=str.trim();
				body=str.split(",");
				if (body.length>0) {
					FactoryBean fac =new FactoryBean(Integer.parseInt(body[0]),body[1],body[2],body[3],body[4],body[5],body[6]);
					factoryArr.add(fac);
				}				
			}
			
			br.close();
			isr.close();
			
			
		} catch (FileNotFoundException e) {e.printStackTrace();
		} catch (UnsupportedEncodingException e) {e.printStackTrace();
		} catch (IOException e) {e.printStackTrace();
		}
	}

	@Override
	public List<FactoryBean> getAllFactory() {
		
		try {Context context=new InitialContext();
		DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
		Connection conn=ds.getConnection();
		String qrySql ="select * FROM Factory";		
		PreparedStatement pstmt =conn.prepareStatement(qrySql);
		ResultSet rs =pstmt.executeQuery();
		while(rs.next()) {
     		FactoryBean fac =new FactoryBean(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
     		factoryArr.add(fac);
		}
		pstmt.close();
		conn.close();
			
		} catch (Exception e) {e.printStackTrace();	}
		
		return factoryArr;

	}

	@Override
	public FactoryBean getFactory(int FacID) {
		String qrySql ="select * FROM [dbo].[Factory] WHERE [序號] = ? ;";
		FactoryBean fac = null;
		try {
			Context context=new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn=ds.getConnection();
			PreparedStatement pstmt =conn.prepareStatement(qrySql);
			pstmt.setInt(1,FacID);
			boolean rsnot = pstmt.execute();
			System.out.println(rsnot);
			ResultSet rs =pstmt.getResultSet();
			rs.next();
     		fac =new FactoryBean(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
     		
     		pstmt.close();
			conn.close();
		}catch (SQLException e) {e.printStackTrace();} catch (NamingException e) {
			e.printStackTrace();
		}	
		return fac;
	}

	@Override
	public void updateFactory(FactoryBean factory) {
		String updatesql="UPDATE [dbo].[Factory] SET[地區別] = ?,[縣市] = ?,[觀光工廠名稱] =?,[地址] =?,[觀光工廠預約電話] =?,[網址] =? WHERE [序號]=?";
		try {
			Context context=new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn=ds.getConnection();
			PreparedStatement pstmt =conn.prepareStatement(updatesql);

			pstmt.setString(1, factory.getFacLocation());
			pstmt.setString(2, factory.getFacCountry());
			pstmt.setString(3, factory.getFacName());
			pstmt.setString(4, factory.getFacAddress());
			pstmt.setString(5, factory.getFacPhone());
			pstmt.setString(6, factory.getFacUrl());
			pstmt.setInt(7,factory.getFacID());
			pstmt.executeUpdate();
			System.out.println("更新資料成功");
			pstmt.close();
			conn.close();
		}catch (SQLException e) {e.printStackTrace();} catch (NamingException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void addFactory(FactoryBean factory) {
		String updatesql="INSERT INTO [dbo].[Factory] ([序號],[地區別],[縣市],[觀光工廠名稱],[地址],[觀光工廠預約電話],[網址]) VALUES(?,?,?,?,?,?,?)";
		try {
			Context context=new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn=ds.getConnection();
			PreparedStatement pstmt =conn.prepareStatement(updatesql);
			pstmt.setInt(1,factory.getFacID());
			pstmt.setString(2, factory.getFacLocation());
			pstmt.setString(3, factory.getFacCountry());
			pstmt.setString(4, factory.getFacName());
			pstmt.setString(5, factory.getFacAddress());
			pstmt.setString(6, factory.getFacPhone());
			pstmt.setString(7, factory.getFacUrl());
			int i = pstmt.executeUpdate();		
			System.out.println("新增"+i+"筆資料");
			pstmt.close();
			conn.close();
		}catch (SQLException e) {e.printStackTrace();} catch (NamingException e) {e.printStackTrace();
		}	  
	}

	
	@Override
	public void deleteFactory(int FacID) {	
		String deletesql ="DELETE FROM [dbo].[Factory] WHERE [序號]=?";
		try {
			Context context=new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn=ds.getConnection();
			PreparedStatement pstmt =conn.prepareStatement(deletesql);
			pstmt.setInt(1, FacID);
			int i = pstmt.executeUpdate();
			System.out.println("刪除"+i+"筆資料");
			pstmt.close();
			conn.close();
		}catch (SQLException e) {e.printStackTrace();} catch (NamingException e) {e.printStackTrace();}	  
		

	}
	
	public void createTable() {
		String createTable="IF OBJECT_ID('Factory', 'U') IS NOT NULL\r\n"
				+ "  DROP TABLE Factory\r\n"
				+ "  CREATE TABLE Factory("
				+ "  ["+FacColumn[0]+"] int primary key,"
				+ "  ["+FacColumn[1]+"] nvarchar(50) not null,"
				+ "  ["+FacColumn[2]+"] nvarchar(50) not null,"
				+ "  ["+FacColumn[3]+"] nvarchar(50) not null,"
				+ "  ["+FacColumn[4]+"] nvarchar(50) not null,"
				+ "  ["+FacColumn[5]+"] nvarchar(50) not null,"
				+ "  ["+FacColumn[6]+"] nvarchar(50) not null,)";
		
		
		try {
			Context context=new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn=ds.getConnection();
			PreparedStatement pstmt =conn.prepareStatement(createTable);
		pstmt.execute();
		System.out.println("成功創建table");		
		pstmt.close();
		conn.close();
		} catch (SQLException e) {e.printStackTrace();} catch (NamingException e) {e.printStackTrace();
		}
		
	}
	
	public void insertData() {
		String sqlInsert="INSERT INTO [dbo].[Factory]([序號],[地區別],[縣市],[觀光工廠名稱],[地址],[觀光工廠預約電話],[網址])\r\n"
				+ "     VALUES(?,?,?,?,?,?,?)";
		try {
			Context context=new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn=ds.getConnection();
			PreparedStatement pstmt =conn.prepareStatement(sqlInsert);

			for(FactoryBean fac:factoryArr) {
				pstmt.setInt(1,fac.getFacID());
				pstmt.setString(2, fac.getFacLocation());
				pstmt.setString(3,fac.getFacCountry());
				pstmt.setString(4,fac.getFacName());
				pstmt.setString(5,fac.getFacAddress());
				pstmt.setString(6,fac.getFacPhone());
				pstmt.setString(7,fac.getFacUrl());
				pstmt.execute();
				
			}		
			System.out.println("inport成功");
			pstmt.close();
			conn.close();
	}catch (SQLException e) {e.printStackTrace();} catch (NamingException e) {e.printStackTrace();}
	
	}	
	
	public String[] getColumn() {
		String[] column = new String[7];
		try {
			Context context=new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn=ds.getConnection();
			String sqlAll="select * from Factory";
			PreparedStatement pstmt = conn.prepareStatement(sqlAll);
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd =rs.getMetaData();
			
			for(int i = 1;i<=7;i++) {
				column[i-1]=rsmd.getColumnName(i);
			}
			pstmt.close();
			conn.close();
	
			
		}catch (SQLException e) {e.printStackTrace();} catch (NamingException e) {e.printStackTrace();}
		return column;
	}
	
	public void exportAll() {
		String sqlAll="select * from Factory";
		try {
			Context context=new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn=ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sqlAll);
			ResultSet rs = pstmt.executeQuery();
			String sqldata = "";
			while (rs.next()) {
				sqldata +=rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","
						 +rs.getString(5)+","+rs.getString(6)+","+rs.getString(7)+",";
			}
			String[] sqloutput;
			sqloutput=sqldata.split(",");
			exportCSV(sqloutput);	
			pstmt.close();
			conn.close();
			
			
		}catch (SQLException e) {e.printStackTrace();} catch (NamingException e) {e.printStackTrace();}
	}
	//把從sql抓下來的資料印出來,用在exportAll,city select 和name select等從DB用sql語法抓下來後用
		public void exportCSV(String[] sqloutput){
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter("D://file_output.csv"));
				String[] col=getColumn();
				bw.write(col[0]+","+col[1]+","+col[2]+","+col[3]+","+col[4]+","+col[5]+","+col[6]);
				for (int i = 0; i< sqloutput.length;i+=7) {		
					bw.newLine();//新起一行
					bw.write(sqloutput[i] +","+sqloutput[i+1] +","+ sqloutput[i+2]+","+sqloutput[i+3]+","
							+sqloutput[i+4]+","+sqloutput[i+5]+","+sqloutput[i+6]);//寫到新檔案中
					
				}
				bw.close();			
				System.out.println("已輸出檔案至D://file_output.csv");
			} catch (IOException e) {e.printStackTrace();}	
		}
	
		public List<FactoryBean> citySelect(String city) {
			List<FactoryBean> cityArr = new ArrayList<FactoryBean>();
			String createProc="SELECT * FROM [Tai].[dbo].[Factory] where [縣市] like '%'+?+'%'";
			try {
				Context context=new InitialContext();
				DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
				Connection conn=ds.getConnection();
				
				PreparedStatement pstmt = conn.prepareStatement(createProc);
				pstmt.setString(1,city);	
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
		     		FactoryBean fac =new FactoryBean(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
		     		cityArr.add(fac);
				}
				pstmt.close();
				conn.close();				

			}catch (SQLException e) {e.printStackTrace();} catch (NamingException e) {e.printStackTrace();
			}
			return cityArr;
		}
		

}
