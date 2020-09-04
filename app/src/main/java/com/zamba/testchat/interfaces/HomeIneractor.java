package com.zamba.testchat.interfaces;

import com.zamba.testchat.models.Contact;

import java.util.HashMap;

/**
 * Created by a_man on 01-01-2018.
 */

public interface HomeIneractor {
    HashMap<String, Contact> getLocalContacts();
}
