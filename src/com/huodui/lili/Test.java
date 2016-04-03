package com.huodui.lili;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class Test {
public static void main(String[] args) {
	 try {
			Connection conn=connectionFactory.getConnection();
			Statement st=conn.createStatement();
			student stu=null;
			for(int i=0;i<studentDatas.students.size();i++)
			{
				stu=(student)studentDatas.students.get(i);

				st.executeUpdate("insert into student(stuId,name,domCard,bedNo) " +
						"values('"+stu.getStuId()+"','"+stu.getName()+"','"+stu.getDomCard()+"','"+stu.getBedNo()+"')");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();

		}
	}


}
	


class studentDatas{
	public static ArrayList<student> students=new ArrayList<student>();
	static{
	student stu=new student("会计A001121","张三","31栋908",1);	
	 students.add(stu);
	 stu=new student("会计A001166","李四","31栋908",2);	
	 students.add(stu);
	 stu=new student("会计A001177","王五","31栋807",4);	
	 students.add(stu);
	 
	}
	
}


