/**********************************************************************
 *  M�nsterigenk�nning readme.txt
 **********************************************************************/

 Ungef�rligt antal timmar spenderade p� labben (valfritt):

/**********************************************************************
 *  Empirisk    Fyll i tabellen nedan med riktiga k�rtider i sekunder
 *  analys      n�r det k�nns vettigt att v�nta p� hela ber�kningen.
 *              Ge uppskattningar av k�rtiden i �vriga fall.
 *
 **********************************************************************/
    
      N       brute       sortering
 ----------------------------------
    150        36ms          16ms 
    200        52ms          23ms
    300        81ms          38ms 
    400        154ms         67ms
    800        834ms         169ms
   1600        6884ms        580ms
   3200        57'611ms      2227ms
   6400        ~500'000ms    8664ms
  12800        ~4'300'000ms  43342ms


/**********************************************************************
 *  Teoretisk   Ge ordo-uttryck f�r v�rstafallstiden f�r programmen som
 *  analys      en funktion av N. Ge en kort motivering.
 *
 **********************************************************************/

Brute: O(n^4)

Sortering: O(n^3*log(n)) Eftersom collection.sort är en merge-sort som har komplexitet n*log(n) och vi har 2 nästlade for-loopar på n
