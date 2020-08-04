package it.simonecasamassa.sample.fsm;

import java.lang.reflect.Constructor;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.simonecasamassa.sample.fsm.action.Action;
import it.simonecasamassa.sample.fsm.action.Actions;
import it.simonecasamassa.sample.fsm.model.ActionType;
import it.simonecasamassa.sample.fsm.repository.ActionTypeRepository;

@Component
public class Fsm {

	@Autowired
	private ActionTypeRepository repository;
	@Autowired
	private Actions actionsMapper;

	public void startActions() {
		ActionType actionType = repository.findByActionId(1);
		nextAction(actionType);
	}

	@SuppressWarnings("unchecked")
	private void nextAction(ActionType actionType) {
		try {
			Class<? extends Action> actionClass = actionsMapper.getActionInstance(actionType.getActionId());
			Constructor<? extends Action> constructor = actionClass.getConstructor(ActionTypeRepository.class);
			Action actionInstance = constructor.newInstance(repository);
			List<Integer> nextActions = actionInstance.startAction(actionType);

			for (Integer actionId : nextActions) {
				nextAction(repository.findByActionId(actionId));
			}
		} catch (Exception e) {
			System.out.println("+++++ Exception " + e);
		}
	}

}
