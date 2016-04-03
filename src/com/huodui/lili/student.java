package com.huodui.lili;

public 
class student {
	 private int id;
	 private String stuId;
	 private String name;
	 private String domCard;//楼栋宿舍号“31-507”
	private int bedNo;//床铺号	
	public student(String stuId, String name, String domCard,int bedNo)
	{
		super();
		this.stuId = stuId;
		this.name = name;
		this.domCard = domCard;
		this.bedNo = bedNo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDomCard() {
		return domCard;
	}
	public void setDomCard(String domCard) {
		this.domCard = domCard;
	}
	public int getBedNo() {
		return bedNo;
	}
	public void setBedNo(int bedNo) {
		this.bedNo = bedNo;
	}

}
