package br.com.caelum.agiletickets.email;

import br.com.caelum.agiletickets.models.Sessao;

public interface EnviadorEmails {

	boolean enviaParaOsParticipantesDa(Sessao sessao);
	
}
