package com.aor.numbers;
import spock.lang.Specification;

class ListDeduplicatorSpock extends Specification{
    private def list
    private def expected
    def setup() {
        list = Arrays.asList(1,2,4,2,5);
        expected = Arrays.asList(1,2,4,5);
    }

    def "deduplicate"() {
        given:
            def sorter = Mock GenericListSorter.class
            def deduplicator = new ListDeduplicator(sorter)
            sorter.sort(_ as List<Integer>) >> [1, 2, 2, 4, 5]
        when:
            def result = deduplicator.deduplicate(list as List<Integer>)
        then:
            result == expected as List<Integer>
    }

    def "bug_8726"() {
        given:
            def sorter = Mock GenericListSorter.class
            def deduplicator = new ListDeduplicator(sorter)
            sorter.sort(_ as List<Integer>) >> [1, 2, 2, 4]
        when:
            def result = deduplicator.deduplicate([1, 2, 4, 2])
        then:
            result == [1,2,4]
    }
}
