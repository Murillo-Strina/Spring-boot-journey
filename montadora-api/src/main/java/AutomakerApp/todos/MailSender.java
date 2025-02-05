package AutomakerApp.todos;

import org.springframework.stereotype.Component;

@Component
public class MailSender {

    public void sendEmail(String msg) {
        System.out.println("Email sent: " + msg);
    }

}
