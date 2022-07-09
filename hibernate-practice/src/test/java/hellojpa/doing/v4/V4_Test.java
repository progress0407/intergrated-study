package hellojpa.doing.v4;

import hellojpa.doing.GlobalTestConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import java.lang.reflect.Member;
import java.util.List;

import static java.lang.System.out;

class V4_Test extends GlobalTestConfig {

    /**
     * 연관관계의 주인이 아닌 곳에서 쓰기 시도
     *   - 다대일의 "다"에 쓰기 시도
     *
     * 실험  결과 모두 실패
     * - @Column - 쓰기 시도, 실패
     * - @JonColum - 쓰기 시도, 실패
     */
    @DisplayName("처음에 아무것도 안했을 때는 당연히 쓰기가 되지 않을꺼야")
    @Test
    void wqewqe_() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Team team = new Team();
        team.setTeamName("t1");

        User user = new User("u1");
        team.getUsers().add(user);
        em.persist(team);
        em.persist(user);
        tx.commit();

        Team findTeam = em.find(Team.class, team.getId());
        for (User findTeamUser : findTeam.getUsers()) {
            out.println("# findTeamUser = " + findTeamUser);
        }
    }

    @DisplayName("[cas.ALL] - persist 후 자바코드상에 user 삭제시 수정 내용이 반영되는가 ?")
    @Test
    void team_user_persist_java_remove_cascade() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        User user = new User("user-1");
        Team team = new Team("team-1");

        user.setTeam(team);
        team.getUsers().add(user);

        em.persist(team); // team 저장할 때 영속성 전이가 member에도 된다

        team.getUsers().remove(0); // member 내용 수정
        user.setName("other-name"); // ALL 에 대해 update 쿼리가 출력된다 !

        tx.commit();
    }

    @DisplayName("[cas.ALL] team 에는 쓰기 권한이 없는데, user를 등록하면 동시에 같이 쓰기가 되는가??")
    @Test // 쓰기가 된다 !!
    void asvssdfdf_() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        User user = new User("user-1");
        Team team = new Team("team-1");

        team.getUsers().add(user); // team 에만 user 를 매핑한다 ~

        em.persist(team);

        tx.commit();
    }

    @DisplayName("[cas.ALL] persist 후 remove 했을 때 동시에 같이 지워지는가?")
    @Test
    void team_user_persist_hibernate_remove_cascade() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        User user = new User("user-1");
        Team team = new Team("team-1");

        user.setTeam(team);
        team.getUsers().add(user);

        em.persist(team);

        em.flush();

        em.remove(team); // team과 user 모두

        tx.commit();
    }

    @DisplayName("[cas.ALL] persist 후 detach 했을 때")
    @Test
    void team_dsafdsav_() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        User user = new User("user-1");
        Team team = new Team("team-1");

        user.setTeam(team);
        team.getUsers().add(user);

        em.persist(team);

        out.println("user 영속화 여부 - " + em.contains(user));

        em.detach(team);

        out.println("user 영속화 여부 - " + em.contains(user));

        tx.commit();
    }

    @DisplayName("refresh 했을 때 영속화된 것 vs DB값 우선시 되는지")
    @Test
    void sadcefsaupoc() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        User user = new User("user-1");
        Team team = new Team("team-1");

        user.setTeam(team);
        team.getUsers().add(user);

        em.persist(team);

        em.flush(); // db값에는 user-1 으로 저장

        user.setName("other-name");     // 영속성 컨텍스트에는 이게 있음 !

        em.refresh(user);

        tx.commit();
    }

    @DisplayName("asdad")
    @Test
    void asfsdg() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        User user = new User("user-1");
        Team team = new Team("team-1");

        user.setTeam(team);
        team.getUsers().add(user);

        em.persist(team);
        em.flush();
        em.clear();

        List<User> findUsers = em.createQuery("select u from User u", User.class)
                .getResultList();

        out.println("findUsers = " + findUsers);

        for (User findUser : findUsers) {
            out.println("em.contains(findUser) = " + em.contains(findUser));
        }

        tx.commit();
    }

    @DisplayName("t1 <- m1,m2,m3")
    @Test
    void asfsdqweaascdsag() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        User user = new User("user-1");
        User user2 = new User("user-2");
        User user3 = new User("user-3");

        Team team = new Team("team-1");

        user.setTeam(team);
        user2.setTeam(team);
        user3.setTeam(team);
        team.getUsers().add(user);
        team.getUsers().add(user2);
        team.getUsers().add(user3);

        em.persist(team);

        em.flush();
        em.clear();

//        Team findTeam = em.find(Team.class, team.getId());
        Team findTeam = em.createQuery("select t from Team t", Team.class)
                .getSingleResult();

        for (User findUser : findTeam.getUsers()) {
            out.println("findUser = " + findUser);
        }

        tx.commit();
    }

    @DisplayName("t1 -> m1,m2 / t2 -> m3")
    @Test
    void asfsdqweaasdvfasdfvasdvfsascdsag() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        User user = new User("user-1");
        User user2 = new User("user-2");
        User user3 = new User("user-3");

        Team team = new Team("team-1");
        Team team2 = new Team("team-2");

        // t1
        user.setTeam(team);
        user2.setTeam(team);
        team.getUsers().add(user);
        team.getUsers().add(user2);

        //t2
        user3.setTeam(team2);
        team2.getUsers().add(user3);

        em.persist(team);
        em.persist(team2);

        em.flush();
        em.clear();

//        Team findTeam = em.find(Team.class, team.getId());
        List<Team> findTeams = em.createQuery("select t from Team t", Team.class)
                .getResultList();


        for (Team findTeam : findTeams) {
            for (User findUser : findTeam.getUsers()) {
                out.println("findUser = " + findUser);
            }
        }
        tx.commit();
    }

    @DisplayName("merge 테스트 / db에 data row 유무를 떠나 항상 select 를 불러올까?")
    @Test
    void sdvfsadvfsdv() {

        /**
         * db에 없는 경우
         *  - 그냥 저장만 한다.
         *
         * db에 있는 경우
         *  - p.c.에
         *      - 있을 경우 - select x
         *      - 없을 경우 - select o - 심지어 left join
         *
         *  db에 있고 값이 바뀐 경우
         *   - update 쿼리
         *
         * : 결론 merge()매서드 자체는 위험하지 않다...
         *  - select 를 left join 할 뿐... (페치타입 설정과 관계 없이)
         * 다만 화면에서 데이터를 끌어다가 merge 를 이용해서 넣는 경우는 위험하다,
         * 차라리 화면 값의 id를 통해서 가져온 후 다른 값만 변경 감지를 통해서 데이터를 수정하는 게 안전하다!
         */

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        User user = new User("user-1");

        em.persist(user);

        em.flush();
//        em.clear();

        user.setName("other-name");
        em.merge(user);

        tx.commit();
    }

}
