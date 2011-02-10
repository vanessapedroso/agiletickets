package br.com.caelum.agiletickets.repository;

import java.util.List;

import br.com.caelum.agiletickets.models.Sessao;

public interface ListaDeSessoes {

	List<Sessao> proximas();
	
}
