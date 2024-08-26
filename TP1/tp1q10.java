import java.util.Scanner;

public class tp1q10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        palindromo(scanner);
        scanner.close();
    }
    public static void palindromo(Scanner scanner) {
        String frase = "Inicio";
        int tamanho, index1, index2;
        String fim = "FIM";
        frase = scanner.nextLine();
        if(frase.equals(fim)) {
            return;
        } else {
            boolean resp = true;
            tamanho = frase.length();
            index1 = 0;
            index2 = tamanho - 1;
            for(int i = 0; i < tamanho / 2; i++) {
                if(frase.charAt(index1) != frase.charAt(index2)) {
                    resp = false;
                    break;
                } 
                index1++;
                index2--;
            }
            if( resp == true) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
        }
        palindromo(scanner);
    }
}
