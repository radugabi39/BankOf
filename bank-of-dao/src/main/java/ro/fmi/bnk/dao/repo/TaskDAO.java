package ro.fmi.bnk.dao.repo;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ro.fmi.bnk.dao.utils.GenericDAO;
import ro.fmi.bnk.enitites.Task;
import ro.fmi.bnk.enitites.TaskStatus;
import ro.fmi.bnk.enitites.User;
import ro.fmi.bnk.models.TaskModel;
import ro.fmi.bnk.models.TaskStatusEnum;

@Repository("taskDAO")
public class TaskDAO extends GenericDAO{

	public List<TaskModel> getPendingTasks(String userName){

		Query q = em.createQuery("select new ro.fmi.bnk.models.TaskModel(t.id,t.description,t.creationDate,ts.name,tt.name) from Task t "
				+ " INNER JOIN t.taskStatus ts "
				+ " INNER JOIN t.taskType tt "
				+ " LEFT JOIN t.claimedByUser cu "
				+ " where ts.name='PENDING' OR (cu.userName=:userName AND ts.name='CLAIMED')");
		q.setParameter("userName", userName);
		List<TaskModel> toReturn = q.getResultList();

			return toReturn;

	}
	
	@Transactional
	public void claimTask(Long taskId,User user){
		Task t=em.find(Task.class, taskId);
		TaskStatus ts= getEntityByName(TaskStatus.class, TaskStatusEnum.CLAIMED.toString());
		t.setTaskStatus(ts);
		t.setClaimedByUser(user);
		em.persist(t);
	}

	public Task getByID(Long taskId){
		Task t=em.find(Task.class, taskId);
		return t;
	}
}
