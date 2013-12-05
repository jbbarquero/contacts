package com.malsolo.contacts.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Enumerated;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Contact {

    /**
     */
    @NotNull
    @Size(min = 1, max = 100)
    private String firstName;

    /**
     */
    @NotNull
    @Size(min = 1, max = 250)
    private String lastName;

    /**
     */
    @Enumerated
    private ContactType contactType;

    /**
     */
    private Long phone;
}
