#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Lista {
    Celula* primeiro;
    Celula* ultimo;
} Lista;

typedef struct Celula {
    int elemento;
    Celula* prox;
} Celula;

void listaConstrutor(Lista* lista) {
    lista->primeiro = NULL;
    lista->ultimo = NULL;
}

Celula* celulaConstrutor(Lista* lista, int elemento) {
    Celula* celula = (Celula*)malloc(sizeof(Celula));
    celula->elemento = elemento;
    celula->prox = NULL;
    return celula;
}

int main() {
    Lista lista;
    listaConstrutor(&lista);
}