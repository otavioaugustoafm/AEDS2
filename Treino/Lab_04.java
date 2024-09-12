public class Lab_04 {
    public static void main (String[] args) {
        MyIO.print("Quantos numeros quer que o array tenha? \n");
        int qnt = MyIO.readInt();
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
        for(int i = 0; i < array.length - 1; i++) {
            int menor = i;
            for(int j = i + 1; j < array.length; j++) {
                if(array[i]/modulo > array[j]/modulo) {
                    menor = j;
                }          
            }
            int temp = array[i];
            array[i] = array[menor];
            array[menor] = temp;
        }   
        MyIO.print("Esse e o array ordenado pelo seus modulos de " + qnt + "\n");
        for(int i = 0; i < array.length;i++) {
            MyIO.print(array[i] + " ");
        }
    }
}

