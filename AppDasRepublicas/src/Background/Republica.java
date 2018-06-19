package Background;

import java.util.ArrayList;

import java.util.List;



public class Republica {
	public List<Despesa> desp = new ArrayList<Despesa>();
	public List<Pessoa> pessoa = new ArrayList<Pessoa>();
	static double total = 0;
	
	
	
	public int getNumPessoas() {
		return pessoa.size();
	} 
	
	public int getNumCategorias() {
		return desp.size();
	} 

	public static double getTotal() {
		return total;
	}
	
	public boolean addCategoria(String nome) {
		Despesa top = new Despesa();
		top.setNome(nome);
		desp.add(top);
		return true;
		
		
	}
	public boolean addPessoa(Pessoa n) {
		total+= n.getRendimentoMensal();
		pessoa.add(n);
		return true;
	}
	
	
}



