package it.simonecasamassa.sample.fsm.action;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.metamodel.StaticMetamodel;

import org.springframework.stereotype.Component;

@Component
public class Actions {

	private Map<Integer, Class> mapping = new HashMap<>();
	
	public Actions() {
		mapping.put(1, FirstAction.class);
		mapping.put(2, MiddleAction.class);
		mapping.put(10, LastAction.class);
	}
	
	public Class getActionInstance(Integer actionId) {
		return mapping.get(actionId);
	}
}
