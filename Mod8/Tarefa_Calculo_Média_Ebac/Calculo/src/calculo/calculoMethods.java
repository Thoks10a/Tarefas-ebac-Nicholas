package calculo;

public class calculoMethods {
	
	private float nota1;
	private float nota2;
	private float nota3;
	private float nota4;
	
	public calculoMethods(float nota1,float nota2,float nota3,float nota4) {
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.nota4 = nota4;
	}
	
	
	public void MediaConst() {
		float media = 0;
		media = nota1 + nota2 + nota3 + nota4;
		media = media/4;
		System.out.println("Média: "+media);
		if(media > 6) {
			System.out.println("Parabéns, você foi aprovado!");
		}else {
			System.out.println("Sinto muito, reprovado!");
		}
	}
	
	public void Media(float nota1,float nota2,float nota3,float nota4) {
		float media = 0;
		media = nota1 + nota2 + nota3 + nota4;
		media = media/4;
		System.out.println("Média: "+media);
		if(media > 6) {
			System.out.println("Parabéns, você foi aprovado!");
		}else {
			System.out.println("Sinto muito, reprovado!");
		}
		
	}
	
}
