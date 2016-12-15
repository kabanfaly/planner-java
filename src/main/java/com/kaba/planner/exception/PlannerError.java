package com.kaba.planner.exception;

/**
 * Enumeration of all errors
 * 
 * @author kaba
 */
public enum PlannerError {
    
    E0001("Data not found");
    
    private final  String errorMessage;
    
    private PlannerError(String errorMessage){
        this.errorMessage = errorMessage;
    }
    
    public PlannerError getPlannerError(String msg){
        
        
        for(PlannerError error: PlannerError.values()){
           if(error.toString().equals(msg)){
               return error;
           }
        }
        return null;
    }
    
    @Override
    public String toString(){
        return this.errorMessage;
    }
    
    public String geteErrorMessage(){
        return this.errorMessage;
    }
}
