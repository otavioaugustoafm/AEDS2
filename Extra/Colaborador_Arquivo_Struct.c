#include <stdio.h>
#include <string.h>
typedef struct {
  char nome[50];
  int codigo;
  char email[50];
  int salario;
} Colaborador;

void adicionar(Colaborador colaborador[], int quantidade) {
  FILE *arquivo;
  arquivo = fopen("arquivo.txt", "a");
  for(int i = 0; i < quantidade; i++) {
    printf("Digite o nome do colaborador: ");
    fgets(colaborador[i].nome, 50, stdin);
    colaborador[i].nome[strcspn(colaborador[i].nome, "\n")] = '\0';
    printf("Digite o código do colaborador: ");
    scanf("%d", &colaborador[i].codigo);
    getchar();
    printf("Digite o email do colaborador: ");
    fgets(colaborador[i].email, 50, stdin);
    colaborador[i].email[strcspn(colaborador[i].email, "\n")] = '\0';
    printf("Digite o salário do colaborador: ");
    scanf("%d", &colaborador[i].salario);
    getchar();
    fprintf(arquivo, "%s %d %s %d\n", colaborador[i].nome, colaborador[i].codigo, colaborador[i].email, colaborador[i].salario);
  }
  fclose(arquivo);
}
void preencherArquivo(Colaborador colaborador[], int quantidade) {
  FILE *arquivo;
  arquivo = fopen("arquivo.txt", "w");
  for(int i = 0; i < quantidade; i++) {
    fprintf(arquivo, "%s %d %s %d\n", colaborador[i].nome, colaborador[i].codigo, colaborador[i].email, colaborador[i].salario);
  }
  fclose(arquivo);
}
void menu(Colaborador colaborador[], int quantidade, int op) {
  int codigoToDelete;
  switch(op) {
    case 1:
      printf("Digite quantos colaboradores deseja inserir: ");
      scanf("%d", &quantidade);
      getchar();
      adicionar(colaborador, quantidade);
      break;
    case 2:
      printf("Digite o código do colaborador que deseja apagar: ");
      scanf("%d", &codigoToDelete);
      getchar();
      FILE *arquivo, *temp;
      arquivo = fopen("arquivo.txt", "r");
      temp = fopen("temp.txt", "w");
      if (arquivo == NULL || temp == NULL) {
        printf("Erro ao abrir o arquivo.\n");
        return; // Exit with an error code
      }
      Colaborador colaborador;
      while (fscanf(arquivo, "%s %d %s %d\n", 
                    colaborador.nome, &colaborador.codigo,
                    colaborador.email, &colaborador.salario) != EOF) {
        if (colaborador.codigo != codigoToDelete) {
          fprintf(temp, "%s %d %s %d\n", 
                  colaborador.nome, colaborador.codigo,
                  colaborador.email, colaborador.salario);
        }
      }
      fclose(arquivo);
      fclose(temp);
      remove("arquivo.txt");
      rename("temp.txt", "arquivo.txt");
      printf("Colaborador apagado com sucesso!\n");
      break;
    case 3:
      printf("Saindo...\n");
      break;
    default:
      printf("Opção inválida. Tente novamente.\n");
      break;
  }
}
int main(void) {
  int quantidade, op;
  Colaborador colaborador[100];
  while (1) {
    printf("\nO que deseja fazer agora?\n");
    printf("1 - Adicionar mais colaboradores\n");
    printf("2 - Apagar colaborador\n");
    printf("3 - Sair\n");
    scanf("%d", &op);
    getchar();
    menu(colaborador, quantidade, op);
    if (op == 3) {
      break; 
    }
  }

  return 0;
}
