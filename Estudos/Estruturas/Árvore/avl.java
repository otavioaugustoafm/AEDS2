class Arvore {
    No raiz;

    Arvore() {
    this.raiz = null;
    }
}

class No {
    No dir;
    No esq;
    char letra;
    Celula primeiro;
    Celula ultimo;
    int altura;

    No(char letra) {
        this.letra = letra;
        this.dir = null;
        this.esq = null;
        this.primeiro = new Celula();
        this.ultimo = this.primeiro;
        this.altura = 1;
    }
}

class Celula {

}

class Contato {

}

public class avl {
    public static void main(String[] args) {
        
    }
}