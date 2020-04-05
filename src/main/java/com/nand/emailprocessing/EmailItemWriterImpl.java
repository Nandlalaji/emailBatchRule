package com.nand.emailprocessing;

import com.nand.mail.EmailRecipient;
import com.nand.mail.EmailRecipientImpl;
import com.nand.mail.EmailService;
import com.nand.mail.EmailServiceImpl;
import com.nand.model.OutputItem;

/**
 * This is implementation class of EmailItemWriter
 * @author Nand
 *
 */
public class EmailItemWriterImpl<O> implements EmailItemWriter<O>{
    
	private EmailService emailService = new EmailServiceImpl();

    public void write(O item) {
    	EmailRecipient emailRecipient = new EmailRecipientImpl(((OutputItem)item).getUser());
        emailService.sendMail(emailRecipient, ((OutputItem)item).getMailType());
    }
}
