package br.org.sesisenai.estudante.labschoolrestapi;

import br.org.sesisenai.estudante.labschoolrestapi.dtos.AlunoDTO;
import br.org.sesisenai.estudante.labschoolrestapi.models.Pessoa;
import br.org.sesisenai.estudante.labschoolrestapi.services.PessoaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class LabschoolrestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabschoolrestapiApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PessoaService pessoaService) {
		return (args) -> {
			pessoaService.save(new Pessoa(null, "Bart Simpson", "11-11111-1212", LocalDate.of(2014, 10, 29), 11839750073L, Pessoa.EstadoAluno.IRREGULAR, 3.5, 0, null, null, null));
			pessoaService.save(new Pessoa(null, "Lisa Simpson", "11-22222-2222", LocalDate.of(2012, 10, 29), 17158947076L, Pessoa.EstadoAluno.ATIVO, 10., 0, null, null, null));
			pessoaService.save(new Pessoa(null, "Meggie Simpson", "12-20002-2200", LocalDate.of(2019, 10, 29), 63701210020L, Pessoa.EstadoAluno.ATIVO, 9., 0, null, null, null));
			pessoaService.save(new Pessoa(null, "Milhouse Van Houten", "11-33333-2222", LocalDate.of(2014, 10, 29), 30119137062L, Pessoa.EstadoAluno.ATIVO, 8., 0, null, null, null));
			pessoaService.save(new Pessoa(null, "Nelson Muntz", "11-44333-4444", LocalDate.of(2007, 10, 29), 95704094015L, Pessoa.EstadoAluno.INATIVO, 2., 0, null, null, null));

			pessoaService.save(new Pessoa(null, "Walter White", "14-22998-1882", LocalDate.of(1982, 10, 30), 40539019011L, null, null, null, Pessoa.EstadoProfessor.ATIVO, Pessoa.ExperienciaProfessor.FULL_STACK, Pessoa.FormacaoProfessor.MESTRADO));
			pessoaService.save(new Pessoa(null, "Jesse Pinkman", "44-11111-1992", LocalDate.of(1997, 10, 30), 96107295097L, null, null, null, Pessoa.EstadoProfessor.ATIVO, Pessoa.ExperienciaProfessor.BACK_END, Pessoa.FormacaoProfessor.GRADUACAO_INCOMPLETA));
			pessoaService.save(new Pessoa(null, "Hank Schrader", "44-11111-1002", LocalDate.of(1984, 10, 30), 70685977005L, null, null, null, Pessoa.EstadoProfessor.ATIVO, Pessoa.ExperienciaProfessor.FULL_STACK, Pessoa.FormacaoProfessor.MESTRADO));
			pessoaService.save(new Pessoa(null, "Gustavo Fring", "44-11001-1002", LocalDate.of(1977, 10, 30), 57408927085L, null, null, null, Pessoa.EstadoProfessor.INATIVO, Pessoa.ExperienciaProfessor.FRONT_END, Pessoa.FormacaoProfessor.GRADUACAO_COMPLETA));
			pessoaService.save(new Pessoa(null, "Saul Goodman", "44-11998-1882", LocalDate.of(1980, 10, 30), 86940162062L, null, null, null, Pessoa.EstadoProfessor.ATIVO, Pessoa.ExperienciaProfessor.FULL_STACK, Pessoa.FormacaoProfessor.MESTRADO));

			pessoaService.save(new Pessoa(null, "John Snow", "11-67333-4454", LocalDate.of(2000, 10, 30), 62316840086L, null, null, 0, null, null, null));
			pessoaService.save(new Pessoa(null, "Sansa Stark", "22-22333-4454", LocalDate.of(2004, 10, 30), 49850253053L, null, null, 0, null, null, null));
			pessoaService.save(new Pessoa(null, "Tyrion Lannister", "33-77333-4454", LocalDate.of(1990, 10, 30), 39125106015L, null, null, 0, null, null, null));
			pessoaService.save(new Pessoa(null, "Sandor Clegane", "11-33333-2222", LocalDate.of(1995, 10, 30), 89089606009L, null, null, 0, null, null, null));
		};
	}

}
