package ExercicioTI201;
import java.util.Scanner;
public class SomarDoisNumeros {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o primeiro número: ");
		int a = scanner.nextInt();
		System.out.print("Digite o segundo número: ");
		int b = scanner.nextInt();
		int soma = a+b;
		System.out.println("A soma é "+ soma);
		scanner.close();
	}
}
