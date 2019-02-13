package luzq.std.jstd.spbt.dao.master;

import luzq.std.jstd.spbt.model.master.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User getUserById(int id);
}
