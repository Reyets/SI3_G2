/* fgrep.c:	la fonction strstr et une application: un fgrep simplifié
 *		(ce fgrep ne fonctionne pas si le fichier contient des '\0')
 *
 *           Author: Erick Gallesio [eg@unice.fr]
 *    Creation date: 25-Sep-2015 09:23 (eg)
 * Last file update: 25-Sep-2015 09:37 (eg)
 */

#include <stdio.h>

// Strstr: renvoie 1 si small est une sous-chaine de big; renvoie 0 sinon
int Strstr(char big[], char small[]) {
  int i, s, b;

  for (i = 0; big[i]; i++) {
     for (s=0, b=i; small[s]; s++, b++)
       if (small[s] != big[b]) break;
     // Si on est arrivé au bout de small (i.e small[s] == '\0' on a trouvé
     if (small[s] == '\0') return 1;
  }

  // Si on est la, c'est qu'on a pas trouve small dans big
  return 0;
}

/**************************************************************/

#define MAXLINELEN 1000

void FastGrep (char pattern[]) {
  int c;		   // caractere lu depuis stdin (type ENTIER)
  int size = 0;		   // taille de la ligne lue, \n non compris
  char line[MAXLINELEN+1]; // buffer contenant une ligne

  while ((c = getchar()) != EOF) {
    if (size < MAXLINELEN) 
      line[size++] = c;   // Les lignes trop longues sont tronquées. Tant-pis

    if (c == '\n') {
      line[size] = '\0';
      if (Strstr(line, pattern)) printf("%s", line);
      size = 0;
    }
  }

  // Quand on sort sur EOF, on peut avoir une ligne (sans '\n') partiellement lue
  if (size > 0) {
    line[size] = '\0';
    if (Strstr(line, pattern)) printf("%s", line);
  }
}

int main (int argc, char *argv[]) {
  if (argc == 2) FastGrep(argv[1]);
  else
    printf("Usage: fgrep chaine\n");
  return 0;
}
