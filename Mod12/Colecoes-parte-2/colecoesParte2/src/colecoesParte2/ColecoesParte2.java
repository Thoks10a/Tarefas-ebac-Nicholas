package colecoesParte2;
import java.util.Scanner;

public class ColecoesParte2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o nome e o gênero em conjunto separado por (,),(Carlos-M,Ana-F): ");
		String nomesGenero = sc.nextLine();
		String[] nomesGeneroSplit = nomesGenero.split(",");
		//Quantidade de Masculino e Feminino
		int quantM = 0,quantF = 0;
		for (int i = 0;i<nomesGeneroSplit.length;i++) {
        	if (nomesGeneroSplit[i].endsWith("-M")) {
        		quantM = quantM + 1;
            } else if (nomesGeneroSplit[i].endsWith("-F")) {
            	quantF = quantF + 1;
            };
        };
		String[] masculinos = new String[quantM];
		String[] femininos = new String[quantF];
		//Adciona no grupo correto
		int countM = 0;
		int countF = 0;
        for (int i = 0;i<nomesGeneroSplit.length;i++) {
        	if (nomesGeneroSplit[i].endsWith("-M")) {
            	masculinos[countM] = nomesGeneroSplit[i];
            	countM = countM + 1;
            } else if (nomesGeneroSplit[i].endsWith("-F")) {
            	femininos[countF] = nomesGeneroSplit[i];
            	countF = countF + 1;
            };
        };
        
        for (int i = 0;i<masculinos.length;i++) {
        	System.out.println("Nomes masculinos: " + masculinos[i]);
        };
        for (int i = 0;i<femininos.length;i++) {
            System.out.println("Nomes femininos: " + femininos[i]);
        };
        
        
        
		

	}

}
