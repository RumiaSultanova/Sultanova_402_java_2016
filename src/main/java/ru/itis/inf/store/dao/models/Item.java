package ru.itis.inf.store.dao.models;

import com.google.common.base.MoreObjects;

import java.util.Objects;

/**
 * Created by rumia on 15.02.16.
 */
public class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        Item that = (Item) object;

        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.price);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("Price", this.price)
                .add("Name", this.name)
                .toString();
    }
}
