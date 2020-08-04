package it.simonecasamassa.sample.fsm.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACTION_TYPE")
public class ActionType {

	@Id																																																																					
	private Integer actionId;
	private String actionDescription;
	@ElementCollection(fetch = FetchType.EAGER)
	private List<Integer> nextActions;
	
	public ActionType() {
		
	}

	public ActionType(Integer actionId, String actionDescription, List<Integer> nextActions) {
		super();
		this.actionId = actionId;
		this.actionDescription = actionDescription;
		this.nextActions = nextActions;
	}

	public Integer getActionId() {
		return actionId;
	}

	public void setActionId(Integer actionId) {
		this.actionId = actionId;
	}

	public String getActionDescription() {
		return actionDescription;
	}

	public void setActionDescription(String actionDescription) {
		this.actionDescription = actionDescription;
	}

	public List<Integer> getNextActions() {
		return nextActions;
	}

	public void setNextActions(List<Integer> nextActions) {
		this.nextActions = nextActions;
	}

	@Override
	public String toString() {
		return "ActionType [actionId=" + actionId + ", actionDescription=" + actionDescription + ", nextActions="
				+ nextActions + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actionDescription == null) ? 0 : actionDescription.hashCode());
		result = prime * result + ((actionId == null) ? 0 : actionId.hashCode());
		result = prime * result + ((nextActions == null) ? 0 : nextActions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActionType other = (ActionType) obj;
		if (actionDescription == null) {
			if (other.actionDescription != null)
				return false;
		} else if (!actionDescription.equals(other.actionDescription))
			return false;
		if (actionId == null) {
			if (other.actionId != null)
				return false;
		} else if (!actionId.equals(other.actionId))
			return false;
		if (nextActions == null) {
			if (other.nextActions != null)
				return false;
		} else if (!nextActions.equals(other.nextActions))
			return false;
		return true;
	}
}
