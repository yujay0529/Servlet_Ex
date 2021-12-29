package sec05;

import java.util.Date;

public class BookVO {
	private String num;
	private String name;
	private String auther;
	private String price;
	private String date;
	private String pubnum;
	
	
	public BookVO() {}//디폴트 생성자


	public BookVO(String num,String name, String auther, String price, String date, String pubnum) {
		this.num = num;
		this.name = name;
		this.auther = auther;
		this.price = price;
		this.date = date;
		this.pubnum = pubnum;
	}

	//gettersetter
	public String getNum() {
		return num;
	}


	public void setNum(String num) {
		this.num = num;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAuther() {
		return auther;
	}


	public void setAuther(String auther) {
		this.auther = auther;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getPubnum() {
		return pubnum;
	}


	public void setPubnum(String pubnum) {
		this.pubnum = pubnum;
	}
	

	

	
	
}
