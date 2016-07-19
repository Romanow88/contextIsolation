package com.test.context;

/**
 * Registry for services
 *
 * This should be implemented in the root context and be available
 * to the child contexts.
 */
public interface Registry
{
  /**
   * Export a given service
   */
  Void export(String name, Object target);

  /**
   * Import a service by it's name
   * @param name - name for the lookup, used during export
   * @param clazz - expected service interface
   * @return proxy of the needed service
   */
  <T> T lookup(final String name, final Class<T> clazz);
}
