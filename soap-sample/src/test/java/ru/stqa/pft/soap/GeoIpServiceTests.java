package ru.stqa.pft.soap;


import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GeoIpServiceTests {
  @Test
  public void testMyIp() {

    GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("79.126.28.170");
   Assert.assertEquals(geoIP.getCountryCode(),"RUS");

  }
}