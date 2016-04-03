package com.huodui.find;

import java.util.Scanner;

/**
 * 成绩管理系统
 * 
 * 提供成绩录入、成绩列表、成绩查询、成绩统计功能
 */
public class GradeManagementSystem {
	private final String[] names={"Eric","Samuel","Edgar","Randy","Kenneth","Andy","Mike","Steven","Adam","Ken"};
	private final int[] score=new int[names.length];
	
	private boolean isRecord = false;//是否已录入成绩
	
	private Scanner scanner;
	
	public void start(){
		scanner= new Scanner(System.in);
		System.out.println("*********欢迎进入成绩管理系统*********");
		do{
			System.out.print("请选择功能：1——成绩录入，2——成绩列表，3——成绩查询，4——成绩统计,5——退出");
			String str=scanner.nextLine().trim();
			System.out.println("kkk"+str+"kkk");
			if("1".equals(str)){
				recordScore();
			}else if("2".equals(str)){
				average();
			}else if("3".equals(str)){
				findScore();
			} else if("4".equals(str)){
				total();
			} else if("5".equals(str)){
				System.out.println("**********谢谢使用**********");
				break;
			}
			//scanner.nextLine();
		}while(true);
		scanner.close();
	}
	
	/**
	 * 成绩列表
	 */
	private void recordScore(){
		System.out.println("开始录入成绩：");
		for(int i=0;i<names.length;i++){
			System.out.print((i+1)+". 学生姓名："+names[i]+", 成绩:?");
			score[i]=scanner.nextInt();
		}
		System.out.println("录入完毕。");
		scanner.nextLine();
		isRecord=true;
	}
	
	private boolean isRecord(){
		if(!isRecord){
			System.out.println("请先录入学生成绩!");
			return false;
		}
		return true;
	}
	
	/**
	 * 计算平均成绩
	 */
	private void average(){
		if(!isRecord()){
			return;
		}
		
		int sum=0;
		System.out.println("编号"+"\t\t"+"姓名"+"\t\t"+"成绩");
		for(int i=0;i<names.length;i++){
			System.out.println((i+1)+"\t\t"+names[i]+"\t\t"+score[i]);
			sum+=score[i];
		}
		System.out.println("平均成绩："+sum/names.length);
	}
	
	/**
	 * 成绩查询
	 */
	private void findScore(){
		if(!isRecord()){
			return;
		}
		
		System.out.print("请输入您要查询的学生姓名：");
		String student=scanner.nextLine().trim();
		for(int i=0;i<names.length;i++){
			if(student.equalsIgnoreCase(names[i])){
				System.out.println((i+1)+". 学生姓名："+names[i]+", 成绩:"+score[i]);
				return;
			}
		}
		System.out.println("找不到学生信息");
	}
	
	/**
	 * 成绩统计
	 */
	private void total(){
		if(!isRecord()){
			return;
		}
		
		int fullscore=0;//满分人数
		int excellent=0;//优秀人数
		int well=0;//良好人数
		int pass=0;//及格人数
		int flunk=0;//不及格人数
		for(int i=0;i<score.length;i++){			
			if(score[i]<=60)
				flunk++;
			else if(score[i]<=79)
				pass++;
			else if(score[i]<=89)
				well++;
			else if(score[i]<=99)
				excellent++;
			else 
				fullscore++;
		}
		System.out.println("满分(100):"+fullscore);
		System.out.println("优秀(99-90):"+excellent);
		System.out.println("良好(89-80):"+well);
		System.out.println("及格(79-60):"+pass);
		System.out.println("不及格(59-0):"+flunk);
	}
	
	public static void main(String[] args){	
		GradeManagementSystem gms = new GradeManagementSystem();
		gms.start();
	}
}