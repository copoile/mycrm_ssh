package com.briup.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.briup.entity.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao{

	
	//添加用户
	@Override
	public void add(Customer customer) {
		this.getHibernateTemplate().save(customer);
	}

	//查找所有用户
	@SuppressWarnings("all")
	@Override
	public List<Customer> list() {
		return (List<Customer>) this.getHibernateTemplate().find("from Customer");
	}

	//根据id查询客户
	@Override
	public Customer findOneById(Integer id) {
		return this.getHibernateTemplate().get(Customer.class, id);
	}

	@Override
	public void delete(Customer c) {
		this.getHibernateTemplate().delete(c);
	}
	
	//更新客户
	@Override
	public void update(Customer customer) {
		this.getHibernateTemplate().update(customer);
	}

	//查询总记录数
	@SuppressWarnings("all")
	@Override
	public Integer findCount() {
		List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from Customer");
		if(list!=null&&list.size()!=0){
			Object o=list.get(0);
			Long l=(Long) o;
			Integer i=l.intValue();
			return i;
		}
		return 0;
	}
	//分页查询
	@SuppressWarnings("all")
	@Override
	public List<Customer> listPage(Integer begin, Integer pageSize) {
	/*	第一种方式（不常用）
		SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Customer");
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		List<Customer> list = query.list();*/
		
		DetachedCriteria criteria=DetachedCriteria.forClass(Customer.class);
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	//条件查询总记录数
	@SuppressWarnings("all")
	@Override
	public Integer findConditionCount(Customer customer) {
		List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from Customer where custName like ?","%"+customer.getCustName()+"%");
		if(list!=null&&list.size()!=0){
			Object o=list.get(0);
			Long l=(Long) o;
			Integer i=l.intValue();
			return i;
		}
		return 0;
	}
/*	//使用DetachedCriteria离线对象查询记录数
	@SuppressWarnings("all")
	public Integer findCountByCriteria(){
		DetachedCriteria criteria=DetachedCriteria.forClass(Customer.class);
		//有条件时可以添加条件
		criteria.setProjection(Projections.rowCount());
		List<Object> list = (List<Object>) this.getHibernateTemplate().findByCriteria(criteria);
		if(list!=null&&list.size()!=0){
			Object o=list.get(0);
			Long l=(Long) o;
			Integer i=l.intValue();
			return i;
		}
		return 0;
	}*/
	
	//条件查询分页,也多条件查询时使用这种方式
	@SuppressWarnings("all")
	@Override
	public List<Customer> listConditionPage(Integer begin, Integer pageSize,Customer customer) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Customer.class);
		criteria.add(Restrictions.like("custName", "%"+customer.getCustName()+"%"));
	/*	空值时不进行条件添加
		if(customer.getCustName()!=null&&!"".equals(customer.getCustName())){
			criteria.add(Restrictions.like("custName", "%"+customer.getCustName()+"%"));
		}*/
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

}
