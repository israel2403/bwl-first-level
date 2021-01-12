package com.mx.bwl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
