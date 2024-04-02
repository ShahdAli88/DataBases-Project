package application;
public class CombinedData {
    private String propertyId;
    private String propertyLocation;
    private String propertySize;
    private int monthlyRent;

    public CombinedData(String propertyId, String propertyLocation, String propertySize, int monthlyRent) {
        this.propertyId = propertyId;
        this.propertyLocation = propertyLocation;
        this.propertySize = propertySize;
        this.monthlyRent = monthlyRent;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyLocation() {
        return propertyLocation;
    }

    public void setPropertyLocation(String propertyLocation) {
        this.propertyLocation = propertyLocation;
    }

    public String getPropertySize() {
        return propertySize;
    }

    public void setPropertySize(String propertySize) {
        this.propertySize = propertySize;
    }

    public int getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(int monthlyRent) {
        this.monthlyRent = monthlyRent;
    }
}
