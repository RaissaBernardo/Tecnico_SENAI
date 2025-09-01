package com.agenda.fabiana.model;

import com.agenda.fabiana.entity.AgendaEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AgendaModel {
    public List<AgendaEntity> contacts = new ArrayList<>();
    private static final String FILE_PATH = "contacts.json";
    private ObjectMapper objectMapper = new ObjectMapper();

    public AgendaModel() {
        loadFromFile();
    }

    public void addContact(AgendaEntity contact) throws IllegalArgumentException {
        if (contact.getName() == null || contact.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (contact.getPhone() == null || contact.getPhone().isEmpty()) {
            throw new IllegalArgumentException("Phone cannot be empty");
        }
        if (contacts.stream().anyMatch(c -> c.equals(contact))) {
            throw new IllegalArgumentException("Duplicate contact (same name and phone)");
        }
        contacts.add(contact);
        saveToFile();
    }

    public List<AgendaEntity> getAllContacts() {
        return new ArrayList<>(contacts);
    }

    public List<AgendaEntity> searchByNameOrEmail(String query) {
        if (query == null || query.isEmpty()) {
            return getAllContacts();
        }
        return contacts.stream()
                .filter(c -> (c.getName() != null && c.getName().toLowerCase().contains(query.toLowerCase())) ||
                        (c.getEmail() != null && c.getEmail().toLowerCase().contains(query.toLowerCase())))
                .collect(Collectors.toList());
    }

    public void updateContact(String oldName, AgendaEntity updatedContact) throws IllegalArgumentException {
        Optional<AgendaEntity> existing = contacts.stream()
                .filter(c -> c.getName().equals(oldName))
                .findFirst();
        if (existing.isEmpty()) {
            throw new IllegalArgumentException("Contact not found");
        }
        if (updatedContact.getName() == null || updatedContact.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (updatedContact.getPhone() == null || updatedContact.getPhone().isEmpty()) {
            throw new IllegalArgumentException("Phone cannot be empty");
        }
        // Check for duplicates excluding the current one
        if (contacts.stream().anyMatch(c -> !c.getName().equals(oldName) && c.equals(updatedContact))) {
            throw new IllegalArgumentException("Duplicate contact (same name and phone)");
        }
        AgendaEntity contact = existing.get();
        contact.setName(updatedContact.getName());
        contact.setPhone(updatedContact.getPhone());
        contact.setEmail(updatedContact.getEmail());
        saveToFile();
    }

    public void deleteContact(String name) throws IllegalArgumentException {
        boolean removed = contacts.removeIf(c -> c.getName().equals(name));
        if (!removed) {
            throw new IllegalArgumentException("Contact not found");
        }
        saveToFile();
    }

    private void saveToFile() {
        try {
            objectMapper.writeValue(new File(FILE_PATH), contacts);
        } catch (IOException e) {
            System.err.println("Error saving to file: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try {
                CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, AgendaEntity.class);
                contacts = objectMapper.readValue(file, listType);
            } catch (IOException e) {
                System.err.println("Error loading from file: " + e.getMessage());
            }
        }
    }
}