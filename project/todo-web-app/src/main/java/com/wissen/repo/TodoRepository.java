package com.wissen.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wissen.model.Todo;

@Repository ("todoRepository")
public interface TodoRepository extends JpaRepository<Todo, Integer>{
	
	@Query("delete from Todo t where t.user.id=?1")
	public void deleteCompleted(int u_id);
	
	@Query("from Todo t where t.user.id=?1")
	public List<Todo> getAllTodoByUser(int u_id);
	
	@Query ("update Todo t set t.completed=?1 where t.user.id=?2")
	public List<Todo> setNewCompleteByUser(boolean new_completed, int u_id);
	
}
