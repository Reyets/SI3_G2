/*
 * max.c	-- max
 *
 *           Author: Erick Gallesio [eg@unice.fr]
 *    Creation date: 13-Sep-2012 00:32 (eg)
 * Last file update: 14-Sep-2015 10:21 (eg)
 */

#include <stdio.h>

int main(void)
{
  int n;			/* Entier saisi */
  int cpt = 0;			/* Compteur */
  int items;			/* nombre d'éléments lus par scanf */

  do {
    printf("Entrer un entier: ");
    items = scanf("%d", &n);

    if (n > 0 && items == 1)
      /* on a bien saisi un nombre et il est positif */
      cpt += 1;
  } while (n > 0 && items == 1);

  printf("Nombre d'entiers saisis: %d\n", cpt);

  return 0;
}
