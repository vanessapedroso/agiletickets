package br.com.caelum.agiletickets.jobs;

import java.util.List;

import br.com.caelum.agiletickets.email.EnviadorEmails;
import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.repository.ListaDeSessoes;

public class Job {


	private ListaDeSessoes lista;
	private EnviadorEmails email;
	
	

	
	public Job(ListaDeSessoes lista, EnviadorEmails email) {
		this.lista = lista;
		this.email = email;
	}




	public void enviaEmail() {
		List<Sessao> sessoes = lista.proximas();
		for(Sessao sessao:sessoes){
			email.enviaParaOsParticipantesDa(sessao);
		}
	}

	
}
