package com.lfsjesus.lab6;

public class Ferengi extends AlienClient{
        @Override
        protected OrderingStrategy createOrderingStrategy() {
            return new SmartStrategy();
        }
}
