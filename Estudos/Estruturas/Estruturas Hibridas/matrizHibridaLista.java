import java.util.*;

class Matriz {
    CelulaMatriz inicio;
    int linha, coluna;

    Matriz(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    void construirMatriz() {
        this.inicio = new CelulaMatriz();
        Celula atual = inicio;
        Celula linhaAcima = null;

        for(int i = 1; i < this.coluna; i++) {
            atual.dir = new CelulaMatriz();
            atual.dir.esq = atual;
            atual = atual.dir;
        }

        for(int i = 0; i < this.linha; i++) {
            if(linhaAcima == null) {
                linhaAcima = inicio;
            } else {
                linhaAcima = linhaAcima.inf;
            }
            atual = new Celula();
            atual.sup = linhaAcima;
            linhaAcima.inf = atual;

            CelulaMatriz celulaAcima = linhaAcima;
            CleulaMatriz celulaAtual = atual;
            for(int j = 1; j < this.coluna; j++) {
                celulaAtual.dir = new Celula();
                celulaAtual.dir.esq = celulaAtual;
                
            }
        }
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