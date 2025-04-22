package ru.netology.geo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

public class GeoServiceImplTest {
    GeoServiceImpl geoService = new GeoServiceImpl();


    @Test
    public void byIp_test_Local() {
        Location expected = new Location(null, null, null, 0);
        Location actual = geoService.byIp("127.0.0.1");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void byIp_test_Moscow() {
        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        Location actual = geoService.byIp("172.0.32.11");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void byIp_test_NewYork() {
        Location expected = new Location("New York", Country.USA, " 10th Avenue", 32);
        Location actual = geoService.byIp("96.44.183.149");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void byIp_test_Russian() {
        Location expected = new Location("Moscow", Country.RUSSIA, null, 0);
        Location actual = geoService.byIp("172.123.12.19");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void byIp_test_American() {
        Location expected = new Location("New York", Country.USA, null, 0);
        Location actual = geoService.byIp("96.123.12.19");
        Assertions.assertEquals(expected, actual);
    }

}


    
