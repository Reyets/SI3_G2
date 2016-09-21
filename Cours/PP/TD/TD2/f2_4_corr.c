/*
 * 4_dump_hexa.c 	-- Dump héxadécimal
 *
 *           Author: Erick Gallesio [eg@unice.fr]
 *    Creation date: 25-Sep-2015 08:57 (eg)
 * Last file update: 25-Sep-2015 08:58 (eg)
 */

#include <stdio.h>
#define MAXLIGNE 16

void imprimer_ligne(char ligne[], int lg)
{
  int j;

  // Afichage du code des caractères
  for (j = 0; j < MAXLIGNE; j++) {
    if (j < lg)
      // Impression en hexadécimal . Le cast sert au cas où le char serait signé.
      printf("%02x ", (unsigned char) ligne[j]);
    else
      // Afficher des espaces pour alignement
      printf("   ");
  }

  // Affichage des caractères
  for (j = 0; j < lg; j++) {
    char c = ligne[j];

    printf("%c", (' ' <= c && c <= '~') ? c: '.');
  }
  printf("\n");
}


int main()
{
  int c, i = 0;
  char ligne[MAXLIGNE];

  while ((c = getchar()) != EOF) {
    ligne[i++] = c;
    if (i == MAXLIGNE) {
      imprimer_ligne(ligne, i);
      i = 0;
    }
  }

  if (i != 0) imprimer_ligne(ligne, i);

  return 0;
}
