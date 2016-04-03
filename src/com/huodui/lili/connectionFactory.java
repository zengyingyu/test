package com.huodui.lili;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class connectionFactory {
private static String driver;
private static String url;
private static String userName;
private static String pwd;

private static void initConnectionFactory(Properties pro) throws Exception{
	if(pro!=null){
		driver=pro.getProperty("driver");
		url=pro.getProperty("url");
		userName=pro.getProperty("userName");
		pwd=pro.getProperty("pwd");
	}
	else{
		throw new Exception("配置项对象为空");
	}
}
private static void initJVM() throws Exception{
	if(driver!=null && !"".equals(driver))
	Class.forName(driver);
	else{
		throw new Exception("驱动配置没有读出");
	}
}
public static Connection getConnection() throws SQLException{
	Connection conn=null;
	conn=DriverManager.getConnection(url,userName,pwd);
	conn.setAutoCommit(false);
	return conn;
}

static{
	InputStream is=connectionFactory.class.getResourceAsStream("db.properties");
	Properties pro=new Properties();
	try {
		pro.load(is);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		initConnectionFactory(pro);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		initJVM();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
/*public static void getConnection(Connection conn) throws SQLException{
	conn=getConnection();
	System.out.println(conn);
}*/
public static void closeAll(ResultSet rs,Statement statm,Connection conn){
	if(rs!=null)
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	if(statm!=null)
		try {
			statm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	closeConnection(conn);
}
public static void closeConnection(Connection conn){
	if(conn!=null)
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
