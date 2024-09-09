package pessoaFisicaJuridicaMain;

public abstract class Pessoa {
	
	public abstract void PessoaFisicaJuridica();
	public abstract void ResponsabilidaPatrimonial();
	//Iguais
		public void Contratos() {
			System.out.println("Tanto pessoas físicas quanto jurídicas podem celebrar contratos (como compra e venda, locação, prestação de serviços, etc.");
		};
		public void ResponsabilidadeCivil() {
			System.out.println("Ambas podem ser responsabilizadas por danos causados a terceiros e ser obrigadas a indenizar.");
		};
		public void Imposto() {
			System.out.println("Pessoas físicas e jurídicas devem pagar impostos de acordo com suas atividades econômicas, como Imposto de Renda e outros tributos específicos.");
		};
		public void PropriedadeBens() {
			System.out.println("Tanto a pessoa física quanto a jurídica podem possuir bens, como imóveis, veículos, e outros ativos.");
		};
		public void AcessoJudiciario() {
			System.out.println("Ambas podem acionar a Justiça para defender seus direitos ou contestar obrigações. Além disso, ambas podem ser processadas judicialmente.");
		};
}
