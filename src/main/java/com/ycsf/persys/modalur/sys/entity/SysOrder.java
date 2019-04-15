package com.ycsf.persys.modalur.sys.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class SysOrder implements Serializable{
	private int oid;//订单id
	private int uid;//用户id
	private int gid;//商品id
	private String gname;//商品名称
	private String uname;//用户名称
	private int num;//购买数量
	private int price;//商品单价
	private int totalPrice;//订单总额
	private int status;//订单状态
	private Date created;//创建时间
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	@Override
	public String toString() {
		return "SysOrder [oid=" + oid + ", uid=" + uid + ", gid=" + gid + ", gname=" + gname + ", uname=" + uname
				+ ", num=" + num + ", price=" + price + ", totalPrice=" + totalPrice + ", status=" + status
				+ ", created=" + created + "]";
	}
	
	
	
}
