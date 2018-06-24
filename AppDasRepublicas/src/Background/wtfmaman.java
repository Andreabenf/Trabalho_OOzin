package Background;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class wtfmaman {
	
	
	public static ArrayList<String> getLinhasArquivo( File file ) throws FileNotFoundException, IOException{
	    ArrayList<String> linhas;
	        
	    try (BufferedReader leitor = new BufferedReader( new FileReader(file) )) {
	       linhas = new ArrayList<>();
	       String linha = "";
	            
	       while( (linha = leitor.readLine()) != null ){
	          if( linha.length() > 0 )
	              linhas.add(linha);
	       }
	    }
	    return linhas;
	}
	
	public static void main(String[] args) {
		ArrayList<String> linhasDoArquivo = null;
		try {
			linhasDoArquivo = getLinhasArquivo(new File("C:\\Users\\andre\\Documents\\Agora vai\\AppDasRepublicas"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
