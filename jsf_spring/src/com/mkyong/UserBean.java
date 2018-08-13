package com.mkyong;

import java.io.Serializable;

import com.mkyong.user.bo.UserBo;

//DI via JSF managed bean
public class UserBean implements Serializable{
 
	//DI via Spring
	UserBo userBo = (UserBo) ServiceFinder.findBean("userBo");

	public void setUserBo(UserBo userBo) {
		this.userBo = userBo;
	}

	public String getPrintMsgFromSpring() {
		
		return userBo.getMessage();
		
	}
	
}
