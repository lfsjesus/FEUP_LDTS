package com.aor.numbers

import spock.lang.Specification;

class ListSorterSpock extends Specification{
    List<Integer> list
    List<Integer> expected

    def "setup"() {
        list = Arrays.asList(3, 2, 6, 1, 4, 5, 7);
        expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
    }

    def "sort"() {
        given:
            def sorter = new ListSorter()
        when:
            def result = sorter.sort(list)
        then:
            result == expected
    }

    def "sorterbug_8726"() {
        given:
            def sorter = new ListSorter()
        when:
            def result = sorter.sort([1,2,-1,4,2])
        then:
            result == [-1,1,2,2,4]
    }
}
