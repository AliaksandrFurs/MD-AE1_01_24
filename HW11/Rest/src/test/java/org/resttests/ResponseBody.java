package org.resttests;

public class ResponseBody {

    private Object title;
    private Object body;
    private Object userId;
    private Object Id;

    public Object getTitle() {
        return title;
    }

    public Object getBody() {
        return body;
    }

    public Object getUserId() {
        return userId;
    }

    public Object getId() {
        return Id;
    }

    public void setTitle(Object title) {
        this.title = title;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public void setUserId(Object userId) {
        this.userId = userId;
    }

    public void setId(Object id) {
        Id = id;
    }
}
