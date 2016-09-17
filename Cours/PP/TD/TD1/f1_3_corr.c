/*
 * max.c	-- max
 *
 *           Author: Erick Gallesio [eg@unice.fr]
 *    Creation date: 13-Sep-2012 00:32 (eg)
 * Last file update: 14-Sep-2015 10:23 (eg)
 */

#include <stdio.h>

int main(void)
{
  int n, items;			/* Entier saisi et résultat de scanf */
  int cpt = 0;			/* Compteur */
  int sum = 0;			/* Somme */
  int max = -1;			/* Maximum */

  do {
    printf("Entrer un entier: ");
    items = scanf("%d", &n);

    if (items == 1 && n > 0) {
      /* le nombre saisi est positif */
      cpt += 1;
      sum += n;
      if (n > max)
	max = n;
    }
  } while (items == 1 && n > 0);

  if (cpt > 0) {
    /* On affiche rien si aucun nombre positif n'a été saisi */
    printf("Le maximum des %d nombres saisis est %d. La somme est %d.\n", 
	   cpt, max, sum);
  }

  return 0;
}
