package com.penn.spring.activemq.comm.po;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/1/12.
 */
public class PersonVo implements Serializable {


    private static final long serialVersionUID = -1719806932817744297L;

    private Long personId;

    private String personName;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
