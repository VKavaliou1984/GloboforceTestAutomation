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

    private NominationBO() {
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

    public static class Builder {

        private String recipient;
        private String program;
        private String reason;
        private String title;
        private String message;
        private String messageForApprover;
        private String type;
        private String privacy;

        public Builder(String recipient, String title, String message) {
            this.recipient = recipient;
            this.title = title;
            this.message = message;
        }

        public Builder chooseAwardProgram(String program) {
            this.program = program;
            return this;
        }

        public Builder chooseAwardReason(String reason) {
            this.reason = reason;
            return this;
        }

        public Builder chooseAwardType(String type) {
            this.type = type;
            return this;
        }

        public Builder addMessageForApprover(String messageForApprover) {
            this.messageForApprover = messageForApprover;
            return this;
        }

        public Builder chooseAwardPrivacy(String privacy) {
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
}
