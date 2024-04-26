package com.poo.springjpademo;

import com.poo.springjpademo.entity.Curso;
import com.poo.springjpademo.entity.Disciplina;
import com.poo.springjpademo.entity.Professor;
import com.poo.springjpademo.repository.CursoRepository;
import com.poo.springjpademo.repository.DisciplinaRepository;
import com.poo.springjpademo.repository.ProfessorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

import javax.swing.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class SpringjpademoApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringjpademoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringjpademoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProfessorRepository repository, DisciplinaRepository disciplinaRepository, CursoRepository cursoRepository) {

		return (args) -> {
			System.out.println("Criando classes de horário, professores e curso de engenharia de software");
			Professor lea = repository.save(new Professor("Leanderson"));
			Professor mar = repository.save(new Professor("Marcelo"));
			Professor lei = repository.save(new Professor("Leila"));
			Professor van = repository.save(new Professor("Vanessa"));
			Professor ana = repository.save(new Professor("Ana Paula"));
			Professor rafa = repository.save(new Professor("Rafael"));

			Curso engSoft = cursoRepository.save(new Curso("Engenharia de Software"));
			Curso sistemasInformacao = cursoRepository.save(new Curso("Sistemas de informação"));

			Disciplina horario1 = disciplinaRepository.save(new Disciplina("POO II",  "20:50 - 22:30", "QUA",lea, engSoft));

			Disciplina horario2 =disciplinaRepository.save(new Disciplina("POO II",  "18:50 - 20:30", "SEX",lea, engSoft));

			Disciplina horario3 =disciplinaRepository.save(new Disciplina("SOP",  "18:50 - 20:30", "TER",mar, engSoft));
			Disciplina horario4 =disciplinaRepository.save(new Disciplina("SOP",  "20:50 - 22:30", "SEX",mar, engSoft));


			Disciplina horario5 =disciplinaRepository.save(new Disciplina("VIVEX III",  "19:50 - 22:30", "SEG",lei, engSoft));

			Disciplina horario6 =disciplinaRepository.save(new Disciplina("ECSI",  "19:50 - 20:30", "QUA",van, engSoft));
			Disciplina horario7 =disciplinaRepository.save(new Disciplina("ECSI",  "19:50 - 20:30", "QUI",van, engSoft));

			Disciplina horario8 =disciplinaRepository.save(new Disciplina("EIXO IV",  "08:30 - 10:15", "SAB",ana, engSoft));

			List<Disciplina> horarios = new ArrayList<>();
			horarios.add(horario1);
			horarios.add(horario2);
			horarios.add(horario3);
			horarios.add(horario4);
			horarios.add(horario5);
			horarios.add(horario6);
			horarios.add(horario7);
			horarios.add(horario8);


			/*
			* Salvar disciplinas pro curso e professores para as disciplinas
			* */




			Disciplina horarioSist1 = disciplinaRepository.save(new Disciplina("APSI I", "20:30 - 22:30", "TER", rafa, sistemasInformacao));
			Disciplina horarioSist2 = disciplinaRepository.save(new Disciplina("POO II",  "20:50 - 22:30", "QUA",lea, sistemasInformacao));

			Disciplina horarioSist3 =disciplinaRepository.save(new Disciplina("POO II",  "18:50 - 20:30", "SEX",lea, sistemasInformacao));

			Disciplina horarioSist4 =disciplinaRepository.save(new Disciplina("SOP",  "18:50 - 20:30", "TER",mar, sistemasInformacao));
			Disciplina horarioSist5 =disciplinaRepository.save(new Disciplina("SOP",  "20:50 - 22:30", "SEX",mar, sistemasInformacao));


			Disciplina horarioSist6 =disciplinaRepository.save(new Disciplina("VIVEX III",  "19:50 - 22:30", "SEG",lei, sistemasInformacao));

			Disciplina horarioSist7 =disciplinaRepository.save(new Disciplina("ECSI",  "19:50 - 20:30", "QUA",van, sistemasInformacao));
			Disciplina horarioSist8 =disciplinaRepository.save(new Disciplina("ECSI",  "19:50 - 20:30", "QUI",van, sistemasInformacao));

			Disciplina horarioSist9 =disciplinaRepository.save(new Disciplina("EIXO IV",  "08:30 - 10:15", "SAB",ana, sistemasInformacao));
			List<Disciplina> horasSist =  new ArrayList<>();
			horasSist.add(horarioSist1);
			horasSist.add(horarioSist2);
			horasSist.add(horarioSist3);
			horasSist.add(horarioSist4);
			horasSist.add(horarioSist5);
			horasSist.add(horarioSist1);
			horasSist.add(horarioSist6);
			horasSist.add(horarioSist7);
			horasSist.add(horarioSist8);
			horasSist.add(horarioSist9);




			List<Disciplina> engSoftware = disciplinaRepository.findDisciplinaByCurso(engSoft);
			System.out.println("Imprimindo todos os horarios de engenharia de software!");
			engSoftware.forEach(System.out::println);
			System.out.println("--------------------------------------------------------------");
			System.out.println("Imprimindo todos os horarios de Sistemas de informação!");
			List<Disciplina> sistemasInfo = disciplinaRepository.findDisciplinaByCurso(sistemasInformacao);
			sistemasInfo.forEach(System.out::println);

		};


	}

}
