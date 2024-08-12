package org.recommendations.exception;

public class NoRecommendationsException extends RuntimeException {
    public NoRecommendationsException(String message) {
        super(message);
    }
}
