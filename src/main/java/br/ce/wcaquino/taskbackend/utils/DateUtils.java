package br.ce.wcaquino.taskbackend.utils;

import java.time.LocalDate;

public abstract class DateUtils {

	public static boolean isEqualOrFutureDate(LocalDate date) {
		return date.isEqual(LocalDate.now()) || date.isAfter(LocalDate.now());
	}
}
