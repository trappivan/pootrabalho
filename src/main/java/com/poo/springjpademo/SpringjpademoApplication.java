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

			Disciplina horario1 = disciplinaRepository.save(new Disciplina("POO II",  "20:50 - 22:30", "QUA",lea));

			Disciplina horario2 =disciplinaRepository.save(new Disciplina("POO II",  "18:50 - 20:30", "SEX",lea));
			lea.setDisciplina(List.of(horario2));
			repository.save(lea);
			Disciplina horario3 =disciplinaRepository.save(new Disciplina("SOP",  "18:50 - 20:30", "TER",mar));
			Disciplina horario4 =disciplinaRepository.save(new Disciplina("SOP",  "20:50 - 22:30", "SEX",mar));


			Disciplina horario5 =disciplinaRepository.save(new Disciplina("VIVEX III",  "19:50 - 22:30", "SEG",lei));

			Disciplina horario6 =disciplinaRepository.save(new Disciplina("ECSI",  "19:50 - 20:30", "QUA",van));
			Disciplina horario7 =disciplinaRepository.save(new Disciplina("ECSI",  "19:50 - 20:30", "QUI",van));

			Disciplina horario8 =disciplinaRepository.save(new Disciplina("EIXO IV",  "08:30 - 10:15", "SAB",ana));

			List<Disciplina> horarios = new ArrayList<>();
			horarios.add(horario1);
			horarios.add(horario2);
			horarios.add(horario3);
			horarios.add(horario4);
			horarios.add(horario5);
			horarios.add(horario6);
			horarios.add(horario7);
			horarios.add(horario8);

			Curso engSoft = cursoRepository.save(new Curso("Engenharia de Software", horarios));
			/*
			* Salvar disciplinas pro curso e professores para as disciplinas
			* */


			System.out.println("Criando classes de horário, professores e curso de sistemas de informação" + engSoft);

			Disciplina horarioSist1 = disciplinaRepository.save(new Disciplina("APSI I", "20:30 - 22:30", "TER", rafa));

			List<Disciplina> horasSist =  new ArrayList<>();
			horasSist.add(horario5);
			horasSist.add(horario3);
			horasSist.add(horario6);
			horasSist.add(horario1);
			horasSist.add(horario7);
			horasSist.add(horarioSist1);
			horasSist.add(horario2);
			horasSist.add(horario4);
			horasSist.add(horario8);

			Curso sistemasInformacao = cursoRepository.save(new Curso("Sistemas de informação",horasSist));

			System.out.println("Curso sistemas de informação horario: "+sistemasInformacao);
			/*
			repository.save(new Professor("Leanderson"));
			repository.save(new Professor("Paulo"));
			repository.save(new Professor("Vanessa"));
			log.info("-------------------------------");
			log.info(" findAll");
			for(var p : repository.findAll()){
				log.info(p.toString());
			}
			log.info("-------------------------------");
			log.info(" findAllOrderByNomeDesc");
			for(var p : repository.findAll(Sort.by(Sort.Direction.DESC,"nome"))){
				log.info(p.toString());
			}
			log.info("-------------------------------");
			log.info(" findById");
			var p = repository.findById(1L);
			log.info(p.toString());
			log.info("-------------------------------");
			log.info(" findByINome");
			 p = repository.findByNome("Vanessa");
			log.info(p.toString());
			p = repository.findById(1L);
			disciplinaRepository.save(new Disciplina("Poo 1", p.get()));
			disciplinaRepository.save(new Disciplina("Poo 2", p.get()));
			disciplinaRepository.save(new Disciplina("PCE", p.get()));

			p = repository.findById(2L);
			disciplinaRepository.save(new Disciplina("IA", p.get()));
			disciplinaRepository.save(new Disciplina("Redes", p.get()));
			log.info("-------------------------------");
			log.info(" Disciplinas");
			for(var d : disciplinaRepository.findAll()){
				log.info(d.toString());
			}
			p = repository.findById(3L);
			log.info("-------------------------------");
			log.info(" Disciplinas do professor paulo");
			for(var d : disciplinaRepository.findAllByProfessor(p.get())){
				log.info(d.toString());
			}

			 */
		};


	}

}
