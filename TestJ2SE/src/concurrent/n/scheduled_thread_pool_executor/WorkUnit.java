package concurrent.n.scheduled_thread_pool_executor;

public class WorkUnit<T> {
  private final T workUnit;

  public T getWork() {
    return workUnit;
  }

  public WorkUnit(T _workUnit) {
	  workUnit = _workUnit;
  }
}
