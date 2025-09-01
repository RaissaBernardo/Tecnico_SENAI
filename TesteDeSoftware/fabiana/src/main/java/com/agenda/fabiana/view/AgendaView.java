package com.agenda.fabiana.view;

import com.agenda.fabiana.controller.AgendaController;
import com.agenda.fabiana.entity.AgendaEntity;

import java.util.List;
import java.util.Scanner;

public class AgendaView {
    private AgendaController controller;
    private Scanner scanner = new Scanner(System.in);

    public AgendaView(AgendaController controller) {
        this.controller = controller;
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\nAgenda de Contatos");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Listar contatos");
            System.out.println("3. Buscar contato");
            System.out.println("4. Editar contato");
            System.out.println("5. Remover contato");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    addContact();
                    break;
                case 2:
                    listContacts();
                    break;
                case 3:
                    searchContacts();
                    break;
                case 4:
                    updateContact();
                    break;
                case 5:
                    deleteContact();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void addContact() {
        System.out.print("Nome: ");
        String name = scanner.nextLine();
        System.out.print("Telefone: ");
        String phone = scanner.nextLine();
        System.out.print("E-mail (opcional): ");
        String email = scanner.nextLine();
        try {
            controller.addContact(name, phone, email.isEmpty() ? null : email);
            System.out.println("Contato adicionado com sucesso.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void listContacts() {
        List<AgendaEntity> contacts = controller.getAllContacts();
        if (contacts.isEmpty()) {
            System.out.println("Nenhum contato encontrado.");
        } else {
            contacts.forEach(System.out::println);
        }
    }

    private void searchContacts() {
        System.out.print("Buscar por nome ou e-mail: ");
        String query = scanner.nextLine();
        List<AgendaEntity> results = controller.searchContacts(query);
        if (results.isEmpty()) {
            System.out.println("Nenhum contato encontrado.");
        } else {
            results.forEach(System.out::println);
        }
    }

    private void updateContact() {
        System.out.print("Nome do contato a editar: ");
        String oldName = scanner.nextLine();
        System.out.print("Novo nome: ");
        String newName = scanner.nextLine();
        System.out.print("Novo telefone: ");
        String newPhone = scanner.nextLine();
        System.out.print("Novo e-mail (opcional): ");
        String newEmail = scanner.nextLine();
        try {
            controller.updateContact(oldName, newName, newPhone, newEmail.isEmpty() ? null : newEmail);
            System.out.println("Contato atualizado com sucesso.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void deleteContact() {
        System.out.print("Nome do contato a remover: ");
        String name = scanner.nextLine();
        try {
            controller.deleteContact(name);
            System.out.println("Contato removido com sucesso.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}