package com.dzzcreations.JAXWSSOAPcertidaoNascimentoConsumo.controller;

import java.net.URL;
import java.util.Calendar;
import java.util.Date;

import javax.xml.namespace.QName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dzrrcreations.JAXWSSOAPcertidaoNascimentoConsumo.service.CertidaoNascimento;
import com.dzzcreations.JAXWSSOAPcertidaoNascimentoConsumo.model.Nascimento;

import jakarta.validation.Valid;
import jakarta.xml.ws.Service;

@Controller
public class MainController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger( MainController.class);

	
	@GetMapping("/")
	public String mostrarEcra(@ModelAttribute("nascimento") Nascimento nascimento, Model model) {
		if (!model.containsAttribute("nascimento")) {
			model.addAttribute("nascimento", nascimento);
		}
		return "index";
	}
	
	@PostMapping("/")
	public String calcular(@ModelAttribute("nascimento") @Valid Nascimento nascimento, 
			  BindingResult result, 
			  RedirectAttributes redirectAttrs, 
			  Model model) {
		if (!result.hasErrors()) {		
			Date data = nascimento.getDataNascimento();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(data);
			String dataStr = calendar.get(Calendar.DAY_OF_MONTH) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.YEAR);
			try {
				URL url = new URL("http://localhost:8085/service/certidao?wsdl");
				QName qname = new QName("http://service.JAXWSSOAPcertidaoNascimento.dzrrcreations.com/", "CertidaoNascimentoImplService");
				Service service = Service.create(url, qname);
				
				CertidaoNascimento certidao = service.getPort(CertidaoNascimento.class);
				nascimento.setIdade(certidao.calcularIdade(dataStr));
				nascimento.setDiaSemana(certidao.diaSemanaNascimento(dataStr));
				System.out.println("A sua idade: " + nascimento.getIdade());
				System.out.println("Dia da semana em que nasceu: " + nascimento.getDiaSemana());
			} catch(Exception e) {
				LOGGER.error("Erro: " + e);
			}
		}
		redirectAttrs.addFlashAttribute("nascimento", nascimento);
		return "index";
	}
}
