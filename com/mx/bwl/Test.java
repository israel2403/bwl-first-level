package com.mx.bwl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void main(String args[]) {
		String[] strDNA = new String[6];
		strDNA[0] = "C C C C G A";
		strDNA[1] = "C A G T G C";
		strDNA[2] = "T T A T T T";
		strDNA[3] = "A G T C G G";
		strDNA[4] = "G C G G C A";
		strDNA[5] = "T C A C T G";
		
		DNADetectable dnaDetectable = new DNADetectableImpl();
		final List<String> strDNAList = Arrays.asList(strDNA);
		final List<String> verticalPatternList = dnaDetectable.extractVerticalPattern(strDNAList);
		final List<String> diagonalPatternFromRightToLeftList = dnaDetectable
				.extracDiagonalPattternFromRigthToLeft(Util.createMatrix(strDNA));
		final List<String> diagonalPatternFromLeftToRightList = dnaDetectable
				.extractDiagonalPatternFromLeftToRight(Util.createMatrix(strDNA));
		final boolean answer = dnaDetectable.searchForMutation(Util.concat(verticalPatternList,
				diagonalPatternFromRightToLeftList, diagonalPatternFromLeftToRightList, strDNAList));
		System.out.println(answer);
	}
}
