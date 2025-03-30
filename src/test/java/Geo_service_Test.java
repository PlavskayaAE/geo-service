import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class Geo_service_Test {

    @Test
    public void MessageSenderImpl_test_RU() {
        GeoServiceImpl geoServiceimpl = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoServiceimpl.byIp("172.123.12.19")).thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));

        LocalizationServiceImpl localizationServiceImpl = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationServiceImpl.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        MessageSenderImpl messageSenderImpl = new MessageSenderImpl(geoServiceimpl, localizationServiceImpl);
        Map<String, String> headers = new HashMap<>();
        headers.put("x-real-ip", "172.123.12.19");

        String messageSender = messageSenderImpl.send(headers);
        String expected = "Отправлено сообщение: Добро пожаловать";

        Assert.assertEquals(messageSender,expected);
    }

}
