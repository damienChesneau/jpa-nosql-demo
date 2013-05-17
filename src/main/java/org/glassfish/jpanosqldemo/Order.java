package org.glassfish.jpanosqldemo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

/**
 * Order, stored as a root JSON object, nesting its order lines in the same
 * document.
 */
@Entity
@NoSql(dataFormat = DataFormatType.MAPPED)
public class Order implements Serializable {

    @Id // Use generated OID (UUID) from Mongo.
    @GeneratedValue
    @Field(name = "_id")
    private String id;
    private String description;
    @ElementCollection
    private List<OrderLine> orderLines = new ArrayList<OrderLine>();
    private double totalCost = 0;
    @Version
    private long version;
    // A nested embeddable value is stored as Embedded.
    @Embedded
    private Address billingAddress;
    @Embedded
    private Address shippingAddress;
    // Relationships are supported, the id is stored as a foreign key,
    // for OneToMany a collection of ids would be stored.
    @ManyToOne
    private Customer customer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    /**
     * Add the order line to the order, and set the back reference and update
     * the order cost.
     */
    public void addOrderLine(OrderLine orderLine) {
        getOrderLines().add(orderLine);
        orderLine.setLineNumber(getOrderLines().size());
        setTotalCost(getTotalCost() + orderLine.getCost());
    }

    @Override
    public String toString() {
        return "Order(" + description + ", " + totalCost + ")";
    }
}
