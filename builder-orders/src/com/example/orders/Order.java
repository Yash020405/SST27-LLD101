package com.example.orders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Telescoping constructors + setters. Allows invalid states.
 */
public class Order {
    private final String id;
    private final String customerEmail;
    private final List<OrderLine> lines;
    private final Integer discountPercent;
    private final boolean expedited;
    private final String notes;

    private Order(Builder builder) {
        this.id = builder.id;
        this.customerEmail = builder.customerEmail;
        this.lines = Collections.unmodifiableList(new ArrayList<>(builder.lines));
        this.discountPercent = builder.discountPercent;
        this.expedited = builder.expedited;
        this.notes = builder.notes;
    }

    public String getId() {
        return id;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public List<OrderLine> getLines() {
        return lines;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public boolean isExpedited() {
        return expedited;
    }

    public String getNotes() {
        return notes;
    }

    public int totalBeforeDiscount() {
        int sum = 0;
        for (OrderLine l : lines)
            sum += l.getQuantity() * l.getUnitPriceCents();
        return sum;
    }

    public int totalAfterDiscount() {
        int base = totalBeforeDiscount();
        if (discountPercent == null)
            return base;
        return base - (base * discountPercent / 100);
    }

    public static class Builder {
        private static final Pattern EMAIL_PATTERN = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");

        private final String id;
        private final String customerEmail;
        private final List<OrderLine> lines = new ArrayList<>();
        private Integer discountPercent;
        private boolean expedited;
        private String notes;

        public Builder(String id, String customerEmail, OrderLine firstLine) {
            if (id == null || id.isEmpty())
                throw new IllegalArgumentException("Order ID is required.");
            if (customerEmail == null || !EMAIL_PATTERN.matcher(customerEmail).matches()) {
                throw new IllegalArgumentException("Invalid email format.");
            }
            if (firstLine == null)
                throw new IllegalArgumentException("At least one order line is required.");

            this.id = id;
            this.customerEmail = customerEmail;
            this.lines.add(firstLine);
        }

        public Builder addLine(OrderLine line) {
            if (line == null)
                throw new IllegalArgumentException("Order line cannot be null.");
            this.lines.add(line);
            return this;
        }

        public Builder setDiscountPercent(Integer discountPercent) {
            if (discountPercent != null && (discountPercent < 0 || discountPercent > 100)) {
                throw new IllegalArgumentException("Discount percent must be between 0 and 100.");
            }
            this.discountPercent = discountPercent;
            return this;
        }

        public Builder setExpedited(boolean expedited) {
            this.expedited = expedited;
            return this;
        }

        public Builder setNotes(String notes) {
            this.notes = notes;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
