package com.nand.emailprocessing;

import java.util.SortedSet;

import com.nand.mail.EmailService;
import com.nand.model.InputItem;
import com.nand.model.OutputItem;
import com.nand.model.Rule;
import com.nand.processing.ItemProcessing;
import com.nand.processing.ItemReader;
import com.nand.processing.ItemWriter;
import com.nand.utility.AppUtility;


/**
 * This is implementation class of ItemProcessing
 * @author Nand
 *
 */
public class EmailItemProcessing<I,O> extends ItemProcessing<I,O> {

	public EmailItemProcessing(ItemReader<I> reader, ItemWriter<O> writer) {
		super(reader, writer);
	}

	private EmailService.MailType defaultEmailType = EmailService.MailType.MAIL_TYPE_1;

	@SuppressWarnings("unchecked")
	@Override
    protected O process(I item) {
        
		SortedSet<Rule> appl = (SortedSet<Rule>) AppUtility.applicableRules(((InputItem)item).getUser());
		EmailService.MailType emailType = defaultEmailType;
		if (!appl.isEmpty()) {
			emailType = EmailService.MailType.tyoeOf(appl.first().getApplyResult());
		}
        return (O) new OutputItem(((InputItem)item).getUser(), emailType);
    }

}
