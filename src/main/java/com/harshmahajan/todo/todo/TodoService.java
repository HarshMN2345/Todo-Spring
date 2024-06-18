package com.harshmahajan.todo.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

@Service
@SessionAttributes("name")
public class TodoService {
    private static int todoCounter = 0;
    private static List<Todo> todos=new ArrayList<>();
    static{
        todos.add(new Todo(++todoCounter,"harshmahajan","aws","aaj complete karna", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++todoCounter,"harshmahajan","azure","aaj complete karna", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++todoCounter,"harshmahajan","fullstack dev","aaj complete karna", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++todoCounter,"harshmahajan","machine learning","aaj complete karna", LocalDate.now().plusYears(1),false));
    }
    public List<Todo> getTodos(String name){
        Predicate<? super Todo> predicate =
                todo -> todo.getName().equalsIgnoreCase(name);
        return todos.stream().filter(predicate).toList();
    }
    public void addTodo(String name,String title, String description, LocalDate dueDate, boolean completed){
       Todo todo = new Todo(++todoCounter,name, title, description, dueDate, completed);
       todos.add(todo);
    }
    public static void deleteTodo(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo=todos.stream().filter(predicate).findFirst().orElse(null);
        return todo;
    }

    public void updateTodo(@Valid Todo todo) {
        deleteTodo(todo.getId());
        todos.add(todo);
    }
}
