// Version simplifiée de la commande wc qui compte sur stdin
#include <stdio.h>

int separateur(char c) {
  return (c == ' ' || c == '\t' || c == '\n');
}


int main() {
  int lines, words, chars, c;
  int prec = '\n';

  lines = words = chars = 0;

  while((c=getchar())!=EOF) {
    chars += 1;
    if (c == '\n')
      lines += 1;
    if (separateur(prec) && !separateur(c))  // !x veut dire 'NOT x'
      words += 1;
    prec = c;                                // mettre à jour prec
  }
  printf("%d %d %d\n", lines, words, chars);

  return 0;
}
