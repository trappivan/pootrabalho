package com.poo.springjpademo.repository;

import com.poo.springjpademo.entity.Curso;
import com.poo.springjpademo.entity.Disciplina;
import com.poo.springjpademo.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    List<Curso> findAllById(Curso curso);

}