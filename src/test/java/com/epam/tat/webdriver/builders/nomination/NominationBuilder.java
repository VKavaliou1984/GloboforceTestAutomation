package com.epam.tat.webdriver.builders.nomination;

import com.epam.tat.webdriver.bo.NominationBO;

public class NominationBuilder {

    private String recipient;
    private String program;
    private String reason;
    private String title;
    private String message;
    private String messageForApprover;
    private String type;
    private String privacy;

    public NominationBuilder(String recipient, String title, String message) {
        this.recipient = recipient;
        this.title = title;
        this.message = message;
    }

    public NominationBuilder chooseAwardProgram(String program) {
        this.program = program;
        return this;
    }

    public NominationBuilder chooseAwardReason(String reason) {
        this.reason = reason;
        return this;
    }

    public NominationBuilder chooseAwardType(String type) {
        this.type = type;
        return this;
    }

    public NominationBuilder addMessageForApprover(String messageForApprover) {
        this.messageForApprover = messageForApprover;
        return this;
    }

    public NominationBuilder chooseAwardPrivacy(String privacy) {
        this.privacy = privacy;
        return this;
    }

    public NominationBO build() {
        NominationBO nominationBO = new NominationBO();
        nominationBO.recipient = this.recipient;
        nominationBO.title = this.title;
        nominationBO.message = this.message;
        nominationBO.program = this.program;
        nominationBO.reason = this.reason;
        nominationBO.type = this.type;
        nominationBO.messageForApprover = this.messageForApprover;
        nominationBO.privacy = this.privacy;
        return nominationBO;
    }
}
