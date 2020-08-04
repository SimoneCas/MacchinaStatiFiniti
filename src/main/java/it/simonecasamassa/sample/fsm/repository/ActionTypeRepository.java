package it.simonecasamassa.sample.fsm.repository;

import org.springframework.data.repository.CrudRepository;

import it.simonecasamassa.sample.fsm.model.ActionType;

public interface ActionTypeRepository extends CrudRepository<ActionType, Integer>{

	public ActionType findByActionId(Integer actionId);
}
