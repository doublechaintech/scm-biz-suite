package com.terapico.workflow;

/**
 * 工作流的参与者
 */
public class Actor {
    protected String role;
    protected String id;

    public Actor() {
        super();
    }
    public Actor(String role, String id) {
        this();
        this.role = role;
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
