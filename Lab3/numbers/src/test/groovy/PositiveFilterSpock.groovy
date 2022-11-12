package com.aor.numbers

import spock.lang.Specification;

class PositiveFilterSpock extends Specification{
    def "accept positives"() {
        given:
            def positives = [1, 2, 3, 10, 100, 1000, Integer.MAX_VALUE]
            def not_positives = [0, -1, -2, -3, -10, -100, -1000, Integer.MIN_VALUE]
        when:
            def filter = new PositiveFilter()
        then:
            positives.every {filter.accept(it)}
            !not_positives.every {filter.accept(it)}
    }
}
