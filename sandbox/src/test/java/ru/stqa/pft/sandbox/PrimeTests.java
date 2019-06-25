package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.*;

public class PrimeTests {
  @Test
  public void testPrime(){ //ten test na wideo wykonuje się 8s
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
  }

  @Test
  public void testFastPrime(){ //ten test na wideo wykonuje się 8s
    Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));
  }

  @Test
  public void testNonPrime(){
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE-2));
  }

  @Test(enabled = false)
  public void testPrimeLong(){ // ten test na wideo wykonuje się 18 s
    long n=Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrime(n));
  }
  //wg wideo gorszy wydajnościowo jest test PrimeLong
  //ale wg mojego wykonanie testPrime wykonuje się 12s
  // a testPrimeLong wykonuje sie 9s


}
