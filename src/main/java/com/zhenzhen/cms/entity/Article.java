package com.zhenzhen.cms.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @ClassName: Article 
 * @Description: 文章
 * @author: Lzz
 * @date: 2020年3月3日 上午11:38:19
 */
public class Article implements Serializable{
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;//主键
	private String title;//文章标题
	private String summary;//文章摘要
	private String content;//文章内容
	private String picture;//文章的标题图片
	private Integer channelId;//所属栏目ID
	private Integer categoryId;//所属分类ID
	private Integer userId;//文章发布人ID
	private Integer hits;//  点击量
	private Integer hot;//是否热门文章 1：热门 0 ：一般文章
	private Integer status;//文章审核状态     0：待审        1：审核通过     -1: 审核未通过
	private Integer deleted;// 删除状态 0:正常，1：逻辑删除
	private Date created;// 文章发布时间
	private  Date  updated;// 文章修改时间
	private Channel channel;
	private Category category;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Integer getChannelId() {
		return channelId;
	}
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Integer getHits() {
		return hits;
	}
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	public Integer getHot() {
		return hot;
	}
	public void setHot(Integer hot) {
		this.hot = hot;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
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
//	public Integer getContentType() {
//		return contentType;
//	}
//	public void setContentType(Integer contentType) {
//		this.contentType = contentType;
//	}
//	public String getKeywords() {
//		return keywords;
//	}
//	public void setKeywords(String keywords) {
//		this.keywords = keywords;
//	}
//	public String getOriginal() {
//		return original;
//	}
//	public void setOriginal(String original) {
//		this.original = original;
//	}
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Article(Integer id, String title, String picture, Integer channelId, Integer categoryId, Integer userId,
			String content, String summary, Integer hits, Integer hot, Integer status, Integer deleted, Date created,
			Date updated, Integer contentType, String keywords, String original, User user, Channel channel,
			Category category) {
		super();
		this.id = id;
		this.title = title;
		this.picture = picture;
		this.channelId = channelId;
		this.categoryId = categoryId;
		this.userId = userId;
		this.content = content;
		this.summary = summary;
		this.hits = hits;
		this.hot = hot;
		this.status = status;
		this.deleted = deleted;
		this.created = created;
		this.updated = updated;
//		this.contentType = contentType;
//		this.keywords = keywords;
//		this.original = original;
//		this.user = user;
		this.channel = channel;
		this.category = category;
	}
	public Article() {
		super();
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", picture=" + picture + ", channelId=" + channelId
				+ ", categoryId=" + categoryId + ", userId=" + userId + ", content=" + content + ", summary=" + summary
				+ ", hits=" + hits + ", hot=" + hot + ", status=" + status + ", deleted=" + deleted + ", created="
				+ created + ", updated=" + updated + ", contentType="  + ", channel=" + channel + ", category=" + category + "]";
	}
    
}
