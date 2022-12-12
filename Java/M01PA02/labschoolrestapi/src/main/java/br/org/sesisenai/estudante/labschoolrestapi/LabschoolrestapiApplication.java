package br.org.sesisenai.estudante.labschoolrestapi;

import br.org.sesisenai.estudante.labschoolrestapi.enums.Estado;
import br.org.sesisenai.estudante.labschoolrestapi.enums.Experiencia;
import br.org.sesisenai.estudante.labschoolrestapi.enums.Formacao;
import br.org.sesisenai.estudante.labschoolrestapi.enums.Situacao;
import br.org.sesisenai.estudante.labschoolrestapi.models.Aluno;
import br.org.sesisenai.estudante.labschoolrestapi.models.Pedagogo;
import br.org.sesisenai.estudante.labschoolrestapi.models.Professor;
import br.org.sesisenai.estudante.labschoolrestapi.services.AlunoService;
import br.org.sesisenai.estudante.labschoolrestapi.services.PedagogoService;
import br.org.sesisenai.estudante.labschoolrestapi.services.ProfessorService;
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
	public CommandLineRunner demo(AlunoService alunoService, ProfessorService professorService, PedagogoService pedagogoService) {
		return (args) -> {
			alunoService.save(new Aluno(null, "Bart Simpson", "11-11111-1212", LocalDate.of(2014, 10, 29), 11839750073L, Situacao.IRREGULAR, 3.5, 0));
			alunoService.save(new Aluno(null, "Lisa Simpson", "11-22222-2222", LocalDate.of(2012, 10, 29), 17158947076L, Situacao.ATIVO, 10., 0));
			alunoService.save(new Aluno(null, "Meggie Simpson", "12-20002-2200", LocalDate.of(2019, 10, 29), 63701210020L, Situacao.ATIVO, 9., 0));
			alunoService.save(new Aluno(null, "Milhouse Van Houten", "11-33333-2222", LocalDate.of(2014, 10, 29), 30119137062L, Situacao.ATIVO, 8., 0));
			alunoService.save(new Aluno(null, "Nelson Muntz", "11-44333-4444", LocalDate.of(2007, 10, 29), 95704094015L, Situacao.INATIVO, 2., 0));

			professorService.save(new Professor(null, "Walter White", "14-22998-1882", LocalDate.of(1982, 10, 30), 40539019011L, Formacao.MESTRADO, Experiencia.FULL_STACK, Estado.ATIVO));
			professorService.save(new Professor(null, "Jesse Pinkman", "44-11111-1992", LocalDate.of(1997, 10, 30), 96107295097L, Formacao.GRADUACAO_INCOMPLETA, Experiencia.BACK_END, Estado.ATIVO));
			professorService.save(new Professor(null, "Hank Schrader", "44-11111-1002", LocalDate.of(1984, 10, 30), 70685977005L, Formacao.MESTRADO, Experiencia.FULL_STACK, Estado.ATIVO));
			professorService.save(new Professor(null, "Gustavo Fring", "44-11001-1002", LocalDate.of(1977, 10, 30), 57408927085L, Formacao.GRADUACAO_COMPLETA, Experiencia.FRONT_END, Estado.INATIVO));
			professorService.save(new Professor(null, "Saul Goodman", "44-11998-1882", LocalDate.of(1980, 10, 30), 86940162062L, Formacao.MESTRADO, Experiencia.FULL_STACK, Estado.ATIVO));

			pedagogoService.save(new Pedagogo(null, "John Snow", "11-67333-4454", LocalDate.of(2000, 10, 30), 62316840086L, 0));
			pedagogoService.save(new Pedagogo(null, "Sansa Stark", "22-22333-4454", LocalDate.of(2004, 10, 30), 49850253053L, 0));
			pedagogoService.save(new Pedagogo(null, "Tyrion Lannister", "33-77333-4454", LocalDate.of(1990, 10, 30), 39125106015L, 0));
			pedagogoService.save(new Pedagogo(null, "Sandor Clegane", "11-33333-2222", LocalDate.of(1995, 10, 30), 89089606009L, 0));
		};
	}
}
