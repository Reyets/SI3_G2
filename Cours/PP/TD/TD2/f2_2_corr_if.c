// Version simplifiée de la commande wc qui compte sur stdin. (Utilisation de if)

#include <stdio.h>

int main() {
  int lines, words, chars, c, in_a_word;

  lines = words = chars = 0;
  in_a_word = 0;

  while((c=getchar())!=EOF) {
    chars += 1;
    if (c == '\n' || c == ' ' || c == '\t')  {
      if (c == '\n')  lines += 1;
      in_a_word = 0;			// on ne se trouve pas dans un mot
    } else {
      if (!in_a_word) {
	     words += 1;			// on a un nouveau mot
	     in_a_word = 1;
      }
    }
  }
  printf("%d %d %d\n", lines, words, chars);

  return 0;
}