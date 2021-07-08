package com.kodlamaio.hrms.core.utilities.business;

import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;

public class CheckEngine {

    public static Result run(Result... rules) {

        for (Result rule : rules) {
            if(!rule.isSuccess()) {
                return rule;
            }
        }

        return new SuccessResult();
    }
}
