package it.simonecasamassa.sample.fsm.action;

import it.simonecasamassa.sample.fsm.repository.ActionTypeRepository;

public class LastAction extends Action{

	public LastAction(ActionTypeRepository actionTypeRepository) {
		super(actionTypeRepository);
	}
	
	@Override
	void command() {
		System.out.println("************** LAST ACTION ***************");
	}

	
}