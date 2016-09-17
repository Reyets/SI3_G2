/*					-*- coding: utf-8 -*-
 *
 * Calcul de la valeur absolue.
 *
 *           Author: Erick Gallesio [eg@unice.fr]
 *    Creation date: 21-Sep-2012 19:26 (eg)
 * Last file update: 14-Sep-2015 10:17 (eg)
 */


#include <stdio.h>

int main()
{
  int n, abs, items;

  /* Saisie */
  printf("Entrer un entier: ");
  items =  scanf("%d", &n);


  if (items == 1) {
    /* Calcul (compliqué...) de la valeur absolue */
    if (n < 0)
      abs = -n;
    else
      abs = n;

    /* Affichage */
    printf("|%d| = %d\n", n, abs);
  } else
    printf("Erreur de lecture (pas un entier ou fin de fichier rencontrée)\n");

  return 0;
}
