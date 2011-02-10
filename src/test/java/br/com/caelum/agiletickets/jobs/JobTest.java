package br.com.caelum.agiletickets.jobs;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.caelum.agiletickets.email.EnviadorEmails;
import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.repository.ListaDeSessoes;

public class JobTest {
	
	
	@Test
	public void deveEnviarEmail(){
		Sessao sessao = new Sessao();
		ListaDeSessoes lista = mock(ListaDeSessoes.class);
		when(lista.proximas()).thenReturn(listaComSessao(sessao));
		EnviadorEmails email = mock(EnviadorEmails.class);
		Job job = new Job(lista, email);
		job.enviaEmail();
		
		verify(email).enviaParaOsParticipantesDa(sessao);
	}
	
	
	private List<Sessao> listaComSessao(Sessao sessao){
		List<Sessao> lista = new ArrayList<Sessao>();
		lista.add(sessao);
		return lista;
	}


}
