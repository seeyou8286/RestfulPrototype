package my.restful;

public class Greeting {

    private long id;
    private String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Greeting() {
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String toString(){
        return "id"+id+"content"+content;
    }
}
