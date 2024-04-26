package com.poo.springjpademo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;

    private String diaSemana;
    private String horario;
    @ManyToOne
    private Professor professor;


    @ManyToOne
    private Curso curso;
    public Disciplina(String nome,String horario, String diaSemana, Professor professor, Curso curso){
        this.nome = nome;
        this.horario = horario;
        this.diaSemana = diaSemana;
        this.professor = professor;
        this.curso = curso;
    }

}
