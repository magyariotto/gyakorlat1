package com.github.magyariotto.jarmu;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class DomperTest {
    private static final int KAPACITAS = 100;
    private static final int MAX_SEBESSEG = 90;

    private Domper underTest;

    @Before
    public void setUp() {
        underTest = new Domper(KAPACITAS, MAX_SEBESSEG);
    }

    @Test
    public void motorBeindit() {
        //WHEN
        underTest.motorBeindul();
        //THEN
        assertThat(underTest.isJarAMotor()).isTrue();
    }

    @Test
    public void motorLeallit() {
        //GIVEN
        underTest.setJarAMotor(true);

        //WHEN
        underTest.motorMegall();

        //THEN
        assertThat(underTest.isJarAMotor()).isFalse();
    }

    @Test
    public void platoKinyit_sebessegZero() {
        //WHEN
        underTest.platoKinyit();

        //THEN
        assertThat(underTest.isPlatoNyitva()).isTrue();
    }

    @Test
    public void platoKinyit_sebessegIsNotZero() {
        //GIVEN
        underTest.setSebesseg(1);
        //WHEN
        Throwable ex = catchThrowable(() -> underTest.platoKinyit());

        //THEN
        assertThat(ex).isInstanceOf(IllegalStateException.class);
        assertThat(underTest.isPlatoNyitva()).isFalse();
    }

    @Test
    public void platoBecsuk() {
        //GIVEN
        underTest.setPlatoNyitva(true);

        //WHEN
        underTest.platoBecsuk();

        //THEN
        assertThat(underTest.isPlatoNyitva()).isFalse();
    }

    @Test
    public void elindul_sebessegIsNotZero() {
        //GIVEN
        underTest.setJarAMotor(true);
        underTest.setSebesseg(1);

        //WHEN
        Throwable ex = catchThrowable(() -> underTest.elindul(10));

        //THEN
        assertThat(ex).isInstanceOf(IllegalStateException.class);
        assertThat(underTest.getSebesseg()).isEqualTo(1);
    }

    @Test
    public void elindul_platoIsNyitva() {
        //GIVEN
        underTest.setPlatoNyitva(true);
        underTest.setJarAMotor(true);

        //WHEN
        Throwable ex = catchThrowable(() -> underTest.elindul(10));

        //THEN
        assertThat(ex).isInstanceOf(IllegalStateException.class);
        assertThat(underTest.getSebesseg()).isEqualTo(0);
    }

    @Test
    public void elindul_nemJarAMotor() {
        //WHEN
        Throwable ex = catchThrowable(() -> underTest.elindul(10));

        //THEN
        assertThat(ex).isInstanceOf(NemJarAMotorException.class);
        assertThat(underTest.getSebesseg()).isEqualTo(0);
    }

    @Test
    public void elindul_tooFast() {
        //GIVEN
        underTest.setJarAMotor(true);

        //WHEN
        Throwable ex = catchThrowable(() -> underTest.elindul(MAX_SEBESSEG + 1));

        //THEN
        assertThat(ex).isInstanceOf(IllegalArgumentException.class);
        assertThat(underTest.getSebesseg()).isEqualTo(0);
    }

    @Test
    public void elindul() throws NemJarAMotorException {
        //GIVEN
        underTest.setJarAMotor(true);

        //WHEN
        underTest.elindul(MAX_SEBESSEG);

        //THEN
        assertThat(underTest.getSebesseg()).isEqualTo(MAX_SEBESSEG);
    }

    @Test
    public void gyorsit_nemJarAMotor() {
        //WHEN
        Throwable ex = catchThrowable(() -> underTest.gyorsit(10));

        //THEN
        assertThat(ex).isInstanceOf(NemJarAMotorException.class);
        assertThat(underTest.getSebesseg()).isEqualTo(0);
    }

    @Test
    public void gyorsit_platoNyitva() {
        //GIVEN
        underTest.setJarAMotor(true);
        underTest.setPlatoNyitva(true);

        //WHEN
        Throwable ex = catchThrowable(() -> underTest.gyorsit(10));

        //THEN
        assertThat(ex).isInstanceOf(IllegalStateException.class);
        assertThat(underTest.getSebesseg()).isEqualTo(0);
    }

    @Test
    public void gyorsit_tooFast() {
        //GIVEN
        underTest.setJarAMotor(true);

        //WHEN
        Throwable ex = catchThrowable(() -> underTest.gyorsit(MAX_SEBESSEG + 1));

        //THEN
        assertThat(ex).isInstanceOf(IllegalArgumentException.class);
        assertThat(underTest.getSebesseg()).isEqualTo(0);
    }

    @Test
    public void gyorsit() throws NemJarAMotorException {
        //GIVEN
        underTest.setJarAMotor(true);
        underTest.setSebesseg(30);

        //WHEN
        underTest.gyorsit(10);

        //THEN
        assertThat(underTest.getSebesseg()).isEqualTo(40);
    }

    @Test
    public void megall() {
        //GIVEN
        underTest.setSebesseg(MAX_SEBESSEG);

        //WHEN
        underTest.megall();

        //THEN
        assertThat(underTest.getSebesseg()).isEqualTo(0);
    }

    @Test
    public void felrakod_tulNagyRakomany() {
        //WHEN
        Throwable ex = catchThrowable(() -> underTest.felrakod(KAPACITAS + 1));

        //WHEN
        assertThat(ex).isInstanceOf(TulSokRakomanyException.class);
        assertThat(underTest.getRakomany()).isEqualTo(0);
    }

    @Test
    public void felrakod() {
        //GIVEN
        underTest.setRakomany(10);

        //WHEN
        underTest.felrakod(20);

        //THEN
        assertThat(underTest.getRakomany()).isEqualTo(30);
    }

    @Test
    public void lerakod_platoCsukva() {
        //GIVEN
        underTest.setRakomany(10);

        //WHEN
        Throwable ex = catchThrowable(() -> underTest.lerakod());

        //THEN
        assertThat(ex).isInstanceOf(IllegalStateException.class);
        assertThat(underTest.getRakomany()).isEqualTo(10);
    }

    @Test
    public void lerakod() {
        //GIVEN
        underTest.setRakomany(10);
        underTest.setPlatoNyitva(true);

        //WHEN
        underTest.lerakod();

        //THEN
        assertThat(underTest.getRakomany()).isEqualTo(0);
    }
}