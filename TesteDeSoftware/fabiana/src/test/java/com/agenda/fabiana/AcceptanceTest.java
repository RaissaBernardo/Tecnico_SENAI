package com.agenda.fabiana;

import com.agenda.fabiana.controller.AgendaController;
import com.agenda.fabiana.entity.AgendaEntity;
import com.agenda.fabiana.model.AgendaModel;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Agenda de Contatos")
@Feature("CRUD Operations")
public class AcceptanceTest {
    private AgendaModel model;
    private AgendaController controller;

    @BeforeEach
    public void setUp() {
        model = new AgendaModel();
        model.contacts.clear(); // For test isolation
        controller = new AgendaController(model);
    }

    @Story("Adicionar Contato")
    @Step("Adicionar um contato válido")
    @Test
    public void testAddValidContact() {
        controller.addContact("John", "123456", "john@example.com");
        assertEquals(1, controller.getAllContacts().size());
    }

    @Story("Adicionar Contato")
    @Step("Tentar adicionar contato inválido")
    @Test
    public void testAddInvalidContact() {
        assertThrows(IllegalArgumentException.class, () -> controller.addContact("", "123456", "john@example.com"));
    }

    @Story("Listar Contatos")
    @Step("Listar todos os contatos")
    @Test
    public void testListContacts() {
        controller.addContact("John", "123456", "john@example.com");
        assertEquals(1, controller.getAllContacts().size());
    }

    @Story("Buscar Contatos")
    @Step("Buscar por nome ou e-mail")
    @Test
    public void testSearchContacts() {
        controller.addContact("John", "123456", "john@example.com");
        assertEquals(1, controller.searchContacts("john").size());
    }

    @Story("Editar Contato")
    @Step("Atualizar contato existente")
    @Test
    public void testUpdateContact() {
        controller.addContact("John", "123456", "john@example.com");
        controller.updateContact("John", "Johnny", "654321", "johnny@example.com");
        AgendaEntity updated = controller.getAllContacts().get(0);
        assertEquals("Johnny", updated.getName());
    }

    @Story("Editar Contato")
    @Step("Tentar atualizar contato inexistente")
    @Test
    public void testUpdateNonexistentContact() {
        assertThrows(IllegalArgumentException.class, () -> controller.updateContact("Nonexistent", "New", "123", "new@email.com"));
    }

    @Story("Remover Contato")
    @Step("Remover contato existente")
    @Test
    public void testDeleteContact() {
        controller.addContact("John", "123456", "john@example.com");
        controller.deleteContact("John");
        assertTrue(controller.getAllContacts().isEmpty());
    }

    @Story("Remover Contato")
    @Step("Tentar remover contato inexistente")
    @Test
    public void testDeleteNonexistentContact() {
        assertThrows(IllegalArgumentException.class, () -> controller.deleteContact("Nonexistent"));
    }
}