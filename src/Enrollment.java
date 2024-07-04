import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;


public class Enrollment {

    private String group;
    private String tier;
    private LocalDate startDate;

    @Override
    public String toString() {
        return "Enrollment{" +
                "group='" + group + '\'' +
                ", tier='" + tier + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", copay=" + copay +
                '}';
    }

    private LocalDate endDate;
    private long copay;

    public static Comparator<Enrollment> ENROLLMENT_COMPARATOR = Comparator.comparing(Enrollment::getGroup)
            .thenComparing(Enrollment::getStartDate)
            .thenComparing(Enrollment::getEndDate);

    public static DateTimeFormatter DATE_FORMAT_1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public Enrollment(String group, String tier, String startDate, String endDate, int copay) {
        this.group = group;
        this.tier = tier;
        this.startDate = LocalDate.parse(startDate, DATE_FORMAT_1);
        this.endDate = LocalDate.parse(endDate, DATE_FORMAT_1);
        this.copay = copay;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public long getCopay() {
        return copay;
    }

    public void setCopay(long copay) {
        this.copay = copay;
    }

}
