import java.util.*;

public class lab06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int participantes = 0;
        int x = 0;
        while (x < 3) {
            participantes = scanner.nextInt();
            int[] arrayLargada = new int[participantes];
            for(int i = 0; i < arrayLargada.length; i++) {
                arrayLargada[i] = scanner.nextInt();
            }
            int[] arrayChegada = new int[participantes];
            for(int i = 0; i < arrayChegada.length; i++) {
                arrayChegada[i] = scanner.nextInt();
            }
            int res = ultrapassagens(arrayLargada, arrayChegada);
            System.out.println(res);
            x++;    
        }
        scanner.close();
    }

    public static int ultrapassagens(int[] arrayLargada, int[] arrayChegada) {
        
        return ultrapassagem;
    }
}
