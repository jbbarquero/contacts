// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.malsolo.contacts.domain;

import com.malsolo.contacts.domain.Contact;
import com.malsolo.contacts.domain.ContactType;

privileged aspect Contact_Roo_JavaBean {
    
    public String Contact.getFirstName() {
        return this.firstName;
    }
    
    public void Contact.setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String Contact.getLastName() {
        return this.lastName;
    }
    
    public void Contact.setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public ContactType Contact.getContactType() {
        return this.contactType;
    }
    
    public void Contact.setContactType(ContactType contactType) {
        this.contactType = contactType;
    }
    
    public Long Contact.getPhone() {
        return this.phone;
    }
    
    public void Contact.setPhone(Long phone) {
        this.phone = phone;
    }
    
}
