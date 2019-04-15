package com.ycsf.persys.modalur.sys.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ycsf.persys.common.exception.ErrorInfo;
import com.ycsf.persys.modalur.sys.entity.MailInfo;

@Controller
public class MailController {

	@Autowired
	JavaMailSender mailSender;
	@Value("${spring.mail.username}")
	private String from;
	
	@RequestMapping("/sendMail")
	public @ResponseBody ErrorInfo sendMail(MailInfo info) throws MessagingException {
		
		System.out.println(info);
	    info.setFrom(from);
	    MimeMessage mimeMessage = mailSender.createMimeMessage();
	    MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
	    message.setFrom(info.getFrom());
	    message.setTo(info.getTo());
	    message.setSubject(info.getSubject());
	    message.setText(info.getMessage());
	    mailSender.send(mimeMessage);
	    
	    ErrorInfo error = new ErrorInfo();
	    error.setCode(ErrorInfo.SUCCESS);
	    return error;
	}
}
