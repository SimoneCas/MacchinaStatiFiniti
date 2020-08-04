package it.simonecasamassa.sample.fsm.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import it.simonecasamassa.sample.fsm.model.ActionType;

@DataJpaTest
public class ActionTypeRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ActionTypeRepository repository;
	
	@Test
	public void testFindByActionId() {
		List<Integer> nextActions = new ArrayList<Integer>();
		nextActions.add(10);
		String actionDescription = "Start Action";
		ActionType actionType = new ActionType(1, actionDescription, nextActions);
		entityManager.persist(actionType);
		
		ActionType resultActionType = repository.findByActionId(1);
		
		assertEquals(actionDescription, resultActionType.getActionDescription());
	}
}
