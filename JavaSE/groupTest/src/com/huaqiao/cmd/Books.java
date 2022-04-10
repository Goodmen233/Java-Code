package com.huaqiao.cmd;

public class Books {
	private int id;
	private String bookname;
	private String author;
	private String addtime;
	private int leftnumber;
	public Books() {
		super();
	}
	public Books(int id, String bookname, String author, String addtime, int leftnumber) {
		super();
		this.id = id;
		this.bookname = bookname;
		this.author = author;
		this.addtime = addtime;
		this.leftnumber = leftnumber;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the bookname
	 */
	public String getBookname() {
		return bookname;
	}
	/**
	 * @param bookname the bookname to set
	 */
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the addtime
	 */
	public String getAddtime() {
		return addtime;
	}
	/**
	 * @param addtime the addtime to set
	 */
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	/**
	 * @return the leftnumber
	 */
	public int getLeftnumber() {
		return leftnumber;
	}
	/**
	 * @param leftnumber the leftnumber to set
	 */
	public void setLeftnumber(int leftnumber) {
		this.leftnumber = leftnumber;
	}
	@Override
	public String toString() {
		return "Books [id=" + id + ", bookname=" + bookname + ", author=" + author + ", addtime=" + addtime
				+ ", leftnumber=" + leftnumber + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addtime == null) ? 0 : addtime.hashCode());
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookname == null) ? 0 : bookname.hashCode());
		result = prime * result + id;
		result = prime * result + leftnumber;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Books other = (Books) obj;
		if (addtime == null) {
			if (other.addtime != null)
				return false;
		} else if (!addtime.equals(other.addtime))
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookname == null) {
			if (other.bookname != null)
				return false;
		} else if (!bookname.equals(other.bookname))
			return false;
		if (id != other.id)
			return false;
		if (leftnumber != other.leftnumber)
			return false;
		return true;
	}
	
}
