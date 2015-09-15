package br.com.teste.teste;

import com.google.gson.annotations.SerializedName;

/**
 * Created by foo on 15/09/15.
 */
public class Address {

    @SerializedName("street")
    private String street;

    @SerializedName("suite")
    private String complemento;

    @SerializedName("city")
    private String city;

    @SerializedName("zipcode")
    private String CEP;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }
}
