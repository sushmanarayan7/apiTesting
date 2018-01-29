package AccountActions;

import base.*;
import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.util.MailSSLSocketFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;

public class GetToken extends DriverCreation{

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    // Method to set the Session, read the number of unread messages and set the port.
    public void getToken() throws MessagingException,IOException,GeneralSecurityException {
        Properties props = System.getProperties();
        IMAPFolder inbox = null;
        props.setProperty("mail.store.protocol", "imaps");
        MailSSLSocketFactory socketFactory = new MailSSLSocketFactory();
        socketFactory.setTrustAllHosts(true);

        props.put("mail.imaps.ssl.socketFactory", socketFactory);
//        props.put("mail.imaps.ssl.enable", socketFactory);
        props.setProperty("mail.imap.ssl.enable","true");
        Session session = Session.getDefaultInstance(props, null);
        Store store = session.getStore("imaps");
        System.out.println("Waiting to read mail");
        store.connect("imap.googlemail.com","tesing1.coinsecure@gmail.com", "CoinSecure@12*"); // Hardcoded the username and password. There is an alternative solution.
        //"tesing1.coinsecure@gmail.com", "CoinSecure@12*"
        inbox = (IMAPFolder)store.getFolder("INBOX");
        System.out.println("Number of Unread Messages : " + inbox.getUnreadMessageCount());
        inbox.open(Folder.READ_WRITE);
        Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));

        FetchProfile fp = new FetchProfile();
        fp.add(FetchProfile.Item.ENVELOPE);
        fp.add(FetchProfile.Item.CONTENT_INFO);
        inbox.fetch(messages, fp);

        try {
            printAllMessages(messages);
            inbox.close(false); //initially set to true
            store.close();
        } catch (Exception e) {
            System.out.println("Exception arises at the time of reading email");
            e.printStackTrace();
        }
    }

    // Method to Print the Unread Messages.
    public void printAllMessages(Message[] msgs)throws Exception{
        for(int i=0;i<msgs.length;i++) {
            printEnvelope(msgs[i]);
        }
    }

    //Method to print the Subject, Date, Content of the Mail.
    public String printEnvelope(Message message) throws Exception {
        PrintWriter writer = new PrintWriter("Token-File.txt", "UTF-8");
        StringBuilder receiveToken = new StringBuilder();
        String token = "";
        String result ="";

        Address[] address;
        if((address = message.getFrom()) != null){
            for(int j=0;j<address.length;j++){
//                System.out.println("FROM :" + address[j].toString());
                System.out.println();
            }
        }

        if((address = message.getRecipients(Message.RecipientType.TO)) != null){
            for(int j=0;j<address.length;j++){
//                System.out.println("TO :" +address[j].toString());
                System.out.println();
            }
        }

        String subject = message.getSubject();
        if(message.isMimeType("text/plain")){
            result = message.getContent().toString();
        } else if(message.isMimeType("multipart/*")){
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            result = getTextFromMimeMultiPart(mimeMultipart);
        }
        System.out.println("Subject : " +subject);
        System.out.println("Mail Content :" +result);

        if(subject.equalsIgnoreCase("Coinsecure - Login Link")){ /*  For Login */
            for (int i = 0; i<result.length(); i++){
                if (Character.isDigit(result.charAt(i))){
                    receiveToken.append(result.charAt(i));
                }
            }
            String token_to_string = receiveToken.toString();
            String remove_last_two_digits = token_to_string.substring(0,token_to_string.length()-2);
            token = remove_last_two_digits.substring(remove_last_two_digits.length()-6);
            writer.println(token);
            writer.close();
        } else if(subject.equalsIgnoreCase("Coinsecure - Forgot Password Verification Link") || subject.equalsIgnoreCase("Coinsecure - Signup Verification Link")){ /* Forgot Password and Sign Up*/
            String[] split_result = result.split("\\?");
            for (int i = 0; i<split_result[0].length(); i++){
                if (Character.isDigit(split_result[0].charAt(i))){
                    receiveToken.append(split_result[0].charAt(i));
                }
            }
            writer.println(receiveToken);
            writer.close();

        }
        return token;
    }

    // Method to detect type of Email (Plain text or HTML). If HTML then parsing teh Email content using Jsoup HTML Parser.

    public String getTextFromMimeMultiPart(MimeMultipart mimeMultipart) throws MessagingException, IOException {

        String result = "";
        File tokenFile = new File("Data.txt");
        PrintWriter writer = new PrintWriter(tokenFile,"UTF-8");
        int count = mimeMultipart.getCount();
        System.out.println("GET COUNT is : " + count);
        for(int i=0;i<count;i++){
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if(bodyPart.isMimeType("text/plain")){
                result = result + "\n" + bodyPart.getContent();
            }else if(bodyPart.isMimeType("text/html")){
                String html = (String)bodyPart.getContent();
                result = result + "\n" + org.jsoup.Jsoup.parse(html);
                org.jsoup.nodes.Document doc = Jsoup.parse(result);
                Element link = doc.select("a").last();
                result = link.toString();
                writer.println(result);
                writer.close();
            } else if(bodyPart.getContent() instanceof MimeMultipart){
                result = result + getTextFromMimeMultiPart((MimeMultipart)bodyPart.getContent());
            }
        }
        return result;
    }

}

