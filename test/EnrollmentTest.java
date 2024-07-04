import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentTest {

    @Test
    public void testEnrollmentInserts() {
        List<Enrollment> enrollments = new ArrayList<>();
        Enrollment enrollment1 = new Enrollment("Commercial", "gold", "01/01/2022", "03/31/2022", 50);
        Enrollment enrollment2 = new Enrollment("Commercial", "silver","04/01/2022", "12/31/2022", 100);
        Enrollment enrollment3 = new Enrollment("State", "Tier1", "06/01/2023", "10/31/2023", 40);

        enrollments.add(enrollment3);
        enrollments.add(enrollment1);
        enrollments.add(enrollment2);

        enrollments.sort(Enrollment.ENROLLMENT_COMPARATOR);
        enrollments.stream()
                .forEach(r -> System.out.format("%-15s %-10s %-10s %-10s %n", r.getGroup(), r.getTier(), r.getStartDate().toString(), r.getEndDate().toString()));


    }
}
