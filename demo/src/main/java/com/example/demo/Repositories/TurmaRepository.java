package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.turma;

@Repository
public interface TurmaRepository extends JpaRepository <turma, Integer> {

    
} 
