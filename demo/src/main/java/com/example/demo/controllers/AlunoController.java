package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.aluno;
import com.example.demo.services.AlunoService;

@RestController
@RequestMapping
public class AlunoController {

@Autowired    
private AlunoService alunoService;

@GetMapping("/contar-alunos/")
public Long contarAlunos(){
     return alunoService.contarAlunos();
}

@GetMapping("/buscar-pautas(id)")
public aluno buscarAlunos(@PathVariable Integer id){
    return alunoService.buscarAluno(id);
}

@GetMapping("/listar-alunos")
public List<aluno> listarAlunos(){
    return alunoService.listarAlunos();
}

@DeleteMapping("/deletar-alunos(id)")
public String deletarAlunos(@PathVariable Integer id){
    if (alunoService.deletaraluno(id)) {
        return "aluno excluido com sucesso";
    }
    return "falha ao excluir aluno"; 
}

@PostMapping("/salvar-pauta")
public aluno cadastrarAluno(@RequestBody aluno aluno){
    return alunoService.cadastrarAluno(aluno);
}

public String atualizarAluno(@PathVariable Integer id, @RequestBody aluno aluno){
    if (alunoService.atualizarAluno(id, aluno)!=null){
        return"aluno atualizado com sucesso";
    }
    return "falha na atualização do aluno";
}




}
