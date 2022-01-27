package demo.spring.orm.userDao;

import java.util.List;

import demo.spring.orm.userEntity.LocalUser;

public interface UserDao {
        public void add(LocalUser user);
        public void update(LocalUser user);
        public void delete(int id);
        public List<LocalUser> list();
        public LocalUser getLocalUser(int id);
}
