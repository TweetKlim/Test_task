package com.testtask.task11;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class OrderKey implements Serializable {

    static final long serialVersionUID = 1L;

    @Column(name = "person_id")
    private int personId;

    @Column(name = "producst_id")
    private int productId;

    OrderKey(int personId,int productId)
    {
        this.personId = personId;
        this.productId = productId;
    }


    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof OrderKey)) return false;
        OrderKey orderKey = (OrderKey) o;
        return Objects.equals(getPersonId(), orderKey.getPersonId())
                && Objects.equals(getProductId(), orderKey.getProductId());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getPersonId(),getProductId());
    }
    public int getPersonId(){
        return personId;
    }
    public int getProductId(){
        return productId;
    }
}
