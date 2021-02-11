package org.eclipse.interfaces;

import org.eclipse.model.Fan;

public interface Subject {
public void subscribe(Observer o);
public void unsubscribe(Observer o);
public void notifier();

}
