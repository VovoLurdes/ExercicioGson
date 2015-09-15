package br.com.teste.teste;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by foo on 15/09/15.
 */
public class UsuarioTeste {

    private List<MainInfo> informacoes;
    private List<Address> enderecos;
    private List<Company> empresas;


    public List<MainInfo> getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(List<MainInfo> informacoes) {
        this.informacoes = informacoes;
    }

    public class Geo
    {
        private String lat;
        private String lng;

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }
    }

    public class Address
    {
        private String street;

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getSuite() {
            return suite;
        }

        public void setSuite(String suite) {
            this.suite = suite;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        private String suite;
        private String city;
        private String zipcode;
        public Geo geo;
    }

    public class Company
    {
        private String name;
        private String catchPhrase;
        private String bs;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCatchPhrase() {
            return catchPhrase;
        }

        public void setCatchPhrase(String catchPhrase) {
            this.catchPhrase = catchPhrase;
        }

        public String getBs() {
            return bs;
        }

        public void setBs(String bs) {
            this.bs = bs;
        }
    }

    public static class MainInfo
    {
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getWebsite() {
            return website;
        }

        public void setWebsite(String website) {
            this.website = website;
        }

        public Company getCompany() {
            return company;
        }

        public void setCompany(Company company) {
            this.company = company;
        }

        @SerializedName("id")
        private int id;

        @SerializedName("name")
        private String name;

        @SerializedName("username")
        private String username;

        @SerializedName("email")
        private String email;

        public Address address;

        @SerializedName("phone")
        private String phone;

        @SerializedName("website")
        private String website;

        public Company company;
    }
}
