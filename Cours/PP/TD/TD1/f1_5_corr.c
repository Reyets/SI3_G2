/*					-*- coding: utf-8 -*-
 *
 *  Table de conversion Celsius/Fahrenheit (par cast puis par appel a rint)
 *
 *           Author: Erick Gallesio [eg@unice.fr]
 *    Creation date: 21-Sep-2012 19:26 (eg)
 * Last file update: 21-Sep-2012 20:11 (eg)
 */


/* Pour utiliser rint, il faut faire l'édition de lien avec la
 * bibliothèque mathématique (option -lm).
 * La compilation est donc:
 *      $ gcc -Wall -std=c99 -o conv conv.c -lm
 */

#include <stdio.h>
#include <math.h>

int main()
{
  float c;

  printf("Avec le cast\n");
  for (c = 0.0; c <= 20.0; c += 0.5)
    printf("%4.1f Degres valent %2d Fahrenheit\n", c, (int) (9*c)/5+32 );

  printf("Avec le rint\n");
  for (c=0.0; c <= 20.0; c += 0.5)
    printf("%4.1f Degres valent %4.2f Fahrenheit\n", c, rint((9*c)/5+32) );

  return 0;
}
