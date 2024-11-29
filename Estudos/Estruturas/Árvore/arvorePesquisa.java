import java.util.Scanner;

class Arvore {
    No raiz;

    Arvore() {
       this.raiz = null; 
    }

    public void inserir(Contato contato) {
        this.raiz = inserirRecursivo(this.raiz, contato);
    }

    public No inserirRecursivo(No atual, Contato contato) {
        char letra = contato.nome.charAt(0);
        System.out.println("Tentando inserir: " + contato.nome + " (letra: " + letra + ")");
        if(atual == null) { 
            atual = new No(letra);
            inserirContato(atual, contato);
        } else if(atual.letra > letra) {
            atual.esq = inserirRecursivo(atual.esq, contato);
        } else if (atual.letra < letra) {
            atual.dir = inserirRecursivo(atual.dir, contato);
        } else if (atual.letra == letra) {
            inserirContato(atual, contato);
        }
        return atual;
    }

    public void inserirContato(No atual, Contato contato) {
    Celula nova = new Celula(contato);
    
    // Verifica se o contato já existe na lista
    Celula atualCelula = atual.primeiro.prox;
    while (atualCelula != null) {
        if (atualCelula.contato.nome.equals(contato.nome)) {
            System.out.println("Contato já existente: " + contato.nome);  // Debug para verificar duplicatas
            return;  // Não insere novamente
        }
        atualCelula = atualCelula.prox;
    }
    
    // Inserção na lista encadeada
    if (atual.primeiro.prox == null) {
        atual.primeiro.prox = nova;
        nova.ant = atual.primeiro;
        atual.ultimo = nova;
    } else {
        atual.ultimo.prox = nova;
        nova.ant = atual.ultimo;
        atual.ultimo = nova;
    }
}

    public void percorrerOrdem() {
        percorrerOrdemRecursivo(this.raiz);
    }

    public void percorrerOrdemRecursivo(No atual) {
        if(atual != null) {
            percorrerOrdemRecursivo(atual.esq);
            System.out.println(atual.letra + " ");
            percorrerLista(atual);
            percorrerOrdemRecursivo(atual.dir);
        }
    }

    public void percorrerLista(No atual) {
        Celula atualCelula = atual.primeiro.prox;
        while(atualCelula != null) {
            System.out.println("Contato: " + atualCelula.contato.nome);
            atualCelula = atualCelula.prox;
        }
    }
    
}

class No {
    Celula primeiro;
    Celula ultimo;
    No dir;
    No esq;
    char letra;

    No(char letra) {
        this.ultimo = this.primeiro = new Celula();
        this.esq = null;
        this.dir = null;
        this.letra = letra;
    }
}

class Celula {
    Celula prox;
    Celula ant;
    Contato contato;

    Celula() {
        this.prox = null;
        this.ant = null;
        this.contato = null; 
    }

    Celula(Contato contato) {
        this.prox = null;
        this.ant = null;
        this.contato = contato;
    }
}

class Contato {
    String nome;
    String cpf;
    String num; 

    Contato() {
        this.nome = null;
        this.cpf = null;
        this.num = null;
    }
}

public class arvorePesquisa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Contato contato = new Contato();
        Arvore arvore = new Arvore();
        String sair;
        while(true) {
            System.out.println("Digite o nome: ");
            contato.nome = scanner.nextLine();
            System.out.println("Digite o número de telefone: ");
            contato.num = scanner.nextLine();
            System.out.println("Digite o CPF: ");
            contato.cpf = scanner.nextLine();
            arvore.inserir(contato);
            System.out.println("Inserido com sucesso!\nDigite 1 para continuar inserindo. ");
            sair = scanner.nextLine();
            if(!sair.equals("1")) {
                break;
            }
        }
        arvore.percorrerOrdem();
        System.out.println();
        scanner.close();
    }
}
