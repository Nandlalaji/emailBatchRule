This is sample app to show how rules for email can be read from file. 

Description

This is  application which will get all users, calculate their situation and send them the email which fits best to their situation.

Criteria

Send emails to users. The specific type of email that must be sent will be determined by the following rules:


Has Contract	# Friends	# Invitations		Type of Email


no	0	0	->	MAIL_TYPE_2

no	>1	0	->	MAIL_TYPE_3

no	>3	>1	->	MAIL_TYPE_1

no	<3	>1	->	MAIL_TYPE_2

no	<3	>6	->	MAIL_TYPE_3

yes	0	0	->	MAIL_TYPE_3

yes	0	>3	->	MAIL_TYPE_3

yes	>1	-	->	MAIL_TYPE_4

yes	>4	>3	->	MAIL_TYPE_5

Users should get only one email in case their situation matches more than one of the above conditions.

The priority to choose which type of email to send is defined by the number in the type name (i.e. MAIL_TYPE_3 has a priority of 3 and MAIL_TYPE_5 has a priority of 5). The higher the number, the higher the priority will be.

i have implemented above logic by using file emailRules.data in resource and not coding the logic in code. 

