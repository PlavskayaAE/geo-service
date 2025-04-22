package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;


public class LocalizationServiceImplTest {

    LocalizationServiceImpl localizationService = new LocalizationServiceImpl();

    @Test

    public void shouldRussia() {
        String expected = "Добро пожаловать";
        String actual = localizationService.locale(Country.RUSSIA);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Передаем в параметры метода USA")
    public void shouldUsa() {
        String expected = "Welcome";
        String actual = localizationService.locale(Country.USA);
        Assertions.assertEquals(expected, actual);
    }
}
