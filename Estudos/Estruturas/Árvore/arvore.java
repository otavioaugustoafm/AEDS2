import java.util.*;

class Arvore {
    No raiz;

    Arvore() {
        this.raiz = null;
    }

    void inserir(Contato contato) {
        this.raiz = inserirRecursivo(this.raiz, contato);
    }

    No inserirRecursivo(No atual, Contato contato) {
        char letra = contato.nome.charAt(0);
        if(atual == null) {
            atual = new No(letra);
            inserirLista(atual, contato);
        } else if (atual.letra > letra) {
            atual.esq = inserirRecursivo(atual.esq, contato);
        } else if (atual.letra < letra) {
            atual.dir = inserirRecursivo(atual.dir, contato);
        } else if (atual.letra == contato.nome.charAt(0)) {
            inserirLista(atual, contato);
        }
        return atual;
    }

    void inserirLista(No atual, Contato contato) {
        Celula nova = new Celula(contato);
        if(atual.primeiro.prox == null) {
            atual.primeiro.prox = nova;
            nova.ant = atual.primeiro;
            atual.ultimo = nova;
        } else {
            atual.ultimo.prox = nova;
            nova.ant = atual.ultimo;
            atual.ultimo = nova;
        }
    }

    void imprimirListas(No atual) {
        Celula tmp = atual.primeiro.prox;
        if(tmp == null) {
            System.out.println("Nenhum contato registrado.");
        } else {
            while(tmp != null) {
                System.out.println("Nome: " + tmp.contato.nome + "| CPF: " + tmp.contato.cpf + "| Telefone: " + tmp.contato.telefone);
                tmp = tmp.prox;
            }
        }
    }

    void percorrerOrdem() {
        percorrerOrdemRecursivo(this.raiz);
    }

    void percorrerOrdemRecursivo(No atual) {
        if(atual != null) {
            percorrerOrdemRecursivo(atual.esq);
            System.out.println("Letra do Nó: " + atual.letra );
            imprimirListas(atual);
            percorrerOrdemRecursivo(atual.dir);
        }
    }
}

class No {
    char letra;
    No dir;
    No esq;
    Celula primeiro;
    Celula ultimo;

    No(char letra) {
        this.letra = letra;
        this.dir = null;
        this.esq = null;
        this.primeiro = new Celula();
        this.ultimo = this.primeiro;
    }
}

class Celula {
    Contato contato; 
    Celula prox;
    Celula ant;

    Celula() {
        this.contato = null;
        this.prox = null;
        this.ant = null;
    }

    Celula(Contato contato) {
        this.contato = contato;
        this.prox = null;
        this.ant = null;
    }
}

class Contato {
    String nome;
    String cpf;
    String telefone;

    Contato() {
        this.nome = null;
        this.cpf = null;
        this.telefone = null;
    }
}

public class arvore {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Arvore arvore = new Arvore();
        System.out.println("Vamos inserir contatos na nossa árvore binária! ");
        int i = 1;
        while(true) {
            Contato contato = new Contato();
            System.out.println(i + "o contato (Digite 0 em qualquer opção para sair)");
            System.out.println("Digite o nome: ");
            contato.nome = scanner.nextLine();
            if(contato.nome.equals("0")) break; 
            System.out.println("Digite o CPF: ");
            contato.cpf = scanner.nextLine();
            if(contato.cpf.equals("0")) break;
            System.out.println("Digite o telefone: ");
            contato.telefone = scanner.nextLine();
            if(contato.telefone.equals("0")) break;
            arvore.inserir(contato);
            i++;
        }
        arvore.percorrerOrdem();
        scanner.close();
    }
}