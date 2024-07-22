package nomesOrdenacao;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class nomeOrdenacaoVetor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//ArrayList arr = new ArrayList();
		
		
		System.out.println("====================================================");
		System.out.println("===========================Primeira Parte=========================");
		System.out.println("Digite os nomes, separando por vírgula (Joao,Carlos): ");
		String nomes = sc.nextLine();
		String[] nomesSplit = nomes.split(",");
		/*for(String nomesSplitPrint : nomesSplit) {
			System.out.println("Nomes: "+nomesSplitPrint);
		};*/
		List<String> list = Arrays.asList(nomesSplit);
		ArrayList<String> nomeArray = new ArrayList<>(list);
		for(int i = 0;i<nomeArray.size();i++){
			System.out.println("Lista Nomes: "+nomeArray.get(i));
		};
		System.out.println("====================================================");
		Collections.sort(nomeArray);
		for(int i = 0;i<nomeArray.size();i++){
			System.out.println("Lista Nomes Ordenada: "+nomeArray.get(i));
		};
		//Segunda Parte
		System.out.println("====================================================");
		System.out.println("=======================Segunda Parte=============================");

		System.out.println("Digite o nome o gênero(Carlos-M,Ana-F): ");
		String nomesGenero = sc.nextLine();
		String[] nomesGeneroSplit = nomesGenero.split(",");
		
		List<String> nomesMasculinos = new ArrayList<>();
        List<String> nomesFeminino = new ArrayList<>();
        
        for (String entrada : nomesGeneroSplit) {
            if (entrada.endsWith("-M")) {
            	nomesMasculinos.add(entrada.substring(0, entrada.length() - 2));
            } else if (entrada.endsWith("-F")) {
            	nomesFeminino.add(entrada.substring(0, entrada.length() - 2));
            };
        };
        
        /*for (int i = 0;i<nomesGeneroSplit.length;i++) {
        	if (nomesGeneroSplit[i].endsWith("-M")) {
            	nomesMasculinos.add(nomesGeneroSplit[i].substring(0, nomesGeneroSplit[i].length() - 2));
            } else if (nomesGeneroSplit[i].endsWith("-F")) {
            	nomesFeminino.add(nomesGeneroSplit[i].substring(0, nomesGeneroSplit[i].length() - 2));
            };
        };*/
        
        System.out.println("Nomes masculinos: " + nomesMasculinos);
        System.out.println("Nomes femininos: " + nomesFeminino);
		System.out.println("====================================================");
		System.out.println("====================================================");
	}

}
