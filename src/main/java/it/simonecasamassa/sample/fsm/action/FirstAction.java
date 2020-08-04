package it.simonecasamassa.sample.fsm.action;

import it.simonecasamassa.sample.fsm.repository.ActionTypeRepository;

public class FirstAction extends Action{

	public FirstAction(ActionTypeRepository actionTypeRepository) {
		super(actionTypeRepository);
	}
	
	@Override
	void command() {
		System.out.println("************** FIRST ACTION ***************");
	}

	
}
