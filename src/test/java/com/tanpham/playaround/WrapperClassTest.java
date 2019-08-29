package com.tanpham.playaround;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class WrapperClassTest {

    @Test
    public void booleanWrapper_valueOfZero_shouldBeFalse() {
        assertThat(Boolean.valueOf("0"), equalTo(Boolean.FALSE));
    }
    
    @Test
    public void booleanWrapper_valueOfOne_shouldBeFalse() {
        assertThat(Boolean.valueOf("1"), equalTo(Boolean.FALSE));
    }
    
    @Test
    public void booleanWrapper_valueOfTrueString_shouldBeTrue() {
        assertThat(Boolean.valueOf("true"), equalTo(Boolean.TRUE));
    }
    
    @Test
    public void booleanWrapper_valueOfNotTrueString_shouldBeFalse() {
        assertThat(Boolean.valueOf("false"), equalTo(Boolean.FALSE));
        assertThat(Boolean.valueOf("null"), equalTo(Boolean.FALSE));
        assertThat(Boolean.valueOf(""), equalTo(Boolean.FALSE));
    }
    
    /*
     * 
     * Boolean, Double, and Integer
     * 
     */
    @Test
    public void constructorWays_fromConstructor_shouldBeTotallyNewInstance() {
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);
        assertThat(i1 == i2, equalTo(false));
    }
    
    @Test
    public void constructorWays_fromConstructor_andFromFactoryMethod_shouldNotBeEqual() {
        Integer i1 = new Integer(1);
        Integer i2 = Integer.valueOf(1);
        assertThat(i1 == i2, equalTo(false));
    }
    
    @Test
    public void constructorWays_fromFactoryMethod_afterTheValueIsInitiated_nextInstanceShouldPickFromTheCache() {
        Integer i1 = Integer.valueOf(1);
        Integer i2 = Integer.valueOf(1);
        assertThat(i1 == i2, equalTo(true));
    }
    
    @Test
    public void constructorWays_fromFactoryMethod_afterTheValueIsInitiated_nextInstanceShouldPickFromTheCache_StringCase() {
        Integer i1 = Integer.valueOf("1");
        Integer i2 = Integer.valueOf("1");
        assertThat(i1 == i2, equalTo(true));
    }
    
    /*
     * this method means that the autoBoxing by assigning an Integer value = 1, will use the cache for initiating value.
     * Note the cache range will be from -128 to 127
     */
    @Test
    public void constructorWays_fromFactoryMethod_autoBoxingShouldUseTheCacheAlso() {
        Integer i1 = Integer.valueOf("1");
        Integer i2 = 1;
        assertThat(i1 == i2, equalTo(true));
    }
    
    
    
}
