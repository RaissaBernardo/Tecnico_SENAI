package com.agenda.fabiana.entity;

public class AgendaEntity {
    private String name;
    private String phone;
    private String email;

    public AgendaEntity(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AgendaEntity other = (AgendaEntity) obj;
        return name.equals(other.name) && phone.equals(other.phone);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + phone.hashCode();
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", Email: " + (email != null ? email : "N/A");
    }
}