package vacation;

import java.util.ArrayList;
import java.util.List;

public class VacationRequests {

    List<VacationRequest> vacationsRequests = new ArrayList<>();
    Double vacationDays = 20.0;

    public VacationRequests(List<VacationRequest> vacationsRequests) {
        this.vacationsRequests = vacationsRequests;
    }

    public Double getDiffDays() {
        return vacationsRequests.stream()
                .map(VacationRequest::second)
                .reduce(Integer::sum)
                .map(e->e/(double)DateTimeUnit.DAY.getSecond())
                .orElseGet(() -> -1.0);
    }

    public Double getVacationRaminDays() {
        return vacationDays + getDiffDays();
    }
}
