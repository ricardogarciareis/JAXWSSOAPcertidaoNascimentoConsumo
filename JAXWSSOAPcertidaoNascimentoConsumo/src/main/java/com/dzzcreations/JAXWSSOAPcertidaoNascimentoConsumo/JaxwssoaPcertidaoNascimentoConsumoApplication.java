package com.dzzcreations.JAXWSSOAPcertidaoNascimentoConsumo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JaxwssoaPcertidaoNascimentoConsumoApplication {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(JaxwssoaPcertidaoNascimentoConsumoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JaxwssoaPcertidaoNascimentoConsumoApplication.class, args);
		
		LOGGER.info("Aplicação de CONSUMO DO WS DA CERTIDÃO DE NASCIMENTO inicializada...");
		/*
		try {
			URL url = new URL("http://localhost:8085/service/certidao?wsdl");
			
			QName qname = new QName("http://service.JAXWSSOAPcertidaoNascimento.dzrrcreations.com/", "CertidaoNascimentoImplService");
			
			Service service = Service.create(url, qname);
			
			CertidaoNascimento certidao = service.getPort(CertidaoNascimento.class);
			int idade = certidao.calcularIdade("19/04/1984");
			String diaSemana = certidao.diaSemanaNascimento("19/04/1984");
			System.out.println("A sua idade: " + idade);
			System.out.println("Dia da semana em que nasceu: " + diaSemana);
		} catch(Exception e) {
			LOGGER.error("Erro: " + e);
		}*/
		
		
	}

}
