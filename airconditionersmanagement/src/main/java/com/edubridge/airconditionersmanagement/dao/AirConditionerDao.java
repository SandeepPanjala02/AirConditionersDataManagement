package com.edubridge.airconditionersmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.edubridge.airconditionersmanagement.model.AirConditioner;
import com.edubridge.airconditionersmanagement.utils.HibernateUtils;

public class AirConditionerDao implements AirConditionerDaoI{

	@Override
	public void addairconditioner(AirConditioner ac) {
		Transaction tx = null;

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			session.persist(ac);
			tx = session.beginTransaction();
			tx.commit();
			System.out.println("new contact addedd!");
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

	}
	
	

	@Override
	public List<AirConditioner> getAllAirConditioners() {
		List<AirConditioner> airconditioners = new ArrayList<AirConditioner>();
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
              
			String hql = "from AirConditioners";
			Query query = session.createQuery(hql, AirConditioner.class);
			airconditioners = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return airconditioners;
	}



	@Override
	public AirConditioner getAirConditionerById(Integer id) {
		AirConditioner airconditioner = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			airconditioner = session.get(AirConditioner.class, id);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return airconditioner;

	}

	@Override
	public void UpdateAirConditioner(AirConditioner airconditioner) {
		Transaction tx = null;

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			session.merge(airconditioner);
			tx = session.beginTransaction();
			tx.commit();
			System.out.println("airconditioner is updated!");

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

	}

	@Override
	public void deleteAirConditioner(Integer id) {
		Transaction tx = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			tx = session.beginTransaction();

			AirConditioner airconditioner = session.get(AirConditioner.class, id);

				if (airconditioner != null) {
					session.remove(airconditioner);
					tx.commit();
					System.out.println("AirConditioner is deleted!");
				} else {
					System.out.println("no airconditioner found!");
				}
			} catch (Exception e) {
				tx.rollback();
				e.printStackTrace();
			}
 
			
		}


	@Override
	public void deleteAllAirConditioners() {
		Transaction tx = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			String hql = "delete from AirCondition";
			Query query = session.createQuery(hql);
			query.executeUpdate();
			System.out.println("All airconditioners are deleted");
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

	}

}
