package com.aor.numbers;
import spock.lang.Specification

class ListAggregatorSpock extends Specification{
    def private list = Arrays.asList(1,-10, -3, 2,4,2,5, 100)

    def "sum"() {
        given:
            def aggregator = new ListAggregator()
        when:
            int sum = aggregator.sum(list)
        then:
            sum == 101
    }

    def "minimum"() {
        given:
            def aggregator = new ListAggregator()
        when:
            int min = aggregator.min(list)
        then:
            min == -10
    }

    def "maximum"() {
        given:
            def aggregator = new ListAggregator()
        when:
            int max = aggregator.max(list)
        then:
            max == 100
    }

    def "distinct"() {
        given:
            def aggregator = new ListAggregator()
            def deduplicator = new ListDeduplicator(new ListSorter())
        when:
            int distinct = aggregator.distinct(list, deduplicator)
        then:
            distinct == 7
    }

}
