package com.malsolo.contacts.web;
import com.malsolo.contacts.domain.Contact;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/contacts")
@Controller
@RooWebScaffold(path = "contacts", formBackingObject = Contact.class)
public class ContactController {
}
