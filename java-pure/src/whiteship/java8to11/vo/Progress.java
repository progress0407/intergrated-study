package whiteship.java8to11.vo;

import java.time.Duration;

public class Progress {
    private Duration studyDuration;
    private boolean finished;

    public Progress(Duration studyDuration, boolean finished) {
        this.studyDuration = studyDuration;
        this.finished = finished;
    }

    public Duration getStudyDuration() {
        return studyDuration;
    }

    public boolean isFinished() {
        return finished;
    }

    @Override
    public String toString() {
        return "Progress{" +
                "studyDuration=" + studyDuration +
                ", finished=" + finished +
                '}';
    }
}