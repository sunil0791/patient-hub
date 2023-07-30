/**
 * 
 */
package com.straumann.domain.event;

/**
 * @author Sunil Anjanappa
 *
 */
public interface DomainEvent<T> {
    void fire();
}
