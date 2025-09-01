package com.agenda.fabiana;

import com.agenda.fabiana.entity.AgendaEntity;
import com.agenda.fabiana.model.AgendaModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AgendaModelTest {
	private AgendaModel model;

	@BeforeEach
	public void setUp() {
		model = new AgendaModel();
		model.contacts.clear();
	}

	@Test
	public void testAddContactValid() {
		AgendaEntity contact = new AgendaEntity("John", "123456", "john@example.com");
		model.addContact(contact);
		List<AgendaEntity> contacts = model.getAllContacts();
		assertEquals(1, contacts.size());
		assertEquals("John", contacts.get(0).getName());
	}

	@Test
	public void testAddContactInvalidName() {
		AgendaEntity contact = new AgendaEntity("", "123456", "john@example.com");
		assertThrows(IllegalArgumentException.class, () -> model.addContact(contact));
	}

	@Test
	public void testAddContactDuplicate() {
		AgendaEntity contact1 = new AgendaEntity("John", "123456", "john@example.com");
		model.addContact(contact1);
		AgendaEntity contact2 = new AgendaEntity("John", "123456", "other@email.com");
		assertThrows(IllegalArgumentException.class, () -> model.addContact(contact2));
	}

	@Test
	public void testSearchByName() {
		AgendaEntity contact = new AgendaEntity("John", "123456", "john@example.com");
		model.addContact(contact);
		List<AgendaEntity> results = model.searchByNameOrEmail("John");
		assertEquals(1, results.size());
	}

	@Test
	public void testUpdateContact() {
		AgendaEntity contact = new AgendaEntity("John", "123456", "john@example.com");
		model.addContact(contact);
		AgendaEntity updated = new AgendaEntity("Johnny", "654321", "johnny@example.com");
		model.updateContact("John", updated);
		List<AgendaEntity> contacts = model.getAllContacts();
		assertEquals("Johnny", contacts.get(0).getName());
	}

	@Test
	public void testUpdateContactNotFound() {
		AgendaEntity updated = new AgendaEntity("Johnny", "654321", "johnny@example.com");
		assertThrows(IllegalArgumentException.class, () -> model.updateContact("Nonexistent", updated));
	}

	@Test
	public void testDeleteContact() {
		AgendaEntity contact = new AgendaEntity("John", "123456", "john@example.com");
		model.addContact(contact);
		model.deleteContact("John");
		assertTrue(model.getAllContacts().isEmpty());
	}

	@Test
	public void testDeleteContactNotFound() {
		assertThrows(IllegalArgumentException.class, () -> model.deleteContact("Nonexistent"));
	}
}