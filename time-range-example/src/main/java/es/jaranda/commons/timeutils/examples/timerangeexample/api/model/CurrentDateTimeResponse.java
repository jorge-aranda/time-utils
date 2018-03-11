
package es.jaranda.commons.timeutils.examples.timerangeexample.api.model;

public class CurrentDateTimeResponse {

    public CurrentDateTimeResponse(
            final String currentDateTime, final String currentLocalDate,
            final String currentLocalTime, final Long currentMillis) {

        this.currentDateTime = currentDateTime;
        this.currentLocalDate = currentLocalDate;
        this.currentLocalTime = currentLocalTime;
        this.currentMillis = currentMillis;

    }

    private final String currentDateTime;

    private final String currentLocalDate;
    private final String currentLocalTime;

    private final Long currentMillis;

    public String getCurrentDateTime() {
        return currentDateTime;
    }

    public String getCurrentLocalDate() {
        return currentLocalDate;
    }

    public String getCurrentLocalTime() {
        return currentLocalTime;
    }

    public Long getCurrentMillis() {
        return currentMillis;
    }
}
