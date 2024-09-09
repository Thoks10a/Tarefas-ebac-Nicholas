package pessoaFisicaJuridicaMain;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pessoa fisica = new Fisica();
		Pessoa juridica = new Juridica();
		
		//Iguais
		System.out.println("Fisica");
		fisica.Contratos();
		System.out.println("");
		System.out.println("Juridica");
		juridica.Contratos();
		System.out.println("--------------------------");
		//Diferentes
		System.out.println("Fisica.");
		fisica.PessoaFisicaJuridica();
		System.out.println("");
		System.out.println("Juridica.");
		juridica.PessoaFisicaJuridica();
		System.out.println("--------------------------");

	}

}
