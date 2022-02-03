package ua.goit.models;

import com.google.gson.annotations.SerializedName;

public enum  Role {
    @SerializedName("admin")
    ADMIN,
    @SerializedName("user")
    USER;
}
