package com.example.moneytransferserviceproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Embeddable
public class CardAmount implements Serializable {
    @Column(nullable = false)
    @Pattern(regexp = "^[0-8]{9}$")
    @Valid
    @Setter(AccessLevel.NONE)
    Integer value;
    @EqualsAndHashCode.Include
    @Column(nullable = false)
    @Valid
    @Setter(AccessLevel.NONE)
    String currency;

    @JsonCreator
    public CardAmount(@JsonProperty("value") Integer value,
                      @JsonProperty("currency") String currency) {
        this.currency = currency;
        this.value = value;
    }

    public void subtractAmount (int subtract) {
        value = value - subtract;
    }

    public void addAmount (int add) {
        value = value - add;
    }
}
