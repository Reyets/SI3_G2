/*
 * 5_catstrings.c       -- Affichage de chaînes en nombre variable
 *
 *           Author: Erick Gallesio [eg@unice.fr]
 *    Creation date: 14-Oct-2016 11:01 (eg)
 * Last file update: 14-Oct-2016 11:09 (eg)
 */
#include <stdarg.h>
#include <stdio.h>


void print_string(char str[]) {         // équivalent à fputs(current, stdout)
  for (int i =0; str[i]; i++)
    putchar(str[i]);
}


void cat_strings (char str[], ...) {
  va_list ap;
  char *current;

  va_start(ap, str);
  for (current = str; current; current = va_arg(ap, char *))
    print_string(current);

  va_end(ap);
}


int main() {
  cat_strings("Hello", ", wor", "ld.", "\n", NULL);
  return 0;
}
