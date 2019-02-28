package com.zenika.hashcode.hashcode2019.output;

import java.util.Arrays;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import com.zenika.hashcode.hashcode2019.input.Picture;

public class SlideshowTest  {

	@Test
	public void test_score_for_0_1_2_3() {
		Slideshow s = new Slideshow();
		s.getSlides().addAll(
				Arrays.asList(
/* 0 */				new HorizontalSlide(new Picture().tagged(Arrays.asList("cat", "beach", "sun"))),
				new VerticalSlide(
/* 1 */						new Picture().tagged(Arrays.asList("selfie", "smile")),
/* 2 */						new Picture().tagged(Arrays.asList("garden", "selfie"))),
/* 3 */				new HorizontalSlide(new Picture().tagged(Arrays.asList("garden", "cat")))
				));
		Assert.assertThat(s.score(), Is.is(1l));
	}

	@Test
	public void test_score_for_0_3_1_2() {
		Slideshow s = new Slideshow();
		s.getSlides().addAll(
				Arrays.asList(
/* 0 */				new HorizontalSlide(new Picture().tagged(Arrays.asList("cat", "beach", "sun"))),
/* 3 */				new HorizontalSlide(new Picture().tagged(Arrays.asList("garden", "cat"))),
				new VerticalSlide(
/* 1 */						new Picture().tagged(Arrays.asList("selfie", "smile")),
/* 2 */						new Picture().tagged(Arrays.asList("garden", "selfie")))
				));
		Assert.assertThat(s.score(), Is.is(2l));
	}

	@Test
	public void perf() {
		Slideshow s = new Slideshow();
		s.slides.addAll(
				Arrays.asList(
						/* 0 */				new HorizontalSlide(new Picture().tagged(Arrays.asList("cat", "beach", "sun"))),
						/* 3 */				new HorizontalSlide(new Picture().tagged(Arrays.asList("garden", "cat"))),
						new VerticalSlide(
								/* 1 */						new Picture().tagged(Arrays.asList("selfie", "smile")),
								/* 2 */						new Picture().tagged(Arrays.asList("garden", "selfie")))
				));

		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000000l; i++) {
			s.score();
		}
		long end = System.currentTimeMillis();
		System.out.println("TIME : " + (end - start) + " ms");
	}
}
