package hellojpa.doing.v2;

import lombok.Data;

@Data
class SampleDto {
    private String teamId;
    private String teamName;

    public SampleDto(String teamId, String teamName) {
        this.teamId = teamId;
        this.teamName = teamName;
    }
}

