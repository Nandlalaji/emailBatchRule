package com.nand.mail;

import com.nand.backend.User;

/**
 * This is implementation class of EmailRecipient
 * @author Nand
 *
 */
public class EmailRecipientImpl implements EmailRecipient{

	String email = null;
	public String getEmail() {
		return email;
	}

	public EmailRecipientImpl(User user){
		if(user!=null)
			email = user.getEmail();
	}
}
