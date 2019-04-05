
package kata5.view;

import java.util.List;
import kata5.model.Histogram;
import kata5.model.Mail;

public class MailHistogramBuilder {
    
    public static Histogram<String> build(List<Mail> mailList) {
        Histogram<String> mailHistogram = new Histogram();
        mailList.forEach((email) -> mailHistogram.increment(email.getDomain()));
        return mailHistogram;
    }
    
}
