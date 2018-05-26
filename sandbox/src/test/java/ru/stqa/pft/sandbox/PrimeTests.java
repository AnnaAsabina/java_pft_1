package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Integer.*;

public class PrimeTests {
  @Test
  public void testPrimes(){
    Assert.assertTrue(Primes.isPrimeFast(MAX_VALUE));
  }
  @Test
  public void testNonPrimes(){
    Assert.assertFalse(Primes.isPrime(MAX_VALUE-2));

  }

  @Test
  public void testPrimesLong(){
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrimeLong(n));
  }
}
