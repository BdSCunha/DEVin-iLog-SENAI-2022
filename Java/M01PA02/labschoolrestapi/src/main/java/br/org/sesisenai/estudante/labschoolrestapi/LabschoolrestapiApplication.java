package br.org.sesisenai.estudante.labschoolrestapi;

import br.org.sesisenai.estudante.labschoolrestapi.enums.Situacao;
import br.org.sesisenai.estudante.labschoolrestapi.models.Aluno;
import br.org.sesisenai.estudante.labschoolrestapi.services.AlunoService;
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
	public CommandLineRunner demo(AlunoService alunoService) {
		return (args) -> {
			alunoService.save(new Aluno(null, "Bart Simpson", "11-11111-1212", LocalDate.of(2014, 10, 29), 11839750073L, Situacao.IRREGULAR, 3.5, 0));
			alunoService.save(new Aluno(null, "Lisa Simpson", "11-22222-2222", LocalDate.of(2012, 10, 29), 17158947076L, Situacao.ATIVO, 10., 0));
			alunoService.save(new Aluno(null, "Meggie Simpson", "12-20002-2200", LocalDate.of(2019, 10, 29), 63701210020L, Situacao.ATIVO, 9., 0));
			alunoService.save(new Aluno(null, "Milhouse Van Houten", "11-33333-2222", LocalDate.of(2014, 10, 29), 30119137062L, Situacao.ATIVO, 8., 0));
			alunoService.save(new Aluno(null, "Nelson Muntz", "11-44333-4444", LocalDate.of(2007, 10, 29), 95704094015L, Situacao.INATIVO, 2., 0));
		};
	}
}
