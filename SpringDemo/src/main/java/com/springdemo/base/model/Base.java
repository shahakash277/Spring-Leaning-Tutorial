package com.springdemo.base.model;

import java.io.Serializable;

public interface Base extends Serializable {

    public abstract int getId();

    public abstract void setId(int id);

    public abstract void setName(String name);

    public abstract String getName();
}
