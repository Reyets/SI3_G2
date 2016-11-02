/*							-*- coding: utf-8 -*-
 * hlm.c	-- HLM: les grand ensembles
 *
 *           Author: Erick Gallesio [eg@unice.fr]
 *    Creation date: 22-Oct-2012 20:01 (eg)
 * Last file update: 12-Oct-2015 10:59 (eg)
 */

#include <stdio.h>

#define CHAR_SIZE  8			    /* nombre de bits dans un char */
#define MAX_BIGSET 125			    /* nombre de cellules dans un ens */
#define MAX_VAL    (CHAR_SIZE * MAX_BIGSET)

typedef unsigned char BIGSET[MAX_BIGSET];


void BIGSET_init(BIGSET bs) {
  int i;

  for (i = 0; i < MAX_BIGSET; i++)
    bs[i] = 0;
}

int BIGSET_in(BIGSET bs, int i) {
  int slot = i / CHAR_SIZE;
  int num  = i % CHAR_SIZE;

  return bs[slot] & (1 << num);
}


void BIGSET_add(BIGSET bs, int i){
  int slot = i / CHAR_SIZE;
  int num  = i % CHAR_SIZE;

  bs[slot] |= 1 << num;
}

void BIGSET_print(BIGSET bs)
{
  int i;
  int virgule=0;

  // Pour debugger: cela peut être pas mal....
  //   for (i = 0; i < MAX_BIGSET; i++)
  //     printf("%08x ", bs[i]);

  printf("{");
  for (i = 0; i < MAX_VAL; i++) {
    if (BIGSET_in(bs, i))
      printf("%s%d", (virgule++) ? ", ": "" , i);
  }
  printf("}\n");
}

void BIGSET_inter(BIGSET s1, BIGSET s2, BIGSET res)
{
  int i;
  for (i = 0; i < MAX_BIGSET; i++)
    res[i] = s1[i] & s2[i];
}



int main(void) {
  BIGSET e1, e2, e3;
  int i;

  BIGSET_init(e1); BIGSET_init(e2);

  for (i = 0; i < 40; i += 5) BIGSET_add(e2, i);
  for (i = 0; i < 40; i += 3) BIGSET_add(e1, i);

  BIGSET_inter(e1, e2, e3);
  printf("e1 = "); BIGSET_print(e1);
  printf("e2 = "); BIGSET_print(e2);
  printf("e3 = "); BIGSET_print(e3);

  return 0;
}
