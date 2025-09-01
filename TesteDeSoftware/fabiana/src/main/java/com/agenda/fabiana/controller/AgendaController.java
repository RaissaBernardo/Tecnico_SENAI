package com.agenda.fabiana.controller;

import com.agenda.fabiana.entity.AgendaEntity;
import com.agenda.fabiana.model.AgendaModel;

import java.util.List;

public class AgendaController {
    private AgendaModel model;

    public AgendaController(AgendaModel model) {
        this.model = model;
    }

    public void addContact(String name, String phone, String email) {
        AgendaEntity contact = new AgendaEntity(name, phone, email);
        model.addContact(contact);
    }

    public List<AgendaEntity> getAllContacts() {
        return model.getAllContacts();
    }

    public List<AgendaEntity> searchContacts(String query) {
        return model.searchByNameOrEmail(query);
    }

    public void updateContact(String oldName, String newName, String newPhone, String newEmail) {
        AgendaEntity updated = new AgendaEntity(newName, newPhone, newEmail);
        model.updateContact(oldName, updated);
    }

    public void deleteContact(String name) {
        model.deleteContact(name);
    }
}