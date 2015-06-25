package hu.cegnev.todolistapp.business;

import hu.cegnev.todolistapp.model.Todo;
import junit.framework.AssertionFailedError;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TodoLogicTest {
    private TodoLogic todoLogic;

    @Before
    public void setUp() {
        todoLogic = new TodoLogic();
    }

    @Test
    public void testCheckContainById() {
        Todo todo = new Todo(1, "title", "description", new DateTime());
        assertEquals(false, todoLogic.checkContainById(todo));
    }

    @Test
    public void testAdd() {
        Todo todo = new Todo(1, "title", "description", new DateTime());
        todoLogic.add(todo);
        todoLogic.add(todo);
        assertEquals(1, todoLogic.getTodoCount());
    }

    @Test
    public void testGetAvailableTodos() {
        Todo todo = new Todo(1, "title", "description", new DateTime());
        todoLogic.add(todo);
        assertEquals(0, todoLogic.getAvailableItems().size());
    }

    @Test
    public void testRemove() {
        Todo todo = new Todo(1, "title", "description", new DateTime());
        todoLogic.add(todo);
        todoLogic.remove(todo);
        assertEquals(0, todoLogic.getTodoCount());
    }

    @Test
    public void testUpdate() {
        Todo todo = new Todo(1, "title", "description", new DateTime());
        todoLogic.add(todo);
        String updatedTitle = "updated title";
        todo = new Todo(1, updatedTitle, "description", new DateTime());
        todoLogic.update(todo);
        assertEquals(updatedTitle, todoLogic.getTodoById(todo.getId()).getTitle());
    }

    @Test
    public void testTodoListName() {
        String DEVELOPMENT_LIST_NAME = "development";
        String PRODUCTION_LIST_NAME = "production";
        TodoLogic todoLogic = new TodoLogic();

        if (!todoLogic.itemListName.equals(DEVELOPMENT_LIST_NAME) && !todoLogic.itemListName.equals(PRODUCTION_LIST_NAME)) {
            throw new AssertionFailedError(DEVELOPMENT_LIST_NAME + " and " + PRODUCTION_LIST_NAME + " modes are supported only");
        }
    }
}