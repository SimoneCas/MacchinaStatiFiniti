package it.simonecasamassa.sample.fsm.action;

import java.util.List;

import it.simonecasamassa.sample.fsm.model.ActionType;
import it.simonecasamassa.sample.fsm.repository.ActionTypeRepository;

public abstract class Action {

	private ActionTypeRepository actionTypeRepository;
	
	Action(ActionTypeRepository actionTypeRepository) {
		this.actionTypeRepository = actionTypeRepository;
	}
	
	public List<Integer> startAction(ActionType actionType) {
		command();
		ActionType findByActionId = actionTypeRepository.findByActionId(actionType.getActionId());
		return findByActionId.getNextActions();
	}
	
	abstract void command();
}
