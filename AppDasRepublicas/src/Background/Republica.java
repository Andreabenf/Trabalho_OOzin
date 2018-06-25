package Background;

import java.util.ArrayList;

import java.util.List;



public class Republica {
	public List<Categoria> desp = new ArrayList<Categoria>();
	public List<Pessoa> pessoa = new ArrayList<Pessoa>();
	static double totalRendaMoradores = 0;
	
	
	
	public int getNumPessoas() {
		return pessoa.size();
	} 
	
	public int getNumCategorias() {
		return desp.size();
	} 

	public static double getTotalRendaMoradores() {
		return totalRendaMoradores;
	}
	
	public boolean addCategoria(String nome) {
		Categoria top = new Categoria();
		top.setNome(nome);
		desp.add(top);
		return true;
		
		
	}
	public boolean addPessoa(Pessoa n) {
		totalRendaMoradores+= n.getRendimentoMensal();
		pessoa.add(n);
		return true;
	}
	
	
}



