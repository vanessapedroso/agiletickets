package br.com.caelum.agiletickets.models;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class SessaoTest {


	@Test
	public void deveVender1ingressoSeHa2vagas() throws Exception {
		Sessao sessao = new Sessao();
        sessao.setTotalIngressos(2);

        Assert.assertTrue(sessao.podeReservar(1));
	}

	@Test
	public void naoDeveVender3ingressoSeHa2vagas() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(2);

		Assert.assertFalse(sessao.podeReservar(3));
	}

	@Test
	public void reservarIngressosDeveDiminuirONumeroDeIngressosDisponiveis() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(5);

		sessao.reserva(3);
		Assert.assertEquals(2, sessao.getIngressosDisponiveis().intValue());
	}
	
	@Test
	public void reservarUltimoIngressoDisponivel() throws Exception {
	    Sessao sessao =new Sessao();
	    sessao.setTotalIngressos(1);
	    Assert.assertTrue(sessao.podeReservar(1));
	    
	}

	@Test
	public void reservarQuantidadeNegativaIngresso() throws Exception {
	    Sessao sessao =new Sessao();
	    sessao.setTotalIngressos(1);
	    Assert.assertFalse(sessao.podeReservar(-2));
	    
	}
	
	@Test
	public void deveDarDescontoParaEstudante() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setPreco(new BigDecimal(20));
		sessao.concedeDesconto(Estudante.SIM);
		
		Assert.assertEquals(new BigDecimal(10), sessao.getPreco());		
	}

}
