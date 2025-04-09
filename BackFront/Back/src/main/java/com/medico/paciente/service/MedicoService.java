package com.medico.paciente.service;

import com.medico.paciente.dto.MedicoDTO;
import com.medico.paciente.entity.Medico;
import com.medico.paciente.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    // Listar todos os médicos
    public List<Medico> listarTodos() {
        return medicoRepository.findAll();
    }

    // Buscar médico por ID
    public Optional<Medico> buscarPorId(Long id) {
        return medicoRepository.findById(id);
    }

    // Cadastrar novo médico
    public Medico salvar(Medico medico) {
        return medicoRepository.save(medico);
    }

    // Atualizar médico
    public Medico atualizar(Long id, Medico medicoAtualizado) {
        Optional<Medico> medicoExistente = medicoRepository.findById(id);

        if (medicoExistente.isPresent()) {
            Medico medico = medicoExistente.get();
            medico.setNome(medicoAtualizado.getNome());
            medico.setEspecialidade(medicoAtualizado.getEspecialidade());
            medico.setCrm(medicoAtualizado.getCrm());
            return medicoRepository.save(medico);
        }

        return null; // ou você pode lançar uma exceção customizada
    }

    // Deletar médico
    public void deletar(Long id) {
        medicoRepository.deleteById(id);
    }

    public Medico criarMedico(MedicoDTO dto) {
        Medico medico = new Medico();
        medico.setNome(dto.getNome());
        medico.setEspecialidade(dto.getEspecialidade());
        medico.setCrm(dto.getCrm());
        return medicoRepository.save(medico);
    }

}
