package com.lfsjesus.lab6;

public class Romulan extends AlienClient {
    @Override
    protected OrderingStrategy createOrderingStrategy() {
        return new ImpatientStrategy();
    }
}
