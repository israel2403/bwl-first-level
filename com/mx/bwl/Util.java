package com.mx.bwl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Util {
	public static String[][] createMatrix(final String[] strDNA) {
		final Integer limit = strDNA.length;
		String[][] matrix = new String[limit][limit];
		for (int i = 0; i < strDNA.length; i++) {
			final String[] str = strDNA[i].split(" ");
			for (int j = 0; j < str.length; j++) {
				matrix[i][j] = str[j];
			}
		}
		return matrix;
	}

	public static void printMatrix(final String[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "-");
			}
			System.out.println("");
		}
	}
	
	@SafeVarargs
	public static <T> List<T> concat(List<T>... lists) {
	    return Stream.of(lists).flatMap(List::stream).collect(Collectors.toList());
	}
}