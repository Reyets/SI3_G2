/*  Affichage du nombre d'occurrences de lettres et chiffres lus sur stdin  */
#include <stdio.h>

int main()
{
  int letters[26]  = {};
  int digits[10]   = {};
  int c;

  while ((c=getchar())!=EOF)
    if ('0' <= c && c <= '9') digits[c - '0'] += 1;
    else
      if ('a' <= c && c <= 'z') letters[c - 'a'] += 1;
      else
	     if ('A' <= c && c <= 'Z') letters[c - 'A'] += 1;

  for (c = '0'; c <= '9'; c++)
    printf("%c %3d\n", c, digits[c - '0']);
  for (c = 'a'; c <= 'z'; c++)
    printf("%c %3d\n", c, letters[c - 'a']);

  return 0;
}
