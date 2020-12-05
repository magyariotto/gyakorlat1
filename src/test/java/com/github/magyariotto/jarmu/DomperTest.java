package com.github.magyariotto.jarmu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.fail;

public class DomperTest {
    private static final int KAPACITAS = 100;
    private static final int SEBESSEG = 90;

    private Domper underTest;

    @Before
    public void setUp() {
        underTest = new Domper(KAPACITAS, SEBESSEG);
    }

    @After
    public void tearDown() {
        assertThat(underTest.getRakomany()).isEqualTo(0);
    }

    @Test
    public void motorBeindit_shouldSetJarAMotorTrue() {
        //GIVEN

        //When
        underTest.motorBeindul();

        //THEN
        if (!underTest.isJarAMotor()) {
            throw new AssertionError("A jarAMotor nem lehet false.");
        }
    }

    @Test
    public void motorLeallit_shouldSetJarAMotorFalse() {
        //GIVEN
        underTest.motorBeindul();
        //WHEN
        underTest.motorMegall();
        //THEN
        assertThat(underTest.isJarAMotor()).isFalse();
    }

    @Test(expected = IllegalStateException.class)
    public void platoKinyit_shouldThrowException_whenSebessegIsNotZero() {
        //GIVEN
        underTest.setSebesseg(1);
        //WHEN
        underTest.platoKinyit();
    }

    @Test
    public void elindul_shouldThrowException_whenSebessegIsNotZero() throws NemJarAMotorException {
        //GIVEN
        underTest.setSebesseg(1);
        //WHEN
        try {
            underTest.elindul(32);
        } catch (IllegalStateException e) {
            assertThat(underTest.getSebesseg()).isEqualTo(1);
            return;
        }

        fail("Excepted IllegalStateException was not thrown.");
    }

    @Test
    public void elindul_shouldThrowException_whenNemJarAMotor() {
        //WHEN
        Throwable ex = catchThrowable(() -> underTest.elindul(32));
        //THEN
        assertThat(ex).isInstanceOf(NemJarAMotorException.class);
        assertThat(underTest.getSebesseg()).isEqualTo(0);
    }
//*********************HAZI******************************
    @Test
    public void platoBecsuk() {
        //GIVEN
        underTest.platoKinyit();
        //WHEN
        underTest.platoBecsuk();
        //THEN
        if (underTest.isPlatoNyitva()) {
            throw new AssertionError("A platoNyitva nem lehet true.");
        }
    }

    @Test
    public void domperMegall_haASebessegNemZero() {
        //GIVEN
        underTest.motorBeindul();
        //WHEN
        underTest.motorMegall();
        //THEN
        if (underTest.getSebesseg() != 0) {
            throw new AssertionError("A sebessegnek 0 kell legyen.");
        }
    }

    @Test
    public void gyorsit_haAMaxSebessegetElerted() throws NemJarAMotorException {
        //GIVEN
        underTest.motorBeindul();
        //WHEN
        underTest.gyorsit(SEBESSEG);
        //THEN
        if(underTest.getSebesseg() > underTest.getMaxSebesseg()){
            throw new AssertionError("Nem lehet a max sebesseg fole gyorsitani.");
        }
    }
    @Test
    public void gyorsit_haAMotorNemJar() throws NemJarAMotorException {
        //GIVEN
        underTest.motorBeindul();
        //WHEN
        underTest.gyorsit(SEBESSEG);
        //THEN
        if(!underTest.isJarAMotor()){
            throw new AssertionError("Leallitott motorral nem lehet gyostiani.");
        }
    }

    @Test
    public void gyorsi_haAPlatoNyitva() throws NemJarAMotorException {
        //GIVEN
        underTest.motorBeindul();
        //WHEN
        underTest.gyorsit(SEBESSEG);
        //THEN
        if (underTest.isPlatoNyitva()){
            throw new AssertionError("Nyitot platoval nem lehet gyorsitani.");
        }
    }

    @Test
    public void felrakod_haTeleADomper(){
        //GIVEN
        //WHEN
        underTest.felrakod(underTest.getRakomany());
        //THEN
        if(underTest.getRakomany() > KAPACITAS){
            throw new AssertionError("Nem haladhatod meg a max kapacittast.");
        }
    }

    @Test
    public void felrakod_haAsebessegnemZero(){
        //GIVEN
        underTest.motorMegall();
        //WHEN
        underTest.felrakod(underTest.getRakomany());
        //THEN
        if(underTest.getSebesseg() != 0){
            throw new AssertionError("Mosgo jarmut nem lehet felrakodni.");
        }
    }

    @Test
    public void lerakod_haAMotorJar(){
        //GIVEN
        underTest.platoKinyit();
        //WHEN
        underTest.lerakod();
        //THEN
        if(underTest.isJarAMotor()){
            throw new AssertionError("Jaro motoral nem lehet elkezeeni a lerakodast.");
        }
    }

    @Test
    public void lerakod_haASebessegNemZero(){
        //GIVEN
        underTest.platoKinyit();
        //WHEN
        underTest.lerakod();
        //THEN
        if(underTest.getSebesseg() != 0){
            throw new AssertionError("Mozgo jarmuvet nem lehet lerakodni");
        }
    }
}