package org.tgs_ct.probies.inventory.data;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;

public abstract class ProductCalibratable {
    protected String name;
    protected Integer id;
    protected BigDecimal price;

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .append(price)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!this.getClass().getSuperclass().equals(obj.getClass().getSuperclass())) {
            return false;
        }
        ProductCalibratable comparator = (ProductCalibratable) obj;
        return new EqualsBuilder()
                .append(name, comparator.name)
                .append(price, comparator.price)
                .isEquals();
    }

    public boolean equivalent(ProductCalibratable definition) {
        if (definition.id != null && this.id == definition.id) {
            return true;
        }
        boolean equivalent = (definition.name == null || this.name.equals(definition.name)) &&
                (definition.price == null || this.price.equals(definition.price));
        return equivalent;
    }
}
