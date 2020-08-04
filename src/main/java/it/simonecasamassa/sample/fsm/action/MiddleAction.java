package it.simonecasamassa.sample.fsm.action;

import it.simonecasamassa.sample.fsm.repository.ActionTypeRepository;

public class MiddleAction extends Action{

	public MiddleAction(ActionTypeRepository actionTypeRepository) {
		super(actionTypeRepository);
	}
	@Override
	void command() {
		System.out.println("************** MIDDLE ACTION ***************");
	}
}