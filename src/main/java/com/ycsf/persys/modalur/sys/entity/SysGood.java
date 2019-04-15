package com.ycsf.persys.modalur.sys.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class SysGood implements Serializable{
	private int goodId;//商品id
	private String goodTitle;//商品标题
	private int goodPrice;//商品价格
	private String sellPoint;//商品卖点
	private int num;//库存数量
	private String image;//商品图片
	private int cid;//所属类目
	private int status;//商品状态 1-正常 2-下架
	private Date created;//创建时间
	private Date updated;//更新时间
	public int getGoodId() {
		return goodId;
	}
	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}
	public String getGoodTitle() {
		return goodTitle;
	}
	public void setGoodTitle(String goodTitle) {
		this.goodTitle = goodTitle;
	}
	public int getGoodPrice() {
		return goodPrice;
	}
	public void setGoodPrice(int goodPrice) {
		this.goodPrice = goodPrice;
	}
	public String getSellPoint() {
		return sellPoint;
	}
	public void setSellPoint(String sellPoint) {
		this.sellPoint = sellPoint;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
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
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	@Override
	public String toString() {
		return "SysGood [goodId=" + goodId + ", goodTitle=" + goodTitle + ", goodPrice=" + goodPrice + ", num=" + num
				+ ", image=" + image + ", cid=" + cid + ", status=" + status + ", created=" + created + ", updated="
				+ updated + "]";
	}
	
	
}
