package model;

public class Email {
    private String language;
    private int page;
    private boolean spam;
    private String sign;

    public Email() {
    }

    public Email(String language, int page, boolean spam, String sign) {
        this.language = language;
        this.page = page;
        this.spam = spam;
        this.sign = sign;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public boolean isSpam() {
        return spam;
    }

    public void setSpam(boolean spam) {
        this.spam = spam;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
