// Version simplifiée de la commande wc qui compte sur stdin (Utilisation d'un switch)
#include <stdio.h>

int main() {
  int lines, words, chars, c, in_a_word;

  lines = words = chars = 0;
  in_a_word = 0;

  while((c=getchar())!=EOF) {
    chars += 1;
    switch(c)	{
      case '\n': lines += 1;	// pas de break ici !!!!
      case ' ':
      case '\t':
	in_a_word = 0;		// on ne se trouve pas dans un mot
	break;
      default:
	if (!in_a_word) {
	  in_a_word = 1;	// on a un nouveau mot
	  words += 1;
	}
	break;
    }
  }
  printf("%d %d %d\n", lines, words, chars);

  return 0;
}
