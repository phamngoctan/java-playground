package com.tanpham.ddd.pattern;

public class BacklogItemApplicationService {
	public void commitBacklogItem(
		Tenant aTenant,
		BacklogItemId aBacklogItemId,
		SprintId aSprintId) {
		DomainEventSubscriber subscriber = new DomainEventSubscriber<BacklogItemCommitted>() {
			@Override
			public void handleEvent(BacklogItemCommitted aDomainEvent) {
			// handle event here ...
			}
			@Override
			public Class<BacklogItemCommitted> subscribedToEventType() {
				return BacklogItemCommitted.class;
			}
		}
		DomainEventPublisher.instance().subscribe(subscriber);
		BacklogItem backlogItem = backlogItemRepository.backlogItemOfId(aTenant, aBacklogItemId);
		Sprint sprint = sprintRepository.sprintOfId(aTenant, aSprintId);
		backlogItem.commitTo(sprint);
	}
}
