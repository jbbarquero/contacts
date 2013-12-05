// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.malsolo.contacts.web;

import com.malsolo.contacts.domain.Contact;
import com.malsolo.contacts.web.ApplicationConversionServiceFactoryBean;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;

privileged aspect ApplicationConversionServiceFactoryBean_Roo_ConversionService {
    
    declare @type: ApplicationConversionServiceFactoryBean: @Configurable;
    
    public Converter<Contact, String> ApplicationConversionServiceFactoryBean.getContactToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.malsolo.contacts.domain.Contact, java.lang.String>() {
            public String convert(Contact contact) {
                return new StringBuilder().append(contact.getFirstName()).append(' ').append(contact.getLastName()).append(' ').append(contact.getPhone()).toString();
            }
        };
    }
    
    public Converter<Long, Contact> ApplicationConversionServiceFactoryBean.getIdToContactConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.malsolo.contacts.domain.Contact>() {
            public com.malsolo.contacts.domain.Contact convert(java.lang.Long id) {
                return Contact.findContact(id);
            }
        };
    }
    
    public Converter<String, Contact> ApplicationConversionServiceFactoryBean.getStringToContactConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.malsolo.contacts.domain.Contact>() {
            public com.malsolo.contacts.domain.Contact convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Contact.class);
            }
        };
    }
    
    public void ApplicationConversionServiceFactoryBean.installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(getContactToStringConverter());
        registry.addConverter(getIdToContactConverter());
        registry.addConverter(getStringToContactConverter());
    }
    
    public void ApplicationConversionServiceFactoryBean.afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
    
}
