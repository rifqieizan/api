package com.example.rifqi.recycler;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlayerResponds {

    @SerializedName("data")
    private List<Player> data;

    @SerializedName("success")
    private boolean success;

    @SerializedName("message")
    private String message;

    public List<Player> getData() {
        return data;
    }

    public void setData(List<Player> data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "PlayerResponds{" +
                "data=" + data +
                ", success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
