package Background;

import Exce��es.DescricaoNaoInformadaException;

public class Despesa {
	private String descricao;
	private double valor;
	
		public Despesa(String d, double v) {
			if(d.equals("")) {
				throw new DescricaoNaoInformadaException("Dado da despesa n�o foi informado");
			}
			
			this.descricao = d;
			this.valor = v;
		}
	public String getDescricao() {
		
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getValor() {
		return valor;
	}
	
	
}

