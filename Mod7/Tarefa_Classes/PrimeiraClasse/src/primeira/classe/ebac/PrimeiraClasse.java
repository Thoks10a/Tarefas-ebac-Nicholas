package primeira.classe.ebac;

public class PrimeiraClasse {

	public static void main(String[] args) {

		// Criando um objeto Triangulo
        Triangulo triangulo = new Triangulo(5, 10);

        // Calculando a área do triângulo
        double area = triangulo.calcularArea();

        // Imprimindo a área
        System.out.println("A área do triângulo é: " + area);

	}

}
