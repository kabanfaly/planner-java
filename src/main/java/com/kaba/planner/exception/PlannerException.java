package com.kaba.planner.exception;

import lombok.Getter;

/**
 *
 * @author kaba
 */
public class PlannerException extends Exception {

    private static final long serialVersionUID = 111010722904987518L;

    @Getter
    private PlannerError plannerError;

    public PlannerException(PlannerError plannerError, Throwable cause) {
        super(plannerError.geteErrorMessage(), cause);
        this.plannerError = plannerError;
    }
    
    public PlannerException(PlannerError plannerError) {
        this(plannerError, new Throwable());
    }
}
