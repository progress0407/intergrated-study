package jpa.app.shop.repository.trial_fail;

import org.springframework.stereotype.Repository;

@Repository
public interface UtilInterfaceRepository<T> {

    void clear();
}
