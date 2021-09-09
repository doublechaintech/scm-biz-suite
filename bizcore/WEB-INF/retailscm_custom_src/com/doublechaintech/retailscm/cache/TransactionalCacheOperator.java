package com.doublechaintech.retailscm.cache;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.jta.JtaTransactionManager;

import java.util.concurrent.Callable;

public class TransactionalCacheOperator extends BaseCacheOperator {
  private JtaTransactionManager transactionManager;

  public JtaTransactionManager getTransactionManager() {
    return transactionManager;
  }

  public void setTransactionManager(JtaTransactionManager pTransactionManager) {
    transactionManager = pTransactionManager;
  }

  private <T> T doInTransaction(Callable<T> callable) {
    TransactionStatus transaction = transactionManager.getTransaction(null);
    boolean newTransaction = transaction.isNewTransaction();
    try {
      return callable.call();
    } catch (Exception e) {
      transaction.setRollbackOnly();
      throw new RuntimeException(e);
    } finally {
      if (newTransaction) {
        transactionManager.commit(transaction);
      }
    }
  }

  public <T> T get(String name, Object key) {
    return doInTransaction(() -> super.get(name, key));
  }

  public boolean contains(String name, Object key) {
    return doInTransaction(() -> super.contains(name, key));
  }

  public Object put(String name, Object key, Object value) {
    return doInTransaction(() -> super.put(name, key, value));
  }

  public boolean clear(String name, Object key) {
    return doInTransaction(() -> super.clear(name, key));
  }

  public boolean remove(String name, Object key) {
    return doInTransaction(() -> super.remove(name, key));
  }

  public boolean clear(String name) {
    return doInTransaction(() -> super.clear(name));
  }
}

















