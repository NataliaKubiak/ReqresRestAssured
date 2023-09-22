package in.reqres.utils.POJOs;

public class Resource {
    private Data data;
    private Support support;

    public Resource(Data data, Support support) {
        this.data = data;
        this.support = support;
    }

    public Resource() {
    }

    @Override
    public String toString() {
        return "Resource{" +
                "data=" + data +
                ", support=" + support +
                '}';
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
}
