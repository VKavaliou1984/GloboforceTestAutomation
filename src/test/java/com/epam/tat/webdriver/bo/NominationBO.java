package com.epam.tat.webdriver.bo;

public class NominationBO {

    private String recipient;
    private String program;
    private String reason;
    private String title;
    private String message;
    private String messageForApprover;
    private String type;
    private String privacy;

    public NominationBO(String recipient, String program, String reason, String title, String message, String messageForApprover, String type, String privacy) {
        this.recipient = recipient;
        this.program = program;
        this.reason = reason;
        this.title = title;
        this.message = message;
        this.messageForApprover = messageForApprover;
        this.type = type;
        this.privacy = privacy;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getProgram() {
        return program;
    }

    public String getReason() {
        return reason;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageForApprover() {
        return messageForApprover;
    }

    public String getType() {
        return type;
    }

    public String getPrivacy() {
        return privacy;
    }
}
