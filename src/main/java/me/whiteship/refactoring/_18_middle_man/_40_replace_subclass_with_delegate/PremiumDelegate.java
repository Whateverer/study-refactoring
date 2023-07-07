package me.whiteship.refactoring._18_middle_man._40_replace_subclass_with_delegate;

public class PremiumDelegate {
    private Booking host;
    private PremiumExtra extra;

    public PremiumDelegate(Booking booking, PremiumExtra premiumExtra) {
        this.host = booking;
        this.extra = premiumExtra;
    }

    public boolean hasTalkback() {
        return this.host.show.hasOwnProperty("talkback");
    }
    public double extendBasePrice(double result) {
        return Math.round(result + this.extra.getPremiumFee());
    }

    public boolean hasDinner() {
        return this.extra.hasOwnProperty("dinner") && !host.isPeakDay();
    }

}
