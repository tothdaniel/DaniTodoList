package hu.cegnev.todolistapp.business;

import hu.cegnev.todolistapp.model.Todo;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class TodoLogic {
    /**
     * The list of the to dos we will process with
     */
    private List<Todo> itemList;

    public String itemListName = "development";

    /**
     * The constructor to initialize the list.
     */
    public TodoLogic() {
        this.itemList = new ArrayList<>();
    }

    /**
     * This function says if the to doCheck parameter is already added to the list or not by id matching
     * @param itemToCheck the to do item to check
     * @return the result of the id containment
     */
    public boolean checkContainById(Todo itemToCheck){
        for(Todo todo: itemList){
            if(todo.getId() == itemToCheck.getId()){
                return true;
            }
        }
        return false;
    }

    /**
     * This function returns the count of the items in the to do list
     * @return the count of the items in the to do list
     */
    public int getTodoCount(){
        return itemList.size();
    }

    /**
     * This function adds the given to do to the list if it was not yet.
     * @param itemToAdd the to do to add to the list
     */
    public void add(Todo itemToAdd){
        if(!checkContainById(itemToAdd)){
            itemList.add(itemToAdd);
        }
    }

    /**
     * This function returns all the to dos they have a deadline that is after the current time.
     * @return the available to dos
     */
    public List<Todo> getAvailableItems(){
        List<Todo> availableTodos = new ArrayList<>();
        for(Todo todo: itemList){
            if(todo.getDeadLine().isAfter(new DateTime().getMillis())){
                availableTodos.add(todo);
            }
        }
        return availableTodos;
    }

    /**
     * This function returns the given to do from the to do list.
     * @param itemToRemove the to do item to be removed
     */
    public void remove(Todo itemToRemove){
        int todoId = itemToRemove.getId();
        for(Todo todo: itemList){
            if(todo.getId() == todoId){
                itemList.remove(todo);
                return;
            }
        }
    }

    /**
     * This function allows you to update the to do to the given to do parameter
     * @param itemToUpdate the to do to update
     */
    public void update(Todo itemToUpdate){
        int todoId = itemToUpdate.getId();
        for(int todoIndex = 0; todoIndex < itemList.size(); todoIndex++){
            Todo todo = itemList.get(todoIndex);
            if(todo.getId() == todoId){
                itemList.remove(todo);
                itemList.add(todoIndex, itemToUpdate);
                return;
            }
        }
    }

    /**
     * This function returns the to do object that matches with the given id if exists
     * @param itemId the id of the object
     * @return the todo object that has the given id
     */
    public Todo getTodoById(int itemId){
        for(Todo todo: itemList){
            if(todo.getId() == itemId){
                itemList.remove(todo);
                return todo;
            }
        }
        return null;
    }


    /**
     * This function updates the to do in the to do list
     * @param editedItem the updated to do
     */
    public void editTodo(Todo editedItem){
        for(int todoIndex = 0;todoIndex < itemList.size(); todoIndex++){
            if(itemList.get(todoIndex).getId() == editedItem.getId()){
                itemList.set(todoIndex, editedItem);
                return;
            }
        }
    }

}