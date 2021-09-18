package com.personal.javaresume.utilities.enums;
import java.util.stream.Stream;

public enum AddressType {

	TEMP,
	PERM,
	OTHER;

	public static String[] getList() {
		return Stream.of(AddressType.values()).map(f -> "'" + f + "'").toArray(String[]::new);
	}

}
