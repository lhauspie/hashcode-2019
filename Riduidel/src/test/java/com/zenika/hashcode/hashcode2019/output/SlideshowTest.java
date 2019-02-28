package com.zenika.hashcode.hashcode2019.output;

<<<<<<< HEAD
=======
import static org.junit.Assert.*;

>>>>>>> d9013754f89ccabec1b7ff2ab86fbd6f07211935
import java.util.Arrays;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import com.zenika.hashcode.hashcode2019.input.Picture;

<<<<<<< HEAD
public class SlideshowTest {

  @Test
  public void testName() throws Exception {
    Slideshow ss = new Slideshow();
    
    Slide first = new HorizontalSlide(new Picture().tagged(Arrays.asList("cat", "bitch", "sun")));
    Slide second= new HorizontalSlide(new Picture().tagged(Arrays.asList("garden", "cat")));
    Slide third = new VerticalSlide(
        new Picture().tagged(Arrays.asList("selfie", "smile" )),
        new Picture().tagged(Arrays.asList("garden", "selfie" ))
            );
    
    ss.slides.add(first);
    ss.slides.add(second);
    ss.slides.add(third);
    
    Assert.assertThat(ss.score(), Is.is(2L));
  }
=======
public class SlideshowTest  {

	@Test
	public void test_score_for_0_1_2_3() {
		Slideshow s = new Slideshow();
		s.slides.addAll(
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
		s.slides.addAll(
				Arrays.asList(
/* 0 */				new HorizontalSlide(new Picture().tagged(Arrays.asList("cat", "beach", "sun"))),
/* 3 */				new HorizontalSlide(new Picture().tagged(Arrays.asList("garden", "cat"))),
				new VerticalSlide(
/* 1 */						new Picture().tagged(Arrays.asList("selfie", "smile")),
/* 2 */						new Picture().tagged(Arrays.asList("garden", "selfie")))
				));
		Assert.assertThat(s.score(), Is.is(2l));

	}

>>>>>>> d9013754f89ccabec1b7ff2ab86fbd6f07211935
}
