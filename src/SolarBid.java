import java.text.NumberFormat;

public class SolarBid implements Comparable<SolarBid>  {
    private String companyName;
    private double cost;
    private double size;
    private int panelCount;
    private long estProduction;


    public SolarBid(String companyName, double cost, double size, int panelCount, long estProduction) {
        this.companyName = companyName;
        this.cost = cost;
        this.size = size;
        this.panelCount = panelCount;
        this.estProduction = estProduction;
    }
    public SolarBid() {}

    public SolarBid(String companyName) {
        this.companyName = companyName;
        this.cost = 10000;
        this.size = 10;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getPanelCount() {
        return panelCount;
    }

    public void setPanelCount(int panelCount) {
        this.panelCount = panelCount;
    }

    public long getEstProduction() {
        return estProduction;
    }

    public void setEstProduction(long estProduction) {
        this.estProduction = estProduction;
    }

    public double getTaxCredit() {
        return getCost() * .3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SolarBid solarBid)) return false;

        if (Double.compare(size, solarBid.size) != 0) return false;
        if (panelCount != solarBid.panelCount) return false;
        if (estProduction != solarBid.estProduction) return false;
        return companyName.equals(solarBid.companyName);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = companyName.hashCode();
        temp = Double.doubleToLongBits(size);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + panelCount;
        result = 31 * result + (int) (estProduction ^ (estProduction >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "SolarBid{" +
                "companyName='" + companyName + '\'' +
                ", cost=" + cost +
                ", taxCredit=" + String.format("%.2f",getTaxCredit()) +
                ", size=" + size +
                ", panelCount=" + panelCount +
                ", estProduction=" + estProduction +
                '}';
    }

    @Override
    public int compareTo(SolarBid o) {
        int i = this.companyName.compareTo(o.companyName);
        System.out.println(this.companyName + " compared to " + o.companyName + " returns " + i);
        return i;
    }
}
