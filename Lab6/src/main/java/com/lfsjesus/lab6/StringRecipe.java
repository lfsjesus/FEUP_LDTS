package com.lfsjesus.lab6;

import java.util.List;

public class StringRecipe {
    private List<StringTransformer> _transformers;

    public StringRecipe(List<StringTransformer> transformers) {
        this._transformers = transformers;
    }

    public void mix(StringDrink drink) {
        for (StringTransformer s : _transformers) {
            s.execute(drink);
        }
    }
}
