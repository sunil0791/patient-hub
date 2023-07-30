package com.straumann.domain.event.publisher;

import com.straumann.domain.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {

    void publish(T domainEvent);
}
