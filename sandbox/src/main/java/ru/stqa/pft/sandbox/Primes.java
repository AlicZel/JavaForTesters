package ru.stqa.pft.sandbox;

public class Primes {

  public static boolean isPrime(int n) {

    for (int i = 2; i < n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPrimeFast(int n) {
    int m = (int) Math.sqrt(n); // np. 6=2*3 ,sqrt(6) =2,4 jest większe od 2 , liczba jesli posiada jeden dzielnik,
    // to posiada też drugi dzielnik a i b , jeden z nich jest mniejszy niż pierwiastek z tej liczby, stad mozna
    // szukac dzielnika wsród liczb mniejszych równych pierwiastek z n
    for (int i = 2; i < m; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPrimeWhile(int n) {
    int i = 2;
    while (i < n && n % i != 0 )
    {
      i++;
      }
      return i==n;
    }

  public static boolean isPrime(long n) {

    for (long i = 2; i < n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

}
//Tworzac petle nalezy sprawdzac wydajność. Trzeba dążyc do tego,
// //aby było jak najmniej cykli, np. zamiast szukać
// podzielników
// do n , szukamy tylko do
// pierwiastek z n
//oraz zeby działanie na jednym cyklu było jak najkrótsze np. poprzez stosowanie odpowidnich typów zmiennych
//int a nie long