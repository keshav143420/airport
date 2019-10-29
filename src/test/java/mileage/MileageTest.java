package mileage;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MileageTest {

    private Mileage mileage;

    @BeforeAll
    void beforeAll() {
        mileage = new Mileage();
    }
}
