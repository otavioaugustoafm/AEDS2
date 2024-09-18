public class Lab_04 {
    public static void main (String[] args) {
        int qnt = 1;
        while(qnt != 0) {
        MyIO.print("\nQuantos numeros quer que o array tenha? \n");
        qnt = MyIO.readInt();
        int[] array = new int[qnt];
        for(int i = 0; i < array.length; i++) {
            array[i] = MyIO.readInt();
        }
        MyIO.print("Esse e o array a principio\n");
        for(int i = 0; i < array.length;i++) {
            MyIO.print(array[i] + " ");
        }
        MyIO.print("\nQual o modulo que deseja para fazer a ordenacao? \n");
        int modulo = MyIO.readInt();

        //ordenacao por selecao
        for(int i = 0; i < array.length - 1; i++) {
            int menor = i;
            for(int j = i + 1; j < array.length; j++) {
                int modMenor = array[menor] % modulo;
                int modMaior = array[j] % modulo;

                if(modMenor < 0) {
                    modMenor += modulo;
                } 
                if (modMaior < 0) {
                    modMaior += modulo;
                }

                if(modMenor > modMaior) {
                    menor = j;
                } else if(modMenor == modMaior) { 
                    if(array[menor] % 2 == 0 && array[j] % 2 != 0) {//verificando a regra de par e impar
                        menor = j;
                    } else if(array[menor] % 2 != 0 && array[j] % 2 != 0) { //verificando a regra de impar e impar
                        if(array[j] > array[menor]) {
                            menor = j;
                        }
                    } else if(array[menor] % 2 == 0 && array[j] % 2 == 0) { //verificando a regra de par e par
                        if(array[menor] > array[j]) {
                            menor = j;
                        } 
                    }
                }
            }
            int temp = array[i];
            array[i] = array[menor];
            array[menor] = temp;
        }   
        MyIO.print("Esse e o array ordenado pelo seus modulos de " + modulo + "\n");
        for(int i = 0; i < array.length;i++) {
            MyIO.print(array[i] + " ");
        }
    }
    }
    public static int menorOuMaior(int i, int j) {
        if(i > j) {
            return i;
        } else {
            return j;
        }
    }
}

