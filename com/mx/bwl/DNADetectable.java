package com.mx.bwl;

import java.util.List;

/**
 * @author : isra
 * @created : 2021-01-11
 **/

public interface DNADetectable {

	public static final String MUTATION_PATTERN = "AAAA|CCCC|TTTT|GGGG";

	public boolean hasMutation(final String patternDNA);

	public List<String> extractVerticalPattern(final List<String> listDNA);

	public List<String> extracDiagonalPattternFromRigthToLeft(final String[][] matrixDNA);

	public List<String> extractDiagonalPatternFromLeftToRight(final String[][] matrixDNA);

	public boolean searchForMutation(final List<String> patternDNAList);
}
