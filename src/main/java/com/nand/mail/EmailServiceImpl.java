package com.nand.mail;

import com.nand.utility.AppUtility;

/**
 * This is implementation class of EmailService
 * @author Nand
 *
 */
public class EmailServiceImpl implements EmailService {

	public void sendMail(EmailRecipient recipient, MailType mailType) {
		String emailContent = AppUtility.readEmailContent(mailType.toString());
		System.out.println("Send email to :"+ recipient.getEmail()+ " emailContent : "+emailContent);
		

	}

}
