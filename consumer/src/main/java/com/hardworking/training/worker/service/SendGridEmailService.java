package com.hardworking.training.worker.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class SendGridEmailService {
    private SendGrid sg;
    private String friendInvitationTemplateId = "d-d2ea9837c28e4acd8e2e67698e8571a9";


    public SendGridEmailService(@Autowired SendGrid sendGrid) {
        this.sg = sendGrid;
    }

    public void sendEmail(String emailJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> emailDetails = mapper.readValue(emailJson, new TypeReference<Map>() {
        });

        Mail mail = new Mail();
        String subject = emailDetails.get("subject").toString();

        mail.setTemplateId(friendInvitationTemplateId);


        mail.setFrom(new Email(emailDetails.get("from").toString()));

        Map<String, String> requestInfo = (Map<String, String>) emailDetails.get("request");
        List<String> toEmails = (List<String>) emailDetails.get("to_emails");
        List<String> toUsernames = (List<String>) emailDetails.get("to_usernames");

        Personalization personalization = new Personalization();

        for (String to : toEmails) {
            personalization.addTo(new Email(to));
        }

        personalization.setSubject(subject);
        personalization.addDynamicTemplateData("username", toUsernames.get(0));
        personalization.addDynamicTemplateData("request", requestInfo);

        mail.addPersonalization(personalization);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
    }

}
