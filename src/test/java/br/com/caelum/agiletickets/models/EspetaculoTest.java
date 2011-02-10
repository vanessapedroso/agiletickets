package br.com.caelum.agiletickets.models;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Test;

public class EspetaculoTest {

	@Test
	public void deveCriar1Sessao(){
		Espetaculo e = new Espetaculo();
		LocalDate inicio = new LocalDate(2011,02,01);
		List<Sessao> sessoes = e.criaSessoes(inicio, inicio, new LocalTime(), Periodicidade.DIARIA);
		
		assertEquals(1, sessoes.size());
		assertEquals(inicio.getDayOfYear(),sessoes.get(0).getInicio().getDayOfYear());
	}
	
	@Test
	public void deveCriarSessoesDiarias(){
		Espetaculo e = new Espetaculo();
		LocalDate inicio = new LocalDate(2011,2,1);
		LocalDate fim = new LocalDate(2011,2,3);
		List<Sessao> sessoes = e.criaSessoes(inicio, fim, new LocalTime(), Periodicidade.DIARIA);
		
		assertEquals(3, sessoes.size());
		assertEquals(3, sessoes.get(2).getInicio().getDayOfMonth());
	}

	@Test
	public void deveCriarSessoesSemanais(){
		Espetaculo e = new Espetaculo();
		LocalDate inicio = new LocalDate(2011,2,9);
		LocalDate fim = new LocalDate(2011,2,28);
		List<Sessao> sessoes = e.criaSessoes(inicio, fim, new LocalTime(), Periodicidade.SEMANAL);
		
		assertEquals(3, sessoes.size());
		assertEquals(23,sessoes.get(sessoes.size()-1).getInicio().getDayOfMonth());
	}
}
