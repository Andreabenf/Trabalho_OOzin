package Background;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	private String nomeCategoria;
	public List<SubCategoria> subs = new ArrayList<SubCategoria>();
	
	public double getTotalDespesas() {
		double totalDespesas = 0;
		for(int i=0; i<subs.size(); i++ ) {
			totalDespesas+=subs.get(i).getValortotal();
		}
		return totalDespesas;
	}
	public void  AddSub(SubCategoria oi) {
		subs.add(oi);
		
	}
	
	public int getSubSize() {
		return subs.size();
	}
	
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNome(String nome) {
		this.nomeCategoria = nome;
	}

}
