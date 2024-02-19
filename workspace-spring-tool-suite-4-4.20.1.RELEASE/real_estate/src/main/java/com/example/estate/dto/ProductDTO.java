package com.example.estate.dto;
import java.sql.Timestamp;

import com.example.estate.entity.User;

import lombok.Data;

@Data
public class ProductDTO {
	
	private Long productCode;
	private User user;
	private String type;
    private String address;
    private String name;
	private double area;
	private int room;
	private String transactionType;
    private int price;
	private int cost;
	private Timestamp moveDate;
	private int floor;
	private int bathroom;
	private int parking;
	private String options;
	private String image;
	private Long infomation;
	private Timestamp createDate;
	private Timestamp updatedDate;
	private Timestamp deletionDate;
	
	public Long getProductCode() {
		return productCode;
	}
	public void setProductCode(Long productCode) {
		this.productCode = productCode;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public Timestamp getMoveDate() {
		return moveDate;
	}
	public void setMoveDate(Timestamp moveDate) {
		this.moveDate = moveDate;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public int getBathroom() {
		return bathroom;
	}
	public void setBathroom(int bathroom) {
		this.bathroom = bathroom;
	}
	public int getParking() {
		return parking;
	}
	public void setParking(int parking) {
		this.parking = parking;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Long getInfomation() {
		return infomation;
	}
	public void setInfomation(Long infomation) {
		this.infomation = infomation;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Timestamp getDeletionDate() {
		return deletionDate;
	}
	public void setDeletionDate(Timestamp deletionDate) {
		this.deletionDate = deletionDate;
	}
}

