package me.whiteship.refactoring._06_mutable_data._23_change_reference_to_value;

public record TelephoneNumber(String areaCode, String number) { // java 17 version 이후에는 record 사용

    /*
    // java 17 version 이전에서 immutable한 객체를 만들 때 사용됨
    private final String areaCode;

    private final String number;

    public TelephoneNumber(String areaCode, String number) {
        this.areaCode = areaCode;
        this.number = number;
    }
    public String areaCode() {
        return areaCode;
    }

    public String number() {
        return number;
    }

    // 같은 값을 가지고 있는 value라면 같은 객체라고 인정
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelephoneNumber that = (TelephoneNumber) o;
        return Objects.equals(areaCode, that.areaCode) && Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, number);
    }*/
}
