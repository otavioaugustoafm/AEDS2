import java.util.*;

class Matriz {
    CelulaMatriz inicio;
    int linha, coluna;

    Matriz(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    void construirMatriz() {

    }
}

class CelulaMatriz {
    Lista lista;
    CelulaMatriz esq, dir, sup, inf;

    CelulaMatriz() {
        this.lista = new Lista();
        this.esq = this.dir = this.sup = this.inf = null;
    }

}

class CelulaLista {
    String elemento;
    CelulaLista inf, sup;

    CelulaLista() {
        this.elemento = " ";
        this.inf = this.sup = null;
    }
}

class Lista {
    CelulaLista primeiro;
    CelulaLista ultimo;

    Lista() {
        this.primeiro = null;
        this.ultimo = null;
    }
}

public class matrizHibridaLista {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt(), c = scanner.nextInt();
        Matriz matriz = new Matriz(l,c);
        matriz.construirMatriz();
    }
}