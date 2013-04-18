package com.example.glidden;

public class ItemDetails {
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return itemDescription;
	}
	public String getNameTitle() {
		return name;
	}
	public void setNameTitle(String name) {
		this.name = name;
	}
	public void setProjectDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public int getImageNumber() {
		return imageNumber;
	}
	public void setImageNumber(int imageNumber) {
		this.imageNumber = imageNumber;
	}
	
	private String name ;
	private String itemDescription;
	private int imageNumber;

	
}
