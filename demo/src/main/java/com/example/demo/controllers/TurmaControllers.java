package com.example.demo.controllers;

import com.example.demo.services.AlunoService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.turma;
import com.example.demo.services.TurmaServices;

@RestController
@RequestMapping
public class TurmaControllers {
  
    private final AlunoService alunoService;
    @Autowired
    private TurmaService turmaService;
    
    @GetMapping("/contar-turmas")
    public Long contarTurmas(){
       return turmaService.contarTurma();
    }
    
    @GetMapping("/buscar-turmas(id)")
    public turma Service

    TurmaControllers(AlunoService alunoService) {
        this.alunoService = alunoService;
    } buscarTurma(@PathVariable Integer Id){
        return turmaService.buscarTurmas(id);
    }
    
    @GetMapping("/listar-turmas")
    public List <turma> listaTurmas(){
        return alunoService.listarTurma();
    }
    
    @DeleteMapping("/deletar-turm/(id")
    public String deletarTurma(@PathVariable Integer id){
        if (turmaService.deletarTurma(id)) {
            return "turma deletada com sucesso";
        }
        return "falha ao deletar turma";
    }

    public turma cadastrarTurma(@PathVariable Integer id, @RequestBody turma turma){
        return turmaService.cadastrarTurma(turma);
    }

    @PostMapping("/salvar-turma")
   public String atualizarTurma(PathVariable Integer id, @RequestBody turma turma){
    if (turmaService.atualizarTurma(id, turma)!=null){
        return "turma atualizada com sucesso";
    }
    return "falha na atualização da turma";
   }

}

