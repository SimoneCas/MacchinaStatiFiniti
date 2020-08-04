package it.simonecasamassa.sample.fsm;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.simonecasamassa.sample.fsm.model.ActionType;
import it.simonecasamassa.sample.fsm.repository.ActionTypeRepository;

@SpringBootTest
class FsmApplicationTests {

	@Autowired
	private Fsm fsm;
	@Autowired
	private ActionTypeRepository repository;
	
	@Test
	void testTwoActions() {
		ActionType lastActionType = new ActionType(10, "last", null);
		repository.save(lastActionType);
		List<Integer> nextActions = new ArrayList<>();
		nextActions.add(10);
		ActionType firstActionType = new ActionType(1, "start", nextActions);
		repository.save(firstActionType);
		
		fsm.startActions();
		//Verifiare sulla console che vengono invocate solo prima e ultima action (no middle)
	}
	
	@Test
	void testThreeActions() {
		ActionType lastActionType = new ActionType(10, "last", null);
		repository.save(lastActionType);
		
		List<Integer> secondNextActions = new ArrayList<>();
		secondNextActions.add(10);
		ActionType secondActionType = new ActionType(2, "middle", secondNextActions);
		repository.save(secondActionType);
		
		List<Integer> nextActions = new ArrayList<>();
		nextActions.add(2);
		ActionType firstActionType = new ActionType(1, "start", nextActions);
		repository.save(firstActionType);
		
		fsm.startActions();
		//Verifiare sulla console che vengono invocate tutte e tre le action (FIRST, MIDDLE, LAST)
	}

}
