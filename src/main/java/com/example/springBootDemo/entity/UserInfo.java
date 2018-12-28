package com.example.springBootDemo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author	chdaba
 * @version	1.0.0
 * @date	2018-12-26 18:27:49
 */
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     */
    private BigDecimal id;

    /**
     */
    private String loginName;

    /**
     */
    private String loginPassword;

    /**
     */
    private String loginType;

    /**
     */
    private String state;

    /**
     */
    private String personCode;

    /**
     */
    private String createPersonCode;

    /**
     */
    private Date createTime;

    /**
     */
    private String secondPassword;

    /**
     */
    private Date freezeDate;

    /**
     */
    private Date insertTimestamp;

    /**
     * @return	ID	null
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * @param	id	null
     */
    public void setId(BigDecimal id) {
        this.id = id;
    }

    /**
     * @return	LOGIN_NAME	null
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * @param	loginName	null
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * @return	LOGIN_PASSWORD	null
     */
    public String getLoginPassword() {
        return loginPassword;
    }

    /**
     * @param	loginPassword	null
     */
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    /**
     * @return	LOGIN_TYPE	null
     */
    public String getLoginType() {
        return loginType;
    }

    /**
     * @param	loginType	null
     */
    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    /**
     * @return	STATE	null
     */
    public String getState() {
        return state;
    }

    /**
     * @param	state	null
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return	PERSON_CODE	null
     */
    public String getPersonCode() {
        return personCode;
    }

    /**
     * @param	personCode	null
     */
    public void setPersonCode(String personCode) {
        this.personCode = personCode;
    }

    /**
     * @return	CREATE_PERSON_CODE	null
     */
    public String getCreatePersonCode() {
        return createPersonCode;
    }

    /**
     * @param	createPersonCode	null
     */
    public void setCreatePersonCode(String createPersonCode) {
        this.createPersonCode = createPersonCode;
    }

    /**
     * @return	CREATE_TIME	null
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param	createTime	null
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return	SECOND_PASSWORD	null
     */
    public String getSecondPassword() {
        return secondPassword;
    }

    /**
     * @param	secondPassword	null
     */
    public void setSecondPassword(String secondPassword) {
        this.secondPassword = secondPassword;
    }

    /**
     * @return	FREEZE_DATE	null
     */
    public Date getFreezeDate() {
        return freezeDate;
    }

    /**
     * @param	freezeDate	null
     */
    public void setFreezeDate(Date freezeDate) {
        this.freezeDate = freezeDate;
    }

    /**
     * @return	INSERT_TIMESTAMP	null
     */
    public Date getInsertTimestamp() {
        return insertTimestamp;
    }

    /**
     * @param	insertTimestamp	null
     */
    public void setInsertTimestamp(Date insertTimestamp) {
        this.insertTimestamp = insertTimestamp;
    }

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", loginName=" + loginName + ", loginPassword=" + loginPassword + ", loginType="
				+ loginType + ", state=" + state + ", personCode=" + personCode + ", createPersonCode="
				+ createPersonCode + ", createTime=" + createTime + ", secondPassword=" + secondPassword
				+ ", freezeDate=" + freezeDate + ", insertTimestamp=" + insertTimestamp + "]";
	}
}