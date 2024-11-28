import java.util.*;

class Arvore {
    No raiz;

    Arvore() {
        this.raiz = null;
    }

    public void Inserir(char letra) {
        this.raiz = InserirRecursivo(this.raiz, letra);
    }

    public No InserirRecursivo(No atual, char letra) {
        if(atual == null) {
            return new No(letra);
        }
        if(letra < atual.letra) {
            atual.esq = InserirRecursivo(atual.esq, letra);
        } else if(letra > atual.letra) {
            atual.dir = InserirRecursivo(atual.dir, letra);
        }
        return atual;
    }

    public void PercorrerEmOrdem() {
        PercorrerEmOrdemRecursivo(this.raiz);
    }

    public void PercorrerEmOrdemRecursivo(No atual) {
        if(atual != null) {
            PercorrerEmOrdemRecursivo(atual.esq);
            System.out.print(atual.letra + " ");
            PercorrerEmOrdemRecursivo(atual.dir);
        }
    }

    public void PercorrerPreOrdem() {
        PercorrerPreOrdemRecursivo(this.raiz);
    }

    public void PercorrerPreOrdemRecursivo(No atual) {
        if(atual != null) {
            System.out.print(atual.letra + " ");
            PercorrerPreOrdemRecursivo(atual.esq);
            PercorrerPreOrdemRecursivo(atual.dir);
        }
    }

    public void PercorrerPosOrdem() {
        PercorrerPosOrdemRecursivo(this.raiz);
    }
    
    public void PercorrerPosOrdemRecursivo(No atual) {
        if(atual != null) {
            PercorrerPosOrdemRecursivo(atual.esq);
            PercorrerPosOrdemRecursivo(atual.dir);
            System.out.print(atual.letra + " ");
        }
    }
}

class No {
    char letra;
    No dir, esq;

    No(char letra) {
        this.letra = letra;
        this.dir = null;
        this.esq = null;
    }
}

public class arvore {
    public static void main(String args[]) {
        Arvore arvore = new Arvore();
        arvore.Inserir('C');
        arvore.Inserir('A');
        arvore.Inserir('B');
        arvore.Inserir('D');
        arvore.Inserir('E');
        arvore.PercorrerEmOrdem();
        System.out.println();
        arvore.PercorrerPosOrdem();
        System.out.println();
        arvore.PercorrerPreOrdem();
        System.out.println();
    }
}