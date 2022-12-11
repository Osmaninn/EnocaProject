package enoca.demoproject.Services.Abstracts;

import java.util.List;

public interface IBaseService<T> {
	
	public void add(T entity);
	
	public void delete(long id);
	
	public void delete(T entity);
	
	public void update(T entity);
	
	public List<T> getAll();
	
	public T getById(long id);
}
