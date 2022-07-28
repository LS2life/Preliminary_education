package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * The type Log.
 */
@Entity
public class Log {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ip;
	private String method;
	private Date regdate;

	/**
	 * Gets id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets id.
	 *
	 * @param id the id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets ip.
	 *
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * Sets ip.
	 *
	 * @param ip the ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * Gets method.
	 *
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * Sets method.
	 *
	 * @param method the method
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * Gets regdate.
	 *
	 * @return the regdate
	 */
	public Date getRegdate() {
		return regdate;
	}

	/**
	 * Sets regdate.
	 *
	 * @param regdate the regdate
	 */
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	
}
