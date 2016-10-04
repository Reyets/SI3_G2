/*
 * 5_chaines.c          Re-définition des fonctions C strcpy, strcmp, strupper
 *
 *           Author: Erick Gallesio [eg@unice.fr]
 *    Creation date: 25-Sep-2015 09:17 (eg)
 * Last file update:  1-Oct-2016 21:37 (eg)
 */

#include <stdio.h>

void strcpy1(char s1[], char s2[]) {    // 1ere version
  int i = 0;

  for (i = 0; s2[i] != '\0'; i++)
    s1[i] = s2[i];

  // Ne pas oublier le '\0' final
  s1[i] = '\0';
}


void strcpy2(char s1[], char s2[]) {    // 2e version
  int i = 0;

  do {
    s1[i] = s2[i];
  } while (s2[i++] != '\0');
}

int strcmp(char s1[], char s2[]) {
  int i;

  for (i = 0; s1[1] != '\0' && s1[i] == s2[i]; i++) {
  }
  return s1[i] - s2[i];
}

void strupper(char s[]) {
  int i;

  for (i = 0; s[i] != '\0'; i++) {
    if ('a' <= s[i] && s[i] <= 'z') // Vérifier que l'on a bien une minuscule
      s[i] += 'A' - 'a';
  }
}

int main() {
  char tab[256];
  int comp;

  strcpy1(tab, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
  printf("tab = %s\n", tab);

  strcpy2(tab, "Hello!");
  printf("tab = %s\n", tab);

  comp = strcmp("ABCD", "ABCD");
  printf("'ABCD' et 'ABCD' => %d\n", comp);

  comp = strcmp("ABCD", "AB");
  printf("'ABCD' et 'AB' => %d\n", comp);

  comp = strcmp(tab, "AB");
  printf("'%s' et 'AB' => %d\n", tab, comp);


  strupper(tab);
  printf("upper = %s\n", tab);

  return 0;
}
