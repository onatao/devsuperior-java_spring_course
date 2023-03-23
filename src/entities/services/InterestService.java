package entities.services;

import java.security.InvalidParameterException;

public interface InterestService {

    double getInterestRate();
    default double payment(double amount, int months) {
        if (months < 0) {
            throw  new InvalidParameterException("Months must be grater than zero");
        }
        return amount * Math.pow(1 + getInterestRate() / 100, months);
    }
}
