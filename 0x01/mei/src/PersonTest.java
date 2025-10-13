package src;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.Date;

public class PersonTest {

    private Person person;

    @Before
    public void setup() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2000); // define ano de nascimento
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date birthDate = calendar.getTime();

        person = new Person("Paul", "McCartney", birthDate, true, true, true);
        person.setSalary(1200f);
    }

    @Test
    public void show_full_name() {
        assertEquals("Paul McCartney", person.fullName());
    }

    @Test
    public void test_calculateYearlySalary() {
        assertEquals(14400f, person.calculateYearlySalary(), 0.01f);
    }

    @Test
    public void person_is_MEI() {
        person.setAnotherCompanyOwner(false);
        person.setPensioner(false);
        person.setPublicServer(false);
        person.setSalary(10000f / 12); // salário mensal que gera anual < 130000
        assertTrue(person.isMEI());
    }

    @Test
    public void person_is_not_MEI() {
        person.setAnotherCompanyOwner(true);
        person.setPensioner(true);
        person.setPublicServer(true);
        assertFalse(person.isMEI());
    }
}
