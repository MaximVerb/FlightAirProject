package domain.airlineFlightAdministration;

import javax.persistence.*;

@Embeddable
public class PricingInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public PricingInformation() {
    }

    @Column(name = "base_price")
    private Double basePrice;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "amount_seats")
    private Integer amountOfSeats;

    public Long getId() {
        return id;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getAmountOfSeats() {
        return amountOfSeats;
    }
}
