package br.com.jbank.motor_risco;

import br.com.jbank.motor_risco.domain.Cliente;
import br.com.jbank.motor_risco.repository.ClienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MotorRiscoApplication {

	public static void main(String[] args) {

        SpringApplication.run(MotorRiscoApplication.class, args);
	}

    @Bean
    public CommandLineRunner iniciarDados(ClienteRepository clienteRepository){
        return args ->{
            Cliente cliente1 = new Cliente();
            cliente1.setNome("Alice (Confiável)");
            cliente1.setCpf("11111111111");
            cliente1.setNumeroConta("1001");
            cliente1.setConfiavel(true);

            Cliente cliente2 = new Cliente();
            cliente2.setNome("Bob (Confiável)");
            cliente2.setCpf("22222222222");
            cliente2.setNumeroConta("1002");
            cliente2.setConfiavel(true);

            Cliente cliente3 = new Cliente();
            cliente3.setNome("Charlie (Não Confiável)");
            cliente3.setCpf("33333333333");
            cliente3.setNumeroConta("1003");
            cliente3.setConfiavel(false);

            clienteRepository.saveAll(List.of(cliente1, cliente2, cliente3));
        };



    }

}
