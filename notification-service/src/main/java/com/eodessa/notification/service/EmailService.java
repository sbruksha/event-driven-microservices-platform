package com.eodessa.notification.service;

import javax.mail.MessagingException;

import com.eodessa.notification.domain.NotificationType;
import com.eodessa.notification.domain.Recipient;

import java.io.IOException;

public interface EmailService {

	void send(NotificationType type, Recipient recipient, String attachment) throws MessagingException, IOException;

}
