package com.aor.numbers;
import spock.lang.Specification
import org.mockito.Mock;


class ListAggregatorGroovy extends Specification{
    def "should be able to check equity"() {
       def deduplicator = Mock(GenericListDeduplicator)

        when:
            def result = deduplicator.deduplicate(Arrays.asList(1, 2, 3, 2))
        then:
            result == null
    }
}
