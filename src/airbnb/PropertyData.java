/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airbnb;

/**
 *
 * @author tugrul
 */
public class PropertyData {
    String propertyType;
    Double price;
    String propertyName;
    int hostId;

    public PropertyData(String propertyType, Double price, String propertyName, int hostId) {
        this.propertyType = propertyType;
        this.price = price;
        this.propertyName = propertyName;
        this.hostId = hostId;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }
    
}
