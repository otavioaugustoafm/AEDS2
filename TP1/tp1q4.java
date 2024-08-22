import java.util.Scanner;
import java.util.Random;

public class tp1q4 {
    public static void main(String[] args) {
        Random gerador = new Random();
        gerador.setSeed(4);
        Scanner scanner = new Scanner(System.in);
        StringBuilder novaFrase;
        while(true) {
            String frase = scanner.nextLine();
            novaFrase = new StringBuilder();
            novaFrase.append(frase);
            if(frase.equals("FIM")) {
                break;
            }
            int dLetra = Math.abs(gerador.nextInt()) % 26;
            char letra = (char) (dLetra + 97);
            int dLetra2 = Math.abs(gerador.nextInt()) % 26;
            char letra2 = (char) (dLetra2 + 97);
            for(int i = 0; i < frase.length(); i++) {
                if (novaFrase.charAt(i) == letra) {
                    novaFrase.setCharAt(i, letra2);
                }
            }
            System.out.println(novaFrase.toString());
        }
        scanner.close();
    } 
}
