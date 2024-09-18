#include <stdio.h>
#include <stdlib.h>

void ler(int **, int **, int);
void imprimir(int **, int);
void imprimir_d(int **, int);
void vetor(int **, int, int[]);
void soma(int **, int **, int);

int main() {
  int n = 3;
  //scanf("%d", &n);
  int **mat, **mat2;
  int vet[n];
  mat = (int **)malloc(n * sizeof(int *));
  mat2 = (int **)malloc(n * sizeof(int *));
  ler(mat, mat2, n);
  imprimir(mat, n);
  imprimir_d(mat, n);
  vetor(mat, n, vet);
  soma(mat, mat2, n);
}

void ler(int **matriz, int **matriz2, int tamanho) {
  for (int i = 0; i < tamanho; i++) {
    matriz[i] = (int *)malloc(tamanho * sizeof(int));
  }
  for (int i = 0; i < tamanho; i++) {
    for (int j = 0; j < tamanho; j++) {
      matriz[i][j] = rand() % 100;
    }
  }
  for (int i = 0; i < tamanho; i++) {
    matriz2[i] = (int *)malloc(tamanho * sizeof(int));
  }
  for (int i = 0; i < tamanho; i++) {
    for (int j = 0; j < tamanho; j++) {
      matriz2[i][j] = rand() % 100;
    }
  }
}

void imprimir(int **matriz, int tamanho) {
  for (int i = 0; i < tamanho; i++) {
    for (int j = 0; j < tamanho; j++) {
      printf("%d\t", matriz[i][j]);
    }
    printf("\n");
  }
  printf("\n");
}

void imprimir_d(int **matriz, int tamanho) {
  for (int i = 0; i < tamanho; i++) {
    for (int j = 0; j < tamanho; j++) {
      if (j == i) {
        printf("%d\t", matriz[i][j]);
      } else {
        printf("\t");
      }
    }
    printf("\n");
  }
  printf("\n");
}

void vetor(int **matriz, int tamanho, int vetor[]) {
  for (int i = 0; i < tamanho; i++) {
    for (int j = 0; j < tamanho; j++) {
      if (j == i) {
        vetor[i] = matriz[i][j];
      }
    }
  }
  for (int i = 0; i < tamanho; i++) {
    printf("%d\t", vetor[i]);
  }
  printf("\n");
}

void soma(int **matriz, int **matriz2, int tamanho) {
  printf("\n");
  for (int i = 0; i < tamanho; i++) {
    for (int j = 0; j < tamanho; j++) {
      printf("%d\t", matriz[i][j] + matriz2[i][j]);
    }
    printf("\n");
  }
  printf("\n");
}
