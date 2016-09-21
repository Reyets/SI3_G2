/*
 * 3_insert.c	-- Insertion dans un tableau
 *
 *           Author: Erick Gallesio [eg@unice.fr]
 *    Creation date:  9-Oct-2013 22:52 (eg)
 * Last file update: 21-Sep-2015 14:20 (eg)
 */

#include <stdio.h>


/* Insertion de n à sa place dans le tableau array rempli de nbval valeurs */
/* Si le tableau n'est pas assez grand ... ça plante */
void insertion(int array[], int nbval, int n)
{
  int i;

  for (i = nbval-1; (i >= 0) && (array[i] > n); i--) {
    array[i+1] = array[i];
  }
  array[i+1] = n;
}


void print_array(int array[], int nbval){
  int i;

  printf("[ ");
  for (i = 0; i < nbval; i++)
    printf("%d ", array[i]);
  printf("]\n");
}


int main(void)
{
  int array[100];
  int n, items, nbval = 0;

  do {
    printf("Entrer un entier: ");
    items = scanf("%d", &n);
    if (items == 1 && n >= 0) {
      /* le nombre saisi est positif */
      insertion(array, nbval++, n);
      print_array(array, nbval);
    }
  } while (items == 1  && n >= 0);
}
