package com.aor.numbers;

class ListFiltererSpock {
    def "filter"() {
        given:
            def filterer = Mock(GenericListFilter.class)
            filterer.accept(1) >> true
            filterer.accept(2) >> false
            filterer.accept(3) >> true
            filterer.accept(4) >> false
            filterer.accept(5) >> true

        when:
            def result = new ListFilterer(filterer)

        then:
            result.filter([1, 2, 3, 4, 5]) == [1, 3, 5]

    }
}
