package com.cgt.training.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cgt.training.entity.Training;
import com.cgt.training.facade.TrainingDao;
@Repository
@Transactional
public class TrainingDaoImpl implements TrainingDao {

	@PersistenceContext
	private EntityManager entity;
	
	@Override
	public boolean addTraining(Training training) {
		training.setProgress(0);
		training.setRequest(0);
		training.setAmount_received(0);
		this.entity.persist(training);
		return true;
	}

	@Override
	public boolean deleteTraining(Integer id) {
		Training training = this.entity.find(Training.class, id);
		training.setRequest(2);
		this.entity.flush();
		return true;
	}

	@Override
	public Training getTraining(Integer id) {
		Training training = this.entity.find(Training.class, id);
		return training;
	}

	@Override
	public List<Training> getAllTraining() {
		List<Training> trainingList = this.entity.createQuery("From Training").getResultList();
		return trainingList;
	}

	@Override
	public boolean updateTraining(Training training) {
		Training updatetraining = this.entity.find(Training.class, training.getId());
		updatetraining.setRequest(training.getRequest());
		updatetraining.setAmount_received(training.getAmount_received());
		updatetraining.setProgress(training.getProgress());
		this.entity.flush();
		return false;
	}

	@Override
	public List<Training> getTrainingByMentorId(Integer mentor_id) {
		List<Training> trainingList = this.entity.createQuery("From Training tr where tr.mentor_id="+mentor_id+" and request=1 and isactive=1").getResultList();
		return trainingList;
	}

	@Override
	public List<Training> getTrainingByTechId(Integer tech_id) {
		List<Training> trainingList = this.entity.createQuery("From Training tr where tr.tech_id="+tech_id+" and request=1 and isactive=1").getResultList();
		return trainingList;
	}

	@Override
	public Boolean checkSlot(Integer slot_id) {
		List<Training> getTraining= this.entity.createQuery("From Training tr where tr.slot_id="+slot_id+" and request=1 and isactive=1").getResultList();
		if(getTraining.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public List<Training> getAllRequest(Integer mentor_id) {
		List<Training> trainingList = this.entity.createQuery("From Training tr where tr.mentor_id="+mentor_id+" and request=0 and isactive=1").getResultList();
		return trainingList;
		
	}

	@Override
	public List<Training> getCompletedTraining(Integer mentor_id) {
		List<Training> trainingList = this.entity.createQuery("From Training tr where tr.mentor_id="+mentor_id+" and isactive=0").getResultList();
		return trainingList;
	}

	@Override
	public List<Training> getUserPendingRequest(Integer user_id) {
		List<Training> trainingList = this.entity.createQuery("From Training tr where tr.user_id="+user_id+" and request=0 and isactive=1").getResultList();
		return trainingList;
	}

	@Override
	public List<Training> getUserRunTraining(Integer user_id) {
		List<Training> trainingList = this.entity.createQuery("From Training tr where tr.user_id="+user_id+" and request=1 and isactive=1").getResultList();
		return trainingList;
	}

	@Override
	public List<Training> getUserCompletedTraining(Integer user_id) {
		List<Training> trainingList = this.entity.createQuery("From Training tr where tr.user_id="+user_id+" and isactive=0").getResultList();
		return trainingList;
	}

}
