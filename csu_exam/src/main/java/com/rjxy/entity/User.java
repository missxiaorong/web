package com.rjxy.entity;

public class User {
	private int id;
	private 	String login;//登陆名
	private String name;//真实姓名
	private String passwd;
	private int type;//类型1：用户管理员 2：题库管理员 3：题库使用者
	private int status;//0：禁用 1：正常
	private long last_login;//最后登陆时间戳
	private long gmtCreate;//创建时间戳
	private long gmtModified;//最后修改时间
	private int createById;
	private int lastModifiedId;
	public User() {
		super();
	}
	public User(int id, String login, String name, String passwd, int type, int status, long last_login, long gmtCreate,
			long gmtModified, int createById, int lastModifiedId) {
		super();
		this.id = id;
		this.login = login;
		this.name = name;
		this.passwd = passwd;
		this.type = type;
		this.status = status;
		this.last_login = last_login;
		this.gmtCreate = gmtCreate;
		this.gmtModified = gmtModified;
		this.createById = createById;
		this.lastModifiedId = lastModifiedId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getLast_login() {
		return last_login;
	}
	public void setLast_login(long last_login) {
		this.last_login = last_login;
	}
	public long getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(long gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public long getGmtModified() {
		return gmtModified;
	}
	public void setGmtModified(long gmtModified) {
		this.gmtModified = gmtModified;
	}
	public int getCreateById() {
		return createById;
	}
	public void setCreateById(int createById) {
		this.createById = createById;
	}
	public int getLastModifiedId() {
		return lastModifiedId;
	}
	public void setLastModifiedId(int lastModifiedId) {
		this.lastModifiedId = lastModifiedId;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", name=" + name + ", passwd=" + passwd + ", type=" + type
				+ ", status=" + status + ", last_login=" + last_login + ", gmtCreate=" + gmtCreate + ", gmtModified="
				+ gmtModified + ", createById=" + createById + ", lastModifiedId=" + lastModifiedId + "]";
	}

}
