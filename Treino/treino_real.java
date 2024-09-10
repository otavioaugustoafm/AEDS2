import java.util.*;

public class treino_real {
    public static void main(String[] args) {
        Random random = new Random();
        MyIO.print("Digite o tamanho do array que vamos ordenar e fazer uma pesquisa binaria: \n");
        int tamanho = MyIO.readInt();
        int[] array = new int[tamanho];
        
        //dando numeros aleatorios para o array
        for(int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        //printando o array nao ordenado
        MyIO.print("Array nao ordenado \n");
        for(int i = 0; i < array.length; i++) {
            MyIO.print(array[i] + " ");
        }
        MyIO.print("\n\n");

        //agora vamos ordenar por selecao
        for(int i = 0; i < array.length - 1; i++) {
            int menor = i;
            for(int j = i+1; j < array.length; j++) {
                if(array[menor] > array[j]) {
                    menor = j;
                }
            }
            swap(array, menor, i); 
        }

        //printar o array ordenado
        MyIO.print("Array ordenado por meio de selecao\n");
        for(int i = 0; i < array.length; i++) {
            MyIO.print(array[i] + " ");
        }
        MyIO.print("\n\n");

        //pesquisar um numero por meio da pesquisa binaria
        MyIO.print("Qual o numero que voce esta procurando no array? \n");
        int x = MyIO.readInt();
        boolean resp = false;
        int esq = 0, dir = array.length -1, diferenca, meio;
        while(esq <= dir) {
            meio = (esq + dir) / 2;
            diferenca = x - array[meio];
            if(diferenca == 0) {
                resp = true;
                break;
            } else if (diferenca > 0) {
                esq = meio + 1;
            } else {
                dir = meio - 1; 
            }
        }

        //printamos se encontramos o numero buscado no array que ordenamos
        if(resp) {
            MyIO.print("Encontramos seu numero nesse array ordenado. \n\n");
        } else {
            MyIO.print("Nao encontramos seu numero nesse array ordenado. \n\n");
        }

        //agora vamos sortear ele novamente
        for(int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        //printando ele desordenado 
        MyIO.print("Array nao ordenado para fazermos a ordenacao por insercao \n");
        for(int i = 0; i < array.length; i++) {
            MyIO.print(array[i] + " ");
        }
        MyIO.print("\n\n");

        //realizando o processo de ordenacao por insercao
        for(int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;
            while((j >= 0) && (array[j] > tmp)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j+1] = tmp;
        }

        //printando ele ordenado 
        MyIO.print("Array  ordenado por insercao \n");
        for(int i = 0; i < array.length; i++) {
            MyIO.print(array[i] + " ");
        }
        MyIO.print("\n\n");

    }

    //funcao swap que faz a troca do primeiro array pelo menor, depois passa pro proximo e faz o mesmo
    public static void swap(int[] array, int menor, int i) {
        int temp = array[i];
        array[i] = array[menor];
        array[menor] = temp;
    }
}
