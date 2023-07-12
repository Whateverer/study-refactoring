package me.whiteship.refactoring;

public class GuardClauses {
    public int getPoints() {
        if (isVip()) return vipPoint();
        if (isPlat()) return platPoint();
        return normalPoint();
    }

    private boolean isVip() {
        return false;
    }

    private int vipPoint() {
        return 0;
    }

    private boolean isPlat() {
        return false;
    }

    private int platPoint() {
        return 0;
    }

    private int normalPoint() {return 0;}
}
