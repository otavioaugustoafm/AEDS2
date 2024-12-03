import java.util.*;

class Agenda {
    No raiz;

    Agenda() {
        this.raiz = null;
    }

    void inserir(Contato contato) {
        this.raiz = inserirRecursivo(this.raiz, contato);
    }    

    No inserirRecursivo(No atual, Contato contato) {
        char letra = contato.nome.charAt(0);
        letra = Character.toUpperCase(letra);
        if(atual == null) {
            atual = new No(letra);
            inserirLista(atual, contato);
        } else if(atual.letra < letra) {
            atual.dir = inserirRecursivo(atual.dir, contato);
        } else if(atual.letra > letra) {
            atual.esq = inserirRecursivo(atual.esq, contato);
        } else if(atual.letra == letra) {
            inserirLista(atual, contato);
        }
        
        return atual;
    }

    void inserirLista(No atual, Contato contato) {
        Celula nova = new Celula(contato);
        Celula tmp = atual.primeiro;

        if(tmp.prox == null || tmp.prox.contato.nome.compareTo(contato.nome) > 0) {
            nova.prox = tmp.prox;
            tmp.prox = nova;
            if(nova.prox == null) {
                atual.ultimo = nova;
            } else {
                while(tmp.prox != null && tmp.prox.contato.nome.compareTo(contato.nome) < 0) {
                    tmp = tmp.prox;
                }
                nova.prox = tmp.prox;
                tmp.prox = nova;
                if(nova.prox == null) {
                    atual.ultimo = nova;
                }
            }
        }
    }
}

class No {
    char letra;
    No esq;
    No dir;
    Celula primeiro;
    Celula ultimo;

    No(char letra) {
        this.letra = letra;
        this.esq = null;
        this.dir = null;
        this.primeiro = new Celula();
        this.ultimo = this.primeiro;
    }
}

class Celula {
    Contato contato;
    Celula prox;

    Celula() {
        this.contato = null;
        this.prox = null;
    }

    Celula(Contato contato) {
        this.contato = contato;
        this.prox = null;
    }
}

class Contato {
    String nome;
    String telefone;
    String email;
    String cpf; 

    Contato() {
        this.nome = null;
        this.telefone = null;
        this.email = null;
        this.cpf = null;
    }
}

public class arvore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Contato contato = new Contato();
        Agenda agenda = new Agenda();
        menu();
        int op = scanner.nextInt(); 
        scanner.nextLine();
        while(op != 0) {
            switch(op) {
                case 1: {
                    System.out.println("Digite o nome: ");
                    contato.nome = scanner.nextLine();
                    System.out.println("Digite o telefone: ");
                    contato.telefone = scanner.nextLine();
                    System.out.println("Digite o e-mail: ");
                    contato.email = scanner.nextLine();
                    System.out.println("Digite o CPF: ");
                    contato.cpf = scanner.nextLine();
                    agenda.inserir(contato);
                    System.out.println("");
                    break;
                }
            }

            menu();
            op = scanner.nextInt();
        }
        scanner.close();
    }

    static void menu() {
        System.out.println("Vamos trabalhar com árvores binárias!\n1 - Inserir contato\n2 - Remover contato\n3 - Mostrar contato em ordem\n0 - Finalizar");
    }
}