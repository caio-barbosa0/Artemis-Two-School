package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Repositories.AlunoRepository;
import com.example.demo.models.aluno;

@Service
public class AlunoService {


    private AlunoRepository alunoRepository;

    public Long contarAlunos(){
       return alunoRepository.count();

    } 
    
    public aluno buscarAluno(Integer id) {
        return alunoRepository.findById(id).get();

    }
     
    public List<aluno> listarAlunos(){

        return alunoRepository.findAll();
    }
    
    public boolean deletaraluno (Integer id){

        if (alunoRepository.existsById(id)) {
            
            return true;
        }
        return false;
    }

    public aluno cadastrarAluno(aluno aluno){
        return alunoRepository.save(aluno);

    }

    public aluno atualizarAluno(Integer id, aluno aluno) {
        aluno AlunoRecuperado = buscarAluno(id);
        if (AlunoRecuperado != null){
            AlunoRecuperado.setId(id);
            if(aluno.getNome() !=null){
            AlunoRecuperado.setNome(aluno.getNome());
        
        }
            if (aluno.getDataNascimento() !=null){
                AlunoRecuperado.setDataNascimento
                (aluno.getDataNascimento());
            }
                return alunoRepository.save(AlunoRecuperado);
                
 }
  
  return null;



}}
