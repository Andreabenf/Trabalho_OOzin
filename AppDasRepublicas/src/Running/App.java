package Running;


import javax.swing.JOptionPane;

import Background.Pessoa;
import Background.Republica;
import Background.SubRendimento;

public class App {
	
	static Republica rep = new Republica();
	
	public static void main (String[] args) {
		
		
	
		Object[] opcoesPossiveis = {"--- Selecione uma opcao ---",
									"Cadastrar Morador", 
				                    "Cadastrar Uma nova Categoria", 
				                    "Cadastrar Despesas",
				                    "Calcular Divis�o",
				                    "Sair"};
		Object opcaoDefault = opcoesPossiveis[0];
		Object opcaoSelecionada = null;
		do {
			opcaoSelecionada = JOptionPane.showInputDialog(null, 
											"Selecione uma das opcoes a seguir:", 
											"App das Republicas", 
											JOptionPane.QUESTION_MESSAGE, 
											null, 
											opcoesPossiveis, 
											opcaoDefault);
			switch ((String) opcaoSelecionada) {
			case "Cadastrar Morador":
				  cadastrarMorador();
			    break;
			    	
			case "Cadastrar Uma nova Categoria":
					cadastrarCategoria();
				break;
				
			case "Cadastrar Despesas":
				cadastrarDespesas();
			break;
			
			case "total":
				JOptionPane.showConfirmDialog(null, rep.getTotalRendaMoradores());
			break;
			
			case "Calcular Divis�o":
				calcularDivisao();
			break;
			

			default:
				break;
			}
		} while (!((String)opcaoSelecionada).equals((String)opcoesPossiveis[6]));
	}

	
	private static boolean cadastrarCategoria() {
		String nomeCat = JOptionPane.showInputDialog("Informe a nova categoria:");
		rep.addCategoria(nomeCat);
		return true;
		
	}
	private static void cadastrarDespesas() {
		
		String[] nomesCategoria = new String[rep.desp.size()];
		for (int i=0; i<rep.desp.size(); i++) {
			nomesCategoria[i] = rep.desp.get(i).getNomeCategoria();
		}
		
		String nomeCategoriaSelecionada = (String)JOptionPane.showInputDialog(null, 
				                                     "Escolha Categoria da Despesa", 
				                                     "Menu de Categorias", 
        				                             JOptionPane.INFORMATION_MESSAGE, 
		        		                             null, 
				                                     nomesCategoria, 
				                                     null);
		
		int indexCategoria = pesquisarContribuinte(nomeCategoriaSelecionada);
		String descricaoSubRendiemnto = JOptionPane.showInputDialog("Informe a descricao do gasto (Categoria " +  rep.desp.get(indexCategoria).getNomeCategoria() + ")");
		Double valorSubRendimento =Double.parseDouble( JOptionPane.showInputDialog("Informe o valor do gasto (Categoria " +  rep.desp.get(indexCategoria).getNomeCategoria() + ")"));
		SubRendimento oi = new SubRendimento(descricaoSubRendiemnto, valorSubRendimento);
		rep.desp.get(indexCategoria).AddSub(oi);
	}



	private static int pesquisarContribuinte(String nomedCategoria) {
		int resp = 0;
		for (int i=0; i<rep.desp.size(); i++) {
			if( rep.desp.get(i).getNomeCategoria().equals(nomedCategoria)) {
				 resp = i;
				
			}
		}
		return resp;
	}


	private  static boolean cadastrarMorador() {
	
		
		String nomeMorador = JOptionPane.showInputDialog("Informe o nome do morador:");
		String emailMorador = JOptionPane.showInputDialog("Informe o e-mail do morador:");
		Double rendMorador =Double.parseDouble( JOptionPane.showInputDialog("Informe a renda do morador:"));
		Pessoa morador = new Pessoa(nomeMorador,emailMorador,rendMorador);
		rep.addPessoa(morador);
		return true;
		
		
	
	}
	
	private static boolean calcularDivisao() {
		String mensagem ="";
		Object[] ops = {"Normal",
		"Proporcional"};
		int escolhida = JOptionPane.showOptionDialog(null, "Qual tipo de media?", "Opcoes de m�dia", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, ops,ops[0] );
		double tot = 0 ;
	
		for(int i = 0; i<rep.getNumCategorias();i++ ) {
			tot+=rep.desp.get(i).getTotalDespesas();
		}
		
		if(escolhida == 0){
		
			double Valor = (tot/rep.getNumPessoas());
		
			for(int i = 0; i<rep.getNumPessoas();i++ ) {
				mensagem += (rep.pessoa.get(i).getNome() + " deve pagar " + Valor + "\n");
			}
			  
		}
		else {
			
			for(int i = 0; i<rep.getNumPessoas();i++ ) {
				double Valor;
				Valor = ((rep.pessoa.get(i).getRendimentoMensal()/rep.getTotalRendaMoradores()) * tot); 
				mensagem += (rep.pessoa.get(i).getNome() + " deve pagar " + Valor  + "Reais\n");
			}
		}
		JOptionPane.showMessageDialog(null, mensagem);
		return true;
	}

}
	

