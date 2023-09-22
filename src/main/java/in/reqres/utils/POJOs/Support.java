package in.reqres.utils.POJOs;

public class Support {
    private String url;
    private String text;

    public Support(String url, String test) {
        this.url = url;
        this.text = test;
    }

    public Support() {
    }

    @Override
    public String toString() {
        return "Support{" +
                "url='" + url + '\'' +
                ", test='" + text + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
