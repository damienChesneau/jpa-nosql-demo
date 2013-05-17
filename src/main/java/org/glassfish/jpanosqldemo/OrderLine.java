package org.glassfish.jpanosqldemo;

import java.io.Serializable;
import javax.persistence.Embeddable;
import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

/**
 * OrderLine, stored as part of the Order document.
 */
@Embeddable
@NoSql(dataFormat = DataFormatType.MAPPED)
public class OrderLine implements Serializable {

    private int lineNumber;
    private String description;
    private double cost = 0;

    public OrderLine() {
    }

    public OrderLine(String description, double cost) {
        this.description = description;
        this.cost = cost;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}