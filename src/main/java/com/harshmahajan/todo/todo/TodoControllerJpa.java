package com.harshmahajan.todo.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {

    public TodoControllerJpa(TodoRepository todoRepository) {
        super();
        this.todoRepository=todoRepository;
    }
    private TodoRepository todoRepository;

    @RequestMapping("list-todos")
    public String ListAllTodos(ModelMap model){
        String name= getLoggedInName(model);

        List<Todo> todos = todoRepository.getAllByName(name);
        model.addAttribute("todos", todos);
        return "ListAllTodos";
    }
    @RequestMapping(value="add-todo",method= RequestMethod.GET)
    public String showNewTodo(ModelMap model){
        String name= getLoggedInName(model);
        Todo todo=new Todo(0,name,"add a title...","",LocalDate.now().plusYears(1),false);
        model.put("todo", todo);
        return "todo";
    }

    private static String getLoggedInName(ModelMap model) {
        Authentication authentication=
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @RequestMapping(value="add-todo",method= RequestMethod.POST)
    public String addNewTodo(@Valid @ModelAttribute("todo") Todo todo,BindingResult result, ModelMap model){
        if(result.hasErrors()){
            return "todo";
        }
        String name= getLoggedInName(model);
        todo.setName(name);
        todoRepository.save(todo);
        return "redirect:/list-todos";
    }
    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){
        todoRepository.deleteById(id);
        return "redirect:/list-todos";
    }
    @RequestMapping(value="update-todo",method= RequestMethod.GET)
    public String showUpdateTodo(@RequestParam int id,ModelMap model){
        Todo todo=todoRepository.findById(id).get();
        model.addAttribute("todo", todo);
        return "todo";
    }
    @RequestMapping(value="update-todo",method= RequestMethod.POST)
    public String UpdateTodo(@Valid @ModelAttribute("todo") Todo todo,BindingResult result, ModelMap model){
        if(result.hasErrors()){
            return "todo";
        }
        String name= getLoggedInName(model);
        todo.setName(name);
        todoRepository.save(todo);
        return "redirect:/list-todos";
    }
}
