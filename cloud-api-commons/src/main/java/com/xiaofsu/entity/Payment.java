package com.xiaofsu.entity;

import lombok.ToString;

import java.io.Serializable;

/**
 * (Payment)实体类
 *
 * @author xiaoFsu
 * @since 2020-04-27 18:04:35
 */
@ToString
public class Payment implements Serializable {
    private static final long serialVersionUID = 914868352093548941L;
    /**
    * ID
    */
    private Long id;
    
    private String serial;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

}