import java.util.*;

public class lab06 {
    public static void main(String[] args) {
        int[] array = new int[1000];
        arrayAleatorio(array);
        int n = array.length;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual opção de ordenação deseja utilizar?\n1 - QuickSort por meio do pivô no primeiro elemento\n2 - QuickSort por meio do pivô no último elemento\n3 - QuickSort por meio do pivô em uma posição aleatória\n4 - QuickSort por meio do pivô na mediana dos três elementos (início, meio, fim)");
        int op = scanner.nextInt();
        long startTime, endTime, duration;
        switch (op) {
            case 1: {
                System.out.print("Antes da ordenação: " + Arrays.toString(array) + "\n");
                startTime = System.nanoTime();
                quicksortPrimeiro(array, 0, n-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.print("Depois da ordenação: " + Arrays.toString(array) + "\n");
                System.out.println("Tempo de execução (ns): " + duration);
                break;
            }
            case 2: {
                System.out.print("Antes da ordenação: " + Arrays.toString(array) + "\n");
                startTime = System.nanoTime();
                quicksortUltimo(array, 0, n-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.print("Depois da ordenação: " + Arrays.toString(array) + "\n");
                System.out.println("Tempo de execução (ns): " + duration);
                break;
            }
            case 3: {
                System.out.print("Antes da ordenação: " + Arrays.toString(array) + "\n");
                startTime = System.nanoTime();
                quicksortAleatorio(array, 0, n-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.print("Depois da ordenação: " + Arrays.toString(array) + "\n");
                System.out.println("Tempo de execução (ns): " + duration);
                break;
            }
            case 4: {
                System.out.print("Antes da ordenação: " + Arrays.toString(array) + "\n");
                startTime = System.nanoTime();
                quicksortMediana(array, 0, n-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.print("Depois da ordenação: " + Arrays.toString(array) + "\n");
                System.out.println("Tempo de execução (ns): " + duration);
                break;
            }
            default: {
                System.out.print("Opção Inválida\n");
            }

        }
    }


    // Utilizando o QuickSort com o pivô no primeiro elemento
    public static void quicksortPrimeiro(int[] array, int esq, int dir) {
        if(esq < dir) {
            int indicePivo = particionaPrimeiro(array, esq, dir);
            quicksortPrimeiro(array,esq,indicePivo-1);
            quicksortPrimeiro(array, indicePivo + 1, dir);
        }
    }

    public static int particionaPrimeiro(int[] array, int esq, int dir) {
        int pivo = array[esq];
        int i = esq + 1;
        for(int j = esq + 1; j <= dir; j++) {
            if(array[j] < pivo) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
            }
        }
        int tmp = array[esq];
        array[esq] = array[i-1];
        array[i-1] = tmp;
        return i - 1;
    }

    // Utilizando o QuickSort com o pivô no último elemento
    public static void quicksortUltimo(int[] array, int esq, int dir) {
        if(esq < dir) {
            int indicePivo = particionaUltimo(array, esq, dir);
            quicksortUltimo(array, esq, indicePivo-1);
            quicksortUltimo(array, indicePivo+1, dir);
        }
    }

    public static int particionaUltimo(int[] array, int esq, int dir) {
        int pivo = array[dir];
        int i = esq;
        for(int j = esq; j < dir; j++) {
            if(array[j] <= pivo) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
            }
        }
        int tmp = array[i];
        array[i] = array[dir];
        array[dir] = tmp;
        return i;
    }


    // Utilizando o QuickSort com o pivô no primeiro elemento
    public static void quicksortAleatorio(int[] array, int esq, int dir) {
        if(esq < dir) {
            int indicePivo = particionarAleatorio(array, esq, dir);
            quicksortAleatorio(array, esq, indicePivo-1);
            quicksortAleatorio(array, indicePivo+1, dir);
        }
    }

    public static int particionarAleatorio(int[] array, int esq, int dir) {
        Random gerador = new Random();
        int aleatorio = gerador.nextInt(dir - esq + 1) + esq;
        int tmp = array[dir];
        array[dir] = array[aleatorio];
        array[aleatorio] = tmp;
        int pivo = array[dir];
        int i = esq;
        for(int j = esq; j < dir; j++){
            if(array[j] <= pivo) {
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
            }
        }
        tmp = array[i];
        array[i] = array[dir];
        array[dir] = tmp;
        return i;
    }

    // Utilizando o QuickSort com o pivô na mediana 
    public static void quicksortMediana(int[] array, int esq, int dir) {
        if (esq < dir) {
            int indicePivo = particionarMediana(array, esq, dir);
            quicksortMediana(array, esq, indicePivo-1);
            quicksortMediana(array, indicePivo+1, dir);
        }
    }

    public static int particionarMediana(int[]array, int esq, int dir) {
        int meio = esq + (dir-esq) / 2;
        int indiceMediana = mediana(array, esq, meio, dir);
        int tmp = array[dir];
        array[dir] = array[indiceMediana];
        array[indiceMediana] = tmp;
        int pivo = array[dir];
        int i = esq;
        for(int j = esq; j < dir; j++) {
            if(array[j] <= pivo) {
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
            }
        }
        tmp = array[dir];
        array[dir] = array[i];
        array[i] = tmp;
        return i;
    }

    public static void arrayAleatorio(int[] array) {
        Random gerador = new Random();
        for(int i = 0; i < array.length;i++) {
            array[i] = gerador.nextInt(10000);
        }
    }

    public static void arrayOrdenado(int[] array) {
        Random gerador = new Random();
        for(int i = 0; i < array.length;i++) {
            array[i] = gerador.nextInt(10000);
        }
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void arrayQuaseOrdenado(int[] array) {
        Random gerador = new Random();
        
        for (int i = 0; i < array.length; i++) {
            array[i] = gerador.nextInt(1000);
        }
    
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    
        for (int i = 0; i < n / 10; i++) { 
            int pos1 = gerador.nextInt(n);
            int pos2 = gerador.nextInt(n);
            
            int temp = array[pos1];
            array[pos1] = array[pos2];
            array[pos2] = temp;
        }
    }

    public static int mediana(int[] array, int esq, int meio, int dir) {
        int a = array[esq];
        int b = array[meio];
        int c = array[dir];
    
        if ((a > b && a < c) || (a < b && a > c)) {
            return esq; 
        } else if ((b > a && b < c) || (b < a && b > c)) {
            return meio; 
        } else {
            return dir;
        }
    }
}