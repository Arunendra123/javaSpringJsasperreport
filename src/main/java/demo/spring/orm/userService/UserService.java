package demo.spring.orm.userService;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.orm.hibernate5.HibernateTemplate;
import demo.spring.orm.userDao.UserDao;
import demo.spring.orm.userEntity.LocalUser;

public class UserService implements UserDao{

    private HibernateTemplate hibernateTemplate;
	
    @Transactional
	public void add(LocalUser user) {
		hibernateTemplate.save(user);
	}

    @Transactional
	@Override
	public void update(LocalUser user) {
		hibernateTemplate.update(user);
	}

    @Transactional
	@Override
	public void delete(int id) {
		hibernateTemplate.delete(hibernateTemplate.get(LocalUser.class,id));
	}
	
	@Override
	public LocalUser getLocalUser(int id) {
		return hibernateTemplate.get(LocalUser.class,id);
	}

	@Override
	public List<LocalUser> list() {
		return hibernateTemplate.loadAll(LocalUser.class);
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
