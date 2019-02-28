package com.zenika.hashcode.hashcode2019.output;

import java.util.Arrays;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import com.zenika.hashcode.hashcode2019.input.Picture;

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
}
