package br.ce.wcaquino.taskbackend.utils;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilsTest {
    private static LocalDate dataAtual = LocalDate.now();

    @Test
    public void validarDataPassada() {
        Assert.assertFalse(DateUtils.isEqualOrFutureDate(dataAtual.plusMonths(-1)));
    }

    @Test
    public void validarDataPresente() {
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(dataAtual));
    }

    @Test
    public void validarDataFutura() {
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(dataAtual.plusMonths(1)));
    }

}
