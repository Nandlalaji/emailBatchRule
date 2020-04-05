package com.nand.mail;

/**
 * Interface for emails service.
 */
public interface EmailService {

    /**
     * Will send an email to a recipient.
     *
     * @param recipient email recipient
     * @param mailType  type of mail
     */
    void sendMail(EmailRecipient recipient, MailType mailType);

    /**
     * MailType defines which kind of email will be sent
     */
    enum MailType {
        MAIL_TYPE_1 (1),
        MAIL_TYPE_2 (2),
        MAIL_TYPE_3 (3),
        MAIL_TYPE_4 (4),
        MAIL_TYPE_5 (5);

        private Integer value;

        MailType (Integer value){
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public static MailType tyoeOf (Integer value){
            if (value == 1)
                return MAIL_TYPE_1;
            if (value == 2)
                return MAIL_TYPE_2;
            if (value ==3)
                return MAIL_TYPE_3;
            if (value ==4 )
                return MAIL_TYPE_4;
            if (value == 5)
                return MailType.MAIL_TYPE_5;

            // returns default type if there would no match
            return MailType.MAIL_TYPE_1;
        }
    }

}
