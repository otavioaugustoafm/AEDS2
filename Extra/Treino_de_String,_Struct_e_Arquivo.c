#include <stdio.h>
#include <string.h>

typedef struct {
  char nome[50];
  char autor[50];
  int ano;
  int codigo;
} Biblioteca;

int menu() {
  int op;
  printf("\nO que deseja fazer?\n");
  printf("\n1 - Adicionar livro\n");
  printf("2 - Remover livro\n");
  scanf("%d", &op);
  getchar();  // Consome o '\n' deixado pelo scanf
  return op;
}

void acoes(int op) {
  Biblioteca biblioteca;
  switch(op) {
    case 1: {
      FILE *arquivo = fopen("biblioteca.txt", "a");
      if(arquivo == NULL) {
        printf("Erro ao abrir o arquivo\n");
        break;
      }
      printf("Qual o codigo do livro?\n");
      scanf("%d", &biblioteca.codigo);
      getchar();  // Consome o '\n' deixado pelo scanf
      
      printf("Qual o nome do livro?\n");
      fgets(biblioteca.nome, 50, stdin);
      biblioteca.nome[strcspn(biblioteca.nome, "\n")] = '\0';
      
      printf("Qual o nome do autor?\n");
      fgets(biblioteca.autor, 50, stdin);
      biblioteca.autor[strcspn(biblioteca.autor, "\n")] = '\0';
      
      printf("Qual o ano do livro?\n");
      scanf("%d", &biblioteca.ano);
      getchar();  // Consome o '\n' deixado pelo scanf
      
      fprintf(arquivo, "%d | %s | %s | %d\n", biblioteca.codigo, biblioteca.nome, biblioteca.autor, biblioteca.ano);
      fclose(arquivo);
      break;
    }
    case 2: {
      int codigo;
      FILE *arquivo = fopen("biblioteca.txt", "r");
      FILE *temp = fopen("temp.txt", "w");
      if(arquivo == NULL || temp == NULL) {
        printf("Erro ao abrir os arquivos\n");
        break;
      }
      
      printf("Qual o codigo do livro que deseja remover?\n");
      scanf("%d", &codigo);
      getchar();  // Consome o '\n' deixado pelo scanf
      
      while(fscanf(arquivo, "%d | %49[^|] | %49[^|] | %d\n", &biblioteca.codigo, biblioteca.nome, biblioteca.autor, &biblioteca.ano) != EOF) {
        if(biblioteca.codigo != codigo) {
          fprintf(temp, "%d | %s | %s | %d\n", biblioteca.codigo, biblioteca.nome, biblioteca.autor, biblioteca.ano);
        }
      }
      fclose(arquivo);
      fclose(temp);
      remove("biblioteca.txt");
      rename("temp.txt", "biblioteca.txt");
      break;
    }
  }
}

int main() {
  int op = 0;
  while(op != 7) {
    op = menu();
    if(op == 7) {
      break;
    }
    acoes(op);
  }
}