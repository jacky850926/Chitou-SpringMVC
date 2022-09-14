package tw.georgia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity @Table(name = "wenzhang")
@Component
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "postID")
	private int postID;
	
	@Column(name = "posterID")
	private int posterID;
	
	@Column(name = "bigClassID")
	private int bigClassID;
	
	@Column(name = "articleClassID")
	private int articleClassID;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "articleDate")
	private String articleDate;
	
	@Column(name = "photo")
	private String photo;
	
	
	public Article() {
	}


	public Article(int posterID, int bigClassID, int articleClassID, String title, String content, String articleDate,
			String photo) {
		super();
		this.posterID = posterID;
		this.bigClassID = bigClassID;
		this.articleClassID = articleClassID;
		this.title = title;
		this.content = content;
		this.articleDate = articleDate;
		this.photo = photo;
	}

	
	public Article(int postID, int posterID, int bigClassID, int articleClassID, String title, String content,
			String articleDate, String photo) {
		super();
		this.postID = postID;
		this.posterID = posterID;
		this.bigClassID = bigClassID;
		this.articleClassID = articleClassID;
		this.title = title;
		this.content = content;
		this.articleDate = articleDate;
		this.photo = photo;
	}

	

	public Article(int postID, int bigClassID, int articleClassID, String title, String content, String photo) {
		super();
		this.postID = postID;
		this.bigClassID = bigClassID;
		this.articleClassID = articleClassID;
		this.title = title;
		this.content = content;
		this.photo = photo;
	}


	public int getPostID() {
		return postID;
	}


	public void setPostID(int postID) {
		this.postID = postID;
	}


	public int getPosterID() {
		return posterID;
	}


	public void setPosterID(int posterID) {
		this.posterID = posterID;
	}


	public int getBigClassID() {
		return bigClassID;
	}


	public void setBigClassID(int bigClassID) {
		this.bigClassID = bigClassID;
	}


	public int getArticleClassID() {
		return articleClassID;
	}


	public void setArticleClassID(int articleClassID) {
		this.articleClassID = articleClassID;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getArticleDate() {
		return articleDate;
	}


	public void setArticleDate(String articleDate) {
		this.articleDate = articleDate;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	

}
