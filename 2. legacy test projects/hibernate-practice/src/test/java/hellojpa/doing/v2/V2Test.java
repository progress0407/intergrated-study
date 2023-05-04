package hellojpa.doing.v2;

import static java.lang.System.out;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hellojpa.doing.GlobalTestConfig;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;

@Slf4j
class V2Test extends GlobalTestConfig {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("remind-hibernate");
    EntityManager em = emf.createEntityManager();

    Team team1;
    Team team2;
    Team team3;

    User user1;
    User user2;
    User user3;
    User user4;
    User user5;


    @BeforeEach
    void setUp() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        team1 = new Team("t1", "team1");
        team2 = new Team("t2", "team2");
        team3 = new Team("t3", "team3");

        user1 = new User("u1", "user1");
        user2 = new User("u2", "user2");
        user3 = new User("u3", "user3");
        user4 = new User("u4", "user4");
        user5 = new User("u5", "user5");

        user1.setTeam(team1);
        user2.setTeam(team1);
        user3.setTeam(team2);
        user4.setTeam(team3);
        user5.setTeam(null);

        em.persist(team1);
        em.persist(team2);
        em.persist(team3);

        em.persist(user5);

        em.flush();
        em.clear();
        tx.commit();
    }


    @AfterEach
    void tearDown() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.createQuery("delete from User").executeUpdate();
        em.createQuery("delete from Team").executeUpdate();
        tx.commit();
    }

    @DisplayName("비어있는 테스트")
    @Test
    void test1() {
        log.info("비어있는 테스트입니다.");
    }

    @DisplayName("t -> u")
    @Rollback(value = false)
    @Test
    void test2() {
        Team findTeam = em.find(Team.class, team1.getId());
        out.println("findTeam = " + findTeam);
        out.println("team1.hashCode() = " + team1.hashCode());
        out.println("findTeam.hashCode() = " + findTeam.hashCode());
        out.println("team1 == findTeam" + (findTeam == team1));

        List<User> findUsers = findTeam.getUsers();
        for (User findUser : findUsers) {
            out.println("findUser = " + findUser);
        }
    }

    @DisplayName("u -> t")
    @Test
    void test3() {
        User findUser1 = em.find(User.class, user1.getId());

        Team team = findUser1.getTeam();
        out.println("team = " + team);
    }

    /**
     * JPQL 에서 등장하는 문제, 일대다, 다대일 어느쪽에서든 상관 없이 발생
     */
    @DisplayName("1+N problem")
    @Test
    void qwe2() {
        List<User> findUsers = em.createQuery("select u from User u", User.class).getResultList();
        for (User findUser : findUsers) {
            out.println("findUser.team = " + findUser.getTeam());
        }
    }

    @DisplayName("1+N problem - 2")
    @Test
    void qwe3() {
        List<Team> findTeams = em.createQuery("select t from Team t", Team.class).getResultList();
        for (Team findTeam : findTeams) {
            out.println("findTeam.users = " + findTeam.getUsers());
        }
    }

    @DisplayName("객체 그래프 탐색 - 일대다")
    @Test
    void retrieve_entity_graph_users() {
        Collection findUsers = em.createQuery("select t.users from Team t", Collection.class).getResultList();
        out.println("#1 users = " + findUsers);
        out.println("#2 users type = " + findUsers.getClass());
        for (Object findUser : findUsers) {
            out.println("findUser = " + findUser);
        }
    }

    @DisplayName("객체 그래프 탐색 - 일대다 - 필드 조회")
    @Test
    void retrieve_entity_graph_users_field() {
        Collection findUserNames = em.createQuery("select t.users.user_name from Team t", Collection.class)
                .getResultList();

        for (Object findUserName : findUserNames) {
            out.println("findUserName = " + findUserName);
        }
    }

    @DisplayName("객체 그래프 탐색 - 다대일")
    @Test
    void retrieve_entity_graph_team() {
        List<Team> teams = em.createQuery("select u.team from User u", Team.class).getResultList();
        for (Team team : teams) {
            out.println("team = " + team);
        }
    }

    @DisplayName("jpql join")
    @Test
    void jpql_join() {
        // left outer join
        List<User> findUsers = em.createQuery("select u from User u left join u.team t", User.class).getResultList();
        out.println("#1 users = " + findUsers);
        for (User user : findUsers) {
            out.println("user1 = " + user);
        }
    }

    @DisplayName("jpql join - projections")
    @Test
    void jpql_join_2() {
        // left outer join
        List objects = em.createQuery("select t, u from Team t join t.users u").getResultList();
        out.println("objects = " + objects);
        for (Object object : objects) {
            out.println("object = " + object);
        }
    }

    @DisplayName("jpql join - projection dto 이용 2")
    @Test
    void jpql_join_2_2() {
        // left outer join
        List<TeamUsersDto> dtos = em.createQuery("select t, u from Team t join t.users u", TeamUsersDto.class)
                .getResultList();
        out.println("dtos = " + dtos);
    }

    @DisplayName("jpql join - projection dto 이용 2")
    @Test
    void jpql_join_3_1() {
        List<SampleDto> sampleDtos = em.createQuery(
                        "select"
                                + " new hellojpa.doing.v2.SampleDto(t.id, t.teamName)"
                                + " from Team t", SampleDto.class)
                .getResultList();

        for (SampleDto sampleDto : sampleDtos) {
            out.println("# sampleDto = " + sampleDto);
        }
    }

    @DisplayName("jpql join - projection dto 이용 2")
    @Test
    void jpql_join_3_2() {
        List<TeamUsersDto> teamUsersDtos = em.createQuery(
                        "select"
                                + " new hellojpa.doing.v2.TeamUsersDto(t.id, t.teamName, u.id, u.name)"
                                + " from Team t join t.users u", TeamUsersDto.class)
                .getResultList();

        for (TeamUsersDto teamUsersDto : teamUsersDtos) {
            out.println("teamUsersDto = " + teamUsersDto);
        }
    }

    @DisplayName("fetch jpql join")
    @Test
    void fetch_jpql_join() {
        List<User> users = em.createQuery("select u from User u join fetch u.team t", User.class).getResultList();
        out.println("users = " + users);
    }

    @DisplayName("강의내용 - 컬렉션 뻥튀기")
    @Test
    void test_3() {
        String sql = "select t from Team t join fetch t.users";

        List<Team> result = em.createQuery(sql, Team.class).getResultList();

        for (Team team : result) {
            out.println("team = " + team.getTeamName() + " | members=" + team.getUsers().size());
        }

        List<Team> subTeams = result.stream()
                .filter(team -> team.getTeamName().equals("team1"))
                .collect(Collectors.toList());

        Team findTeam1 = subTeams.get(0);
        Team findTeam2 = subTeams.get(1);

        out.println("findTeam1.hashCode() = " + findTeam1.hashCode());
        out.println("findTeam2.hashCode() = " + findTeam2.hashCode());

        out.println("findTeam1 == findTeam2 = " + (findTeam1 == findTeam2));
    }

    @DisplayName("강의내용 - 컬렉션 뻥튀기 - distinct")
    @Test
    void test_3_distinct() {
        String sql = "select distinct t from Team t join fetch t.users";

        List<Team> result = em.createQuery(sql, Team.class).getResultList();

        for (Team team : result) {
            out.println("team = " + team.getTeamName() + " | members=" + team.getUsers().size());
        }
    }

    @DisplayName("일대다 페이징 문제")
    @Test
    void test_4() {
        List<Team> resultRows = em.createQuery("select t from Team t join fetch t.users", Team.class)
                .setFirstResult(0)
                .setMaxResults(1)
                .getResultList();

        for (Team resultRow : resultRows) {
            out.println("# resultRow = " + resultRow);
            for (User user : resultRow.getUsers()) {
                out.println("# user = " + user);
            }
        }
    }

    @DisplayName("일대다 페이징 문제를 다대일로 풀어서 해결")
    @Test
    void test_5() {
        List<User> users = em.createQuery("select u from User u join fetch u.team t", User.class)
                .setFirstResult(0)
                .setMaxResults(1)
                .getResultList();

        for (User user : users) {
            out.println("# user = " + user);
            Team team = user.getTeam();
            out.println("# team = " + team);
        }
    }

    @DisplayName("JPQL 조회도 영속성 컨텍스트를 거치지 않는지 확인")
    @Test
    void test_6() {
        // 영속성 컨텍스트를 거치지 않는다... select 쿼리도 !

        log.info("############# start ############");
        em.createQuery("select t from Team t ", Team.class)
                .getResultList();

        log.info("############# end ############");

        em.createQuery("select t from Team t ", Team.class)
                .getResultList();
    }

    //    @DisplayName("연관관계 편의 메서드를 설정하지 않았을 시에 어떤 문제가 될까?") // 주제 변경하게 됨
    @DisplayName("Team에 문제가 있을시에 어떤 문제가 발생하게 될까")
    @Test
    void relation_method() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Team team_1 = new Team("t_1", "team_1");
        User user_1 = new User("u_1", "user_1");
        user_1.setTeam(team_1);

        em.persist(team_1); // 생애주기 같이 저장 -> 왜인지 같이 저장되지 않는다, 나중에 알아보자
        em.persist(user_1);

        em.flush();
        em.clear();

        // 어? 잠깐 생각해보니 uesr_2를 저장)안했잖아~~ 이것도 넣자구~ ㅋ
        User user_2 = new User("u_2", "user_2");
        team_1.getUsers().add(user_2); // 만일 이쪽에 변경권한이 있으면, 이 부분에서 변경감지가 일어나게 된다!
        user_2.setTeam(team_1);
        em.persist(user_2);

        em.flush(); // 이때 문제가 일어난다... 팀의 변경감지 쿼리도 날라가게 된다...
        em.clear();

        Team findTeam = em.find(Team.class, team_1.getId());
        for (User user : findTeam.getUsers()) {
            out.println("# find user = {}" + user); //
        }
        tx.commit();
    }

}
