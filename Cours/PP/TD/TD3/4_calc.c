/*                                                      -*- coding: utf-8 -*-
 * calc.c       -- Une calculatrice ultra basique
 *
 *           Author: Erick Gallesio [eg@unice.fr]
 *    Creation date: 30-Oct-2013 13:38 (eg)
 * Last file update: 13-Oct-2016 15:15 (eg)
 */


#include <stdarg.h>
#include <stdio.h>

int evaluer(char op, ...)
{
  va_list p;
  int courant, res;

  va_start(p, op);

  res = va_arg(p, int);    // initialisation du résultat avec le premier nombre
  if (res < 0) return 0;   // Si aucun opérande on renvoie 0 par convention

  for(courant = va_arg(p, int); courant > 0; courant = va_arg(p, int)) {
    switch (op) {
      case '+': res += courant; break;
      case '-': res -= courant; break;
      case '/': res /= courant; break;
      case '*': res *= courant; break;
    }
  }
  return res;
}


int main(void)
{
  printf("1+2+3=%d\n", evaluer('+', 1, 2, 3, -1));
  printf("10-(2*2*2)-2=%d\n", evaluer('-', 10, evaluer('*', 2, 2, 2, -1), 2, -1));
  printf("- sans opérande: %d\n", evaluer('-', -1));
  return 0;
}
