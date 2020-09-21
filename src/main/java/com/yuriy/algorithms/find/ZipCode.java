package com.yuriy.algorithms.find;

public class ZipCode implements Comparable<ZipCode> {

    private final String zipCode;

    public ZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public int compareTo(ZipCode other) {
        String[] first = this.zipCode.split("-");
        String[] second = other.zipCode.split("-");
        if (first[0].equals(second[0])) {
            if (first.length == second.length) {
                return first.length > 1 ? first[1].compareTo(second[1]) : 0;
            }
            return first.length < second.length ? -1 : 1;
        } else {
            return first[0].compareTo(second[0]);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZipCode zipCode1 = (ZipCode) o;

        return zipCode.equals(zipCode1.zipCode);
    }

    @Override
    public int hashCode() {
        return zipCode.hashCode();
    }

    @Override
    public String toString() {
        return zipCode;
    }
}
