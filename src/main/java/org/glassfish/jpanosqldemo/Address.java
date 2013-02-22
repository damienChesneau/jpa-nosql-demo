/**
 * *****************************************************************************
 * Copyright (c) 2012 Oracle. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 and Eclipse Distribution License v. 1.0 which accompanies
 * this distribution. The Eclipse Public License is available at
 * http://www.eclipse.org/legal/epl-v10.html and the Eclipse Distribution
 * License is available at http://www.eclipse.org/org/documents/edl-v10.php.
 * ****************************************************************************
 */
package org.glassfish.jpanosqldemo;

import java.io.Serializable;
import javax.persistence.Embeddable;
import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

/**
 * Address, stored as part of the Order document.
 */
@Embeddable
@NoSql(dataFormat = DataFormatType.MAPPED)
public class Address implements Serializable {

    private String street;
    private String city;
    private String state;
    private String zip;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}