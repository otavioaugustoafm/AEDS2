import java.util.*;

public class treino2 {
    public static void main(String[] args) {
        //declara o random para gerar um numero aleatorio
        Random random = new Random();
        
        //declara o array
        int tamanho = MyIO.readInt();
        int[] array = new int[tamanho];

        //preenche os valores do array
        for(int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(101);
        }

        //printa o array nao ordenado
        MyIO.print("Array nao ordenado: \n");
        for(int i = 0; i < array.length; i++) {
            MyIO.print(array[i] + " ");
        }
        MyIO.print("\n\n");

        //ordena por insercao
        for(int i = 0; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while((j >= 0) && (array[j] > temp)) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = temp;
        }

        //printa ordenado por insercao
        MyIO.print("Array ordenado por insercao: \n");
        for(int i = 0; i < array.length; i++) {
            MyIO.print(array[i] + " ");
        }
        MyIO.print("\n\n");

        //preenche os valores do array
        for(int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(101);
        }

        //printa o array nao ordenado
        MyIO.print("Array nao ordenado: \n");
        for(int i = 0; i < array.length; i++) {
            MyIO.print(array[i] + " ");
        }
        MyIO.print("\n\n");

        //ordena por selecao 
        for(int i = 0; i < array.length - 1; i++) {
            int menor = i;
            for(int j = i + 1; j < array.length; j++) {
                if (array[menor] > array[j]) {
                    menor = j;
                }
            }
            swap(array, menor, i);
        }

        //printa ordenado por insercao
        MyIO.print("Array ordenado por selecao: \n");
        for(int i = 0; i < array.length; i++) {
            MyIO.print(array[i] + " ");
        }
        MyIO.print("\n\n");
    }

    //funcao para trocar
    public static void swap(int[] array, int menor, int i) {
        int temp = array[i];
        array[i] = array[menor];
        array[menor] = temp;
    }
}
