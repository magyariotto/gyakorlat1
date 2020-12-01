package com.github.magyariotto.jarmu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.fail;

public class DomperTest {
    private static final int KAPACITAS = 100;
    private static final int SEBESSEG = 90;

    private Domper underTest;

    @Before
    public void setUp(){
        underTest = new Domper(KAPACITAS, SEBESSEG);
    }

    @After
    public void tearDown(){
        assertThat(underTest.getRakomany()).isEqualTo(0);
    }

    @Test
    public void motorBeindit_shouldSetJarAMotorTrue(){
        //GIVEN

        //When
        underTest.motorBeindul();

        //THEN
        if(!underTest.isJarAMotor()){
            throw new AssertionError("A jarAMotor nem lehet false.");
        }
    }

    @Test
    public void motorLeallit_shouldSetJarAMotorFalse(){
        //GIVEN
        underTest.motorBeindul();
        //WHEN
        underTest.motorMegall();
        //THEN
        assertThat(underTest.isJarAMotor()).isFalse();
    }

    @Test(expected = IllegalStateException.class)
    public void platoKinyit_shouldThrowException_whenSebessegIsNotZero(){
        //GIVEN
        underTest.setSebesseg(1);
        //WHEN
        underTest.platoKinyit();
    }

    @Test
    public void elindul_shouldThrowException_whenSebessegIsNotZero() throws NemJarAMotorException{
        //GIVEN
        underTest.setSebesseg(1);
        //WHEN
        try {
            underTest.elindul(32);
        }catch (IllegalStateException e){
            assertThat(underTest.getSebesseg()).isEqualTo(1);
            return;
        }

        fail("Excepted IllegalStateException was not thrown.");
    }

    @Test
    public void elindul_shouldThrowException_whenNemJarAMotor(){
        //WHEN
        Throwable ex = catchThrowable(()->underTest.elindul(32));
        //THEN
        assertThat(ex).isInstanceOf(NemJarAMotorException.class);
        assertThat(underTest.getSebesseg()).isEqualTo(0);
    }
}