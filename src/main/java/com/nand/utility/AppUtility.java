package com.nand.utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.nand.backend.User;
import com.nand.exception.RuleParseException;
import com.nand.model.Rule;

/**
 * Utility class to do logic apart from real flow.
 * 
 * @author Nand
 */
public class AppUtility {
	
	private final static Properties properties = new Properties();
	private final static ClassLoader classLoader = ClassLoader.getSystemClassLoader();
	
	/**
     * Read email content from property file according to emailType
     * <p/>
     * @param emailType
     * @return emailContentString
     */
	public static String readEmailContent(String emailType){
		try {
			properties.load(classLoader.getResourceAsStream(AppConstant.EMAIL_CONTENT_FILE));
			return properties.getProperty(emailType);
		} catch (IOException e) {
			System.out.println("Exception in readEmailContent method" + e.getMessage());
		}
		return null;
	}
	
	/**
     * Read email type rule from file
     * <p/>
     * @return list of rules
     */
	public static List<Rule> readEmailTypeRules(){
		
		List<Rule> rules = new ArrayList<Rule>();
		 
		File file = new File(classLoader.getResource(AppConstant.EMAIL_RULE_FILE).getFile());
		 
		String content;
		try {
			if(file.exists()){
				content = new String(Files.readAllBytes(file.toPath()));
				rules = loadRules(content);
			}
			return rules;
		} catch (IOException e) {
			System.out.println("IOException in readEmailTypeRules method" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception in readEmailTypeRules method" + e.getMessage());
		}
		return null;
	}
	
	/**
     * Read User from file
     * <p/>
     * @return list of Users
     */
	public static List<User> readUsers(){
		
		List<User> users = new ArrayList<User>();
		 
		File file = new File(classLoader.getResource(AppConstant.USERS_INFO_LIST_FILE).getFile());
		 
		String content;
		try {
			if(file.exists()){
				content = new String(Files.readAllBytes(file.toPath()));
				String[] lines = content.split("\\r?\\n");
				for (String line : lines) {
					if (line.trim().isEmpty() || line.startsWith("#"))
						continue;
					String[] userInfo = line.split("\\,");
					String email = null;
					boolean hasContract = false;
					int friendsNumber= 0,sentInvitationsNumber = 0;
					if(userInfo[0]!=null || !userInfo[0].isEmpty())
						email = userInfo[0].trim();
					if(userInfo[1]!=null || !userInfo[1].isEmpty() )
						hasContract = Boolean.parseBoolean(userInfo[1].trim());
					if(userInfo[2]!=null || !userInfo[2].isEmpty() )
						friendsNumber = Integer.parseInt(userInfo[2].trim());
					if(userInfo[3]!=null || !userInfo[3].isEmpty() )
						sentInvitationsNumber = Integer.parseInt(userInfo[3].trim());
						
					users.add(new User(email,hasContract,friendsNumber,sentInvitationsNumber));
				}
				return users;
			}
		} catch (IOException e) {
			System.out.println("IOException in readUsers method" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception in readUsers method" + e.getMessage());
		}
		return null;
	}
	
	/**
	 * load rules from a reader (rules are stored as ascii file/s)
	 * 
	 * @param content
	 * @return
	 */
	private static List<Rule> loadRules(String content) {
		List<Rule> rules = new ArrayList<Rule>();
		String[] lines = content.split("\\r?\\n");
		for (String line : lines) {
			if (line.trim().isEmpty() || line.startsWith("#"))
				continue;
			Rule rule = null;
			try {
				rule = RuleParser.parseRule(line);
			} catch (RuleParseException e) {
				System.out.println("RuleParseException in loadRules method" + e.getMessage());
			}
			rules.add(rule);
		}
		return rules;
	}
	
	/**
	 * get applicable rule for a user
	 * 
	 * @param user
	 * @return
	 */
	public static Set<Rule> applicableRules(User user) {
		SortedSet<Rule> rules = new TreeSet<Rule>(new Rule.RuleMaxPriorityComparator());
		Iterator<Rule> iterator = readEmailTypeRules().iterator();
		while (iterator.hasNext()) {
			Rule rule = (Rule) iterator.next();
			if (rule.applies(user))
				rules.add(rule);
		}
		return rules;
	}
}
