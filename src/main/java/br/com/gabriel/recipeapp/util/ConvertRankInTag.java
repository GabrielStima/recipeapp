package br.com.gabriel.recipeapp.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class ConvertRankInTag {
	public static int convertRankInTag(BigDecimal numberRank, Integer numberOfTags) {
		int resultIndex = 0;

		BigDecimal onePorcent = new BigDecimal("100", new MathContext(2, RoundingMode.HALF_EVEN))
				.multiply(new BigDecimal("1", new MathContext(2, RoundingMode.HALF_EVEN)).divide(
						new BigDecimal("" + numberOfTags.toString() + "", new MathContext(2, RoundingMode.HALF_EVEN)),
						2, RoundingMode.HALF_UP));

		BigDecimal rankPorcent = new BigDecimal("100", new MathContext(2, RoundingMode.HALF_EVEN))
				.multiply(numberRank.divide(new BigDecimal("5", new MathContext(2, RoundingMode.HALF_EVEN))));

		for (Integer i = 0; i <= numberOfTags; i++) {
			if (i == 0) {
				if (rankPorcent.compareTo(onePorcent) <= 0) {
					resultIndex = i;
				}
			}

			if (i == numberOfTags) {
				if (rankPorcent.compareTo(onePorcent.multiply(new BigDecimal("" + numberOfTags.toString() + "",
						new MathContext(2, RoundingMode.HALF_EVEN)))) >= 0) {
					resultIndex = i;
				}
			}

			if (rankPorcent
					.compareTo(onePorcent.multiply(new BigDecimal(i, new MathContext(2, RoundingMode.HALF_EVEN)))) > 0
					&& rankPorcent.compareTo(onePorcent
							.multiply(new BigDecimal(i+1, new MathContext(2, RoundingMode.HALF_EVEN)))) <= 0) {
				resultIndex = i;
			}
		}

		return resultIndex;

	}
}
