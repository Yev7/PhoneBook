package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this.phonebook= new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        phonebook.put(name, List.of(phoneNumber));
    }

    public void addAll(String name, String... phoneNumbers) {
        phonebook.put(name, List.of(phoneNumbers));
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return this.phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return this.phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for (Map.Entry<String, List<String>> entry: phonebook.entrySet()){
            if (entry.getValue().contains(phoneNumber)){
                return entry.getKey();
            }
        }
        return "Error";
    }

    public List<String> getAllContactNames() {
        List<String> allNames = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry: phonebook.entrySet()){
            allNames.add(entry.getKey());
        }
        return allNames;
    }

    public Map<String, List<String>> getMap() {
        return this.phonebook;
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Yev", "302-123-4567");
        phoneBook.addAll("Jeff", "302-238-1832", "215-135-940");
        phoneBook.add("Steve", "610-270-2840");
        System.out.println(phoneBook.getAllContactNames());
        phoneBook.remove("Steve");
        System.out.println(phoneBook.getAllContactNames());
        System.out.println(phoneBook.lookup("Yev"));
        System.out.println(phoneBook.hasEntry("Jeff"));
        System.out.println(phoneBook.reverseLookup("215-135-940"));
    }
}
