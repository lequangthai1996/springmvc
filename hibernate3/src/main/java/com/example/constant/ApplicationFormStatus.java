package com.example.constant;

public enum ApplicationFormStatus {
    NEW(0),
    REFIELD(1),
    REFIELDED(2),
    PASSED(3),
    IN_FV_PROGRESS(4),
    APPROVED(5),
    REJECTED(6),
    DISBURSED(7);

    private int value;

    ApplicationFormStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
