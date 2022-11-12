package com.aor.numbers;
import spock.lang.Specification


class DivisibleByFilterSpock extends Specification{
    def "divisible by 2"() {
        given:
            def filter = new DivisibleByFilter(2)
        when:
            def divisible = Arrays.asList(2, 4, 6, 8, 10)
            def notDivisible = Arrays.asList(1,3,5,7,9)
        then:
            divisible.each {assert filter.accept(it)}
            notDivisible.each {assert !filter.accept(it)}
    }


    void acceptdivideby3() {
        given:
            def filter = new DivisibleByFilter(3)
        when:
            def divisible = Arrays.asList(0, 3, 6, 9, 300);
            def notDivisible = Arrays.asList(1, 2, 10, 100, 1000, 10000);

        then:
            divisible.each {assert filter.accept(it)}
            notDivisible.each {assert !filter.accept(it)}
    }



}
