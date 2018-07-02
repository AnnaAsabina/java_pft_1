package ru.stqa.pft.soap;



import com.lavasoft.GeoIPService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GeoIpServiceTests {
  @Test
  public void testMyIp() {

    String geoIP = new GeoIPService().getGeoIPServiceSoap12().getIpLocation20("79.126.28.170");
   Assert.assertEquals(geoIP.contains("RU"),true);

  }
}