package com.example.yucalorie.king.model;

public class User
{
	private String nick;
	private String QQ;
	private String passwd;
	private String email;

	public User(){
		this(null,null,null,null);
	}
	public User(String nick, String qQ, String passwd, String email)
	{
		this.nick = nick;
		QQ = qQ;
		this.passwd = passwd;
		this.email = email;
	}
	
	public void setNick(String nick)
	{
		this.nick = nick;
	}

	public String getNick()
	{
		return nick;
	}

	public void setQQ(String qQ)
	{
		QQ = qQ;
	}

	public String getQQ()
	{
		return QQ;
	}

	public void setPasswd(String passwd)
	{
		this.passwd = passwd;
	}

	public String getPasswd()
	{
		return passwd;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getEmail()
	{
		return email;
	}}
