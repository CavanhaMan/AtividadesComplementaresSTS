package br.edu.iftm.atividadeComplementar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.iftm.atividadeComplementar.domains.Aluno;
import br.edu.iftm.atividadeComplementar.domains.Atividade;
import br.edu.iftm.atividadeComplementar.repositories.AlunoRepository;
import br.edu.iftm.atividadeComplementar.repositories.AtividadeRepository;


@SpringBootApplication
public class AtividadeComplementarStsApplication {

	@Autowired
	AlunoRepository alunoRepository;
	
	AtividadeRepository atividadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(AtividadeComplementarStsApplication.class, args);
	}

	public void run(String... args) throws Exception {
		Aluno al1 = new Aluno((long) 11120, "Seu Creison");
		Aluno al2 = new Aluno((long) 11121, "Mr Beam");

		List<Aluno> alunos = new ArrayList<>();
		alunos.add(al1);
		alunos.add(al2);

		alunoRepository.saveAll(Arrays.asList(al1, al2));
		
		Atividade atv1 = new Atividade(1,"palestra",50,7,10);
		Atividade atv2 = new Atividade(2,"workshop",50,7,10);
		
		List<Atividade> atividades = new ArrayList<>();
		atividades.add(atv1);
		atividades.add(atv2);
		
		atividadeRepository.saveAll(Arrays.asList(atv1, atv2));
	}
}
