//DIVISAO E CONQUISTA
//BASEA-SE EM IR DIVIDINDO O ARRAY ALVO EM 2 SUCESSIVAMENTE
//E IR ORDENANDO AOS POUCOS ATÉ CONSEGUIR

import java.util.*;

public class quicksort {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        boolean opcao = true;
        System.out.println("Bem vindo à nossa biblioteca!\nVamos ordenar uma coleção de dados de livros por meio de diversos Quicksorts.\nQuantos livros deseja inserir? ");
        int n = scanner.nextInt();
        Livro[] livro = new Livro[n];
        while(opcao) {
            int op = menu();
            switch(op){
                case 1: {

                    opcao = false; 
                    break;
                }
                case 2: {

                    opcao = false; 
                    break;
                }
                case 3: {

                    opcao = false; 
                    break;
                }
                case 4: {

                    opcao = false; 
                    break;
                }
                case 5: {
                    opcao = false; 
                    break;
                }
                default: {
                    System.out.println("Opção inválida.");
                    break;
                }            
            }
        }

        scanner.close();
    }

    public static int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha uma opção:\n1 - Quicksort com pivô no primeiro elemento.\n2 - Quicksort com pivô no elemento do meio\n3 - Quicksort com o pivô no último elemento\n4 - Quicksort com o pivô em um elemento que foi escolhido\n5 - Sair do programa");
        int op = scanner.nextInt();
        return op;
    }

    public static void quicksortPrimeiro() {

    }
}

class Data {
    int dia;
    int mes;
    int ano;

    public Data() {
        this.dia = 0;
        this.mes = 0;
        this.ano = 0;
    }
    
    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public void mostrarData() {
        System.out.println(dia + "/" + mes + "/" + ano);
    }


    public int getDia() {
        return this.dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return this.mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

}

class Livro {
    String nome;
    String autor;
    String lingua;
    Data data;

    public Livro() {
        this.nome = "";
        this.autor = "";
        this.lingua = "";
        this.data = new Data();
    }

    public Livro(String nome, String autor, String lingua, Data data) {
        this.nome = nome;
        this.autor = autor;
        this.lingua = lingua;
        this.data = data;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getLingua() {
        return this.lingua;
    }

    public void setLingua(String lingua) {
        this.lingua = lingua;
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }
    
}
