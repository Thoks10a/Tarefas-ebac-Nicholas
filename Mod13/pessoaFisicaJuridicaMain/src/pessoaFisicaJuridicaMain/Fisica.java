package pessoaFisicaJuridicaMain;

public class Fisica extends Pessoa {
	
	//Diferente
	@Override
	public void PessoaFisicaJuridica() {
		System.out.println("É um ser humano com capacidade natural para direitos e obrigações.");
	};
	
	public void ResponsabilidaPatrimonial() {
		System.out.println("Responde com todo o seu patrimônio pessoal por dívidas.");
	};

}
