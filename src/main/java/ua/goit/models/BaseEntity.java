package ua.goit.models;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

@FunctionalInterface
public interface BaseEntity<UUID> extends Serializable {

    @SerializedName("id")
    UUID getId();
}