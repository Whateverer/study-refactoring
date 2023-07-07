package me.whiteship.refactoring._18_middle_man._40_replace_subclass_with_delegate;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {

    @Test
    void talkback() {
        Show nonTalkbackShow = new Show(List.of(), 120);
        Show talkbackShow = new Show(List.of("talkback"), 120);
        LocalDateTime nonPeekday = LocalDateTime.of(2022, 1, 20, 19, 0);
        LocalDateTime peekday = LocalDateTime.of(2022, 1, 15, 19, 0);

        assertFalse(Booking.createBooking(nonTalkbackShow, nonPeekday).hasTalkback());
        assertTrue(Booking.createBooking(talkbackShow, nonPeekday).hasTalkback());
        assertFalse(Booking.createBooking(talkbackShow, peekday).hasTalkback());

        PremiumExtra premiumExtra = new PremiumExtra(List.of(), 50);
        assertTrue(Booking.createPreminumBooking(talkbackShow, peekday, premiumExtra).hasTalkback());
        assertFalse(Booking.createPreminumBooking(nonTalkbackShow, peekday, premiumExtra).hasTalkback());
    }

    @Test
    void basePrice() {
        Show lionKing = new Show(List.of(), 120);
        LocalDateTime weekday = LocalDateTime.of(2022, 1, 20, 19, 0);

        Booking booking = Booking.createBooking(lionKing, weekday);
        assertEquals(120, booking.basePrice());

        Booking premium = Booking.createPreminumBooking(lionKing, weekday, new PremiumExtra(List.of(), 50));
        assertEquals(170, premium.basePrice());
    }

    @Test
    void basePrice_on_peakDay() {
        Show lionKing = new Show(List.of(), 120);
        LocalDateTime weekend = LocalDateTime.of(2022, 1, 15, 19, 0);

        Booking booking = Booking.createBooking(lionKing, weekend);
        assertEquals(138, booking.basePrice());

        Booking premium = Booking.createPreminumBooking(lionKing, weekend, new PremiumExtra(List.of(), 50));
        assertEquals(188, premium.basePrice());
    }


    @Test
    void hasDinner() {
        Show lionKing = new Show(List.of(), 120);
        LocalDateTime weekday = LocalDateTime.of(2022, 1, 20, 19, 0);
        LocalDateTime weekend = LocalDateTime.of(2022, 1, 15, 19, 0);
        PremiumExtra premiumExtra = new PremiumExtra(List.of("dinner"), 50);

        assertTrue(Booking.createPreminumBooking(lionKing, weekday, premiumExtra).hasDinner());
        assertFalse(Booking.createPreminumBooking(lionKing, weekend, premiumExtra).hasDinner());
        assertFalse(Booking.createBooking(lionKing, weekday).hasDinner());
        assertFalse(Booking.createBooking(lionKing, weekend).hasDinner());
    }

}