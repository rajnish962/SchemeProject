package com.rajnish.tspschemes;

public class Scheme {
    String id,scheme;

    public Scheme(String id, String scheme) {
        this.id = id;
        this.scheme = scheme;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }
}
