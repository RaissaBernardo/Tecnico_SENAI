package com.extra.sala.service;


import com.extra.sala.entity.Aviso;
import com.extra.sala.repository.AvisoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvisoService {
    private final AvisoRepository repository;

    public AvisoService(AvisoRepository repository) {
        this.repository = repository;
    }

    public List<Aviso> listar() {
        return repository.findAll();
    }

    public Aviso salvar(Aviso aviso) {
        return repository.save(aviso);
    }

    public Aviso editar(Long id, Aviso novo) {
        Aviso existente = repository.findById(id).orElseThrow();
        existente.setTitulo(novo.getTitulo());
        existente.setDescricao(novo.getDescricao());
        existente.setAutor(novo.getAutor());
        return repository.save(existente);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public Aviso buscarPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }
}
