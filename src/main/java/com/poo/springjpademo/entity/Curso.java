package com.poo.springjpademo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;

    @ManyToMany
    private List<Disciplina> Materias;

    public Curso(String nome, List<Disciplina> materias){
        this.nome = nome;
        this.Materias = materias;
    }

}
