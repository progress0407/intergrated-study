package hellojpa.doing.v2;

import lombok.Data;

@Data
class TeamUsersDto {
    private final String teamId;
    private final String teamName;
    private final String userId;
    private final String userName;
}
