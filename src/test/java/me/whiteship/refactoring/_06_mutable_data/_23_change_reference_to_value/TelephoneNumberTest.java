package me.whiteship.refactoring._06_mutable_data._23_change_reference_to_value;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelephoneNumberTest {
    @Test
    void testEquals() {
        TelephoneNumber telephoneNumber = new TelephoneNumber("123", "");
        TelephoneNumber telephoneNumber1 = new TelephoneNumber("123", "");

        assertEquals(telephoneNumber, telephoneNumber1);
    }
}