package pessoaFisicaJuridicaMain;

public class Juridica extends Pessoa {

	//Diferente
	@Override
	public void PessoaFisicaJuridica() {
		System.out.println("É uma entidade ou organização criada por uma ou mais pessoas físicas, como empresas, associações e fundações."
				+ "");
	};
	@Override
	public void ResponsabilidaPatrimonial() {
		System.out.println("Dependendo da forma societária, pode ter responsabilidade limitada ao capital social, protegendo o patrimônio pessoal dos sócios.");
	};
}
