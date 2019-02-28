package com.zenika.hashcode.hashcode2019.output;

import java.util.Arrays;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import com.zenika.hashcode.hashcode2019.input.Picture;

public class SlideTest {

	@Test
	public void test_disjuncted() {

		Slide first = new HorizontalSlide(new Picture().tagged(Arrays.asList("cat")));
		Slide second = new HorizontalSlide(new Picture().tagged(Arrays.asList("selfie", "smile")));
		Assert.assertThat(first.score(second), Is.is(0l));
	}

	@Test
	public void test_with_same_infrst() {
		Slide first = new HorizontalSlide(new Picture().tagged(Arrays.asList("cat")));
		Slide second = new HorizontalSlide(new Picture().tagged(Arrays.asList("cat", "selfie", "smile")));
		Assert.assertThat(first.score(second), Is.is(0l));
	}


	@Test
	public void test_with_same_tags() {
		Slide first = new HorizontalSlide(new Picture().tagged(Arrays.asList("selfie", "smile")));
		Slide second = new HorizontalSlide(new Picture().tagged(Arrays.asList("selfie", "smile")));
		Assert.assertThat(first.score(second), Is.is(0l));
	}

	@Test
	public void test_with_two_commons() {
		Slide first = new HorizontalSlide(new Picture().tagged(Arrays.asList("selfie", "smile", "cat")));
		Slide second = new HorizontalSlide(new Picture().tagged(Arrays.asList("selfie", "smile", "dog")));
		Assert.assertThat(first.score(second), Is.is(1l));
	}

	@Test
	public void test_standard_value() {
		Slide first = new HorizontalSlide(new Picture().tagged(Arrays.asList("cat", "garden")));
		Slide second = new HorizontalSlide(new Picture().tagged(Arrays.asList("garden", "selfie", "smile")));
		Assert.assertThat(first.score(second), Is.is(1l));
	}

}
