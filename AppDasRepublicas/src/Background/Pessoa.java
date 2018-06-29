package Background;

import Exce��es.DadosPessoaisIncompletosException;

public class Pessoa {
	private String nome;
	private String email;
	private Double RendimentoMensal;
	
	public Pessoa(String n, String em, double r) {
		if(n.equals("") || n.equals(" ") ) {
			throw new DadosPessoaisIncompletosException("Nome do Morador n�o informado");
		}
		if(em.equals("") || em.equals(" ") ) {
			throw new DadosPessoaisIncompletosException("Email do Morador n�o informado");
		}
		this.nome = n;
		this.email = em;
		this.RendimentoMensal = r;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getRendimentoMensal() {
		return RendimentoMensal;
	}
	public void setRendimentoMensal(Double rendimentoMensal) {
		RendimentoMensal = rendimentoMensal;
	}
}
