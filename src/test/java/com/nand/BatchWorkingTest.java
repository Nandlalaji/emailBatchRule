package com.nand;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.nand.backend.User;
import com.nand.emailprocessing.EmailItemProcessing;
import com.nand.emailprocessing.EmailItemWriterImpl;
import com.nand.emailprocessing.UserItemReaderImpl;
import com.nand.model.InputItem;
import com.nand.model.OutputItem;
import com.nand.utility.AppUtility;

public class BatchWorkingTest {
	@Before
	public void init() {
	}
	
	@Test
	public void testBatchProcess() throws Exception {
			List<InputItem> items = new ArrayList<InputItem>();	
			List<User> users = AppUtility.readUsers();
			for(User user: users){
				items.add(new InputItem(user));
			}
	        
	        EmailItemProcessing<InputItem,OutputItem> mailItemProcessing = new EmailItemProcessing<InputItem,OutputItem>(new UserItemReaderImpl<InputItem>(items),
	                new EmailItemWriterImpl<OutputItem>());

	        mailItemProcessing.doProcessing();
	}
}
