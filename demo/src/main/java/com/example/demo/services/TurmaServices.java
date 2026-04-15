package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.TurmaRepository;
import com.example.demo.models.turma;

@Service
public class TurmaServices {

  @Autowired
  private TurmaRepository turmaRepository;

  public Long contarTurma() {
   
    return turmaRepository.count();
  }

  public turma buscarTurma(Integer id) {
    return turmaRepository.findById(id).get();
  }

  public List<turma> listarTurma() {

    return turmaRepository.findAll();
  }

  public Boolean deletarPauta(Integer id) {
    if (turmaRepository.existsById(id)) {
      turmaRepository.deleteById(id);
    }
    return true;
  }
    return false;

  

  public turma cadastrarturma(turma turma) {
    return turmaRepository.save(turma);
  }

  public turma atualizarTurma(Integer id, turma turma) {
    turma turmaRecuperada = buscarTurma(id);
    if (turmaRecuperada != null) {
      turmaRecuperada.setId(id);
      if (turma.getNome() != null) {
        turmaRecuperada.setNome(turma.getNome());
      }

      return turmaRepository.save(turmaRecuperada);

    }
    return null;
  }

}


