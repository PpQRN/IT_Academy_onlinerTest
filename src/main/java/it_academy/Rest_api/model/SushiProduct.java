package it_academy.Rest_api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SushiProduct {
    private String id;
    private String key;
    private String name;
    private String full_name;
    private String name_prefix;

    public String getName_prefix() { return name_prefix;}

    public void setName_prefix(String name_prefix) { this.name_prefix = name_prefix; }

    public String getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    @Override
    public String toString() {
        return "SushiProduct{" +
                "id='" + id + '\'' +
                ", key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", full_name='" + full_name + '\'' +
                ", name_prefix='" + name_prefix + '\'' +
                '}';
    }

}
