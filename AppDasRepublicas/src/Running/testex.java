package Running;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.tools.Tool;

import Background.Pessoa;

public class testex {
	 static boolean gravarDoTxt() {
			FileReader arquivo = null;
			BufferedReader buffer;
			boolean resposta; 
			String nomeArquivo = "moradores.txt";
			try {
				arquivo = new FileReader(nomeArquivo);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			buffer = new BufferedReader(arquivo);
			String line = "";
			try {
				line = buffer.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			do {
				String[] campos = line.split(";");
				double renda = Double.parseDouble(campos[2]);
				Pessoa morador = new Pessoa(campos[0],campos[1],renda);
				
				
				try {
					line = buffer.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}	
			} while (line != null);
			
			JOptionPane.showMessageDialog(null, "Moradores do Arquvio \"" + nomeArquivo + "\" Cadastrados com Sucesso!");
			return true;
		}
	 
	 public static void main(String[] args) {
		 gravarDoTxt();
	}
		
}
