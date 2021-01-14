package com.mx.bwl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : isra
 * @created : 2021-01-11
 **/

public class DNADetectableImpl implements DNADetectable {

	public DNADetectableImpl() {

	}

	@Override
	public boolean hasMutation(final String patternDNA) {
		final Pattern pattern = Pattern.compile(DNADetectable.MUTATION_PATTERN, Pattern.CASE_INSENSITIVE);
		final Matcher matcher = pattern.matcher(patternDNA);
		return matcher.find();
	}

	@Override
	public List<String> extractVerticalPattern(final List<String> listDNA) {
		String str = "";
		List<String> listDNAVertical = Arrays.asList(new String[listDNA.size()]);
		String dna = "";
		for (int i = 0; i < listDNA.size(); i++) {
			dna = listDNA.get(i).replace(" ", "");
			for (int j = 0; j < listDNA.size(); j++) {
				str = (listDNAVertical.get(j) == null) ? "" : listDNAVertical.get(j);
				str += dna.charAt(j);
				listDNAVertical.set(j, str);
			}
		}
		return listDNAVertical;
	}

	@Override
	public List<String> extracDiagonalPattternFromRigthToLeft(final String[][] matrixDNA) {
		final int matrixDNALength = matrixDNA.length;
		final int strDiagonalLimit = matrixDNALength - 4;
		int j = matrixDNALength - 1, i = strDiagonalLimit, k = 0, l = 0;
		String str = "";
		List<String> matrixDNADiagonal = new ArrayList<String>();
		while (j > strDiagonalLimit) {
			k = j;
			l = i;
			while (l < matrixDNALength && k >= 0) {
				str += matrixDNA[l][k];
				k--;
				l++;
			}
			if (i > 0)
				i--;
			else
				j--;
			matrixDNADiagonal.add(str);
			str = "";
		}
		return matrixDNADiagonal;
	}

	@Override
	public List<String> extractDiagonalPatternFromLeftToRight(final String[][] matrixDNA) {
		final int matrixDNALength = matrixDNA.length;
		final int strDiagonalLimit = matrixDNALength - 4;
		int j = 0, k = 0, l = 0, i = strDiagonalLimit;
		String str = "";
		List<String> matrixDNADiagonal = new ArrayList<String>();
		while (j <= strDiagonalLimit) {
			k = j;
			l = i;
			while (l < matrixDNALength && k < matrixDNALength) {
				str += matrixDNA[l][k];
				k++;
				l++;
			}
			if (i > 0)
				i--;
			else
				j++;
			matrixDNADiagonal.add(str);
			str = "";
		}
		return matrixDNADiagonal;
	}

	@Override
	public boolean searchForMutation(final List<String> patternDNAList) {
		return patternDNAList.stream().anyMatch(dnaPattern -> hasMutation(dnaPattern.replace(" ", "")));
	}
}
