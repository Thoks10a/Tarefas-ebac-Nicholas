package notas;
import java.util.Scanner;

public class notas {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int nota1,nota2,nota3,nota4;
		System.out.println("Porfavor digite as 4 notas: ");
		nota1 = sc.nextInt();
		nota2 = sc.nextInt();
		nota3 = sc.nextInt();
		nota4 = sc.nextInt();
		
		int notaSomada = (nota1 + nota2 + nota3 + nota4)/4;
		
		if(notaSomada >= 7){
			System.out.println("Parabéns, você foi aprovado!");
		}else if(notaSomada >= 5){
			System.out.println("A nota exigida não foi atingida, você está de recuperação!");
		}else if(notaSomada < 5){
			System.out.println("A média não foi atingida, você foi reprovado!");
		}
		System.out.println("Sua nota: "+notaSomada);

	}

}
