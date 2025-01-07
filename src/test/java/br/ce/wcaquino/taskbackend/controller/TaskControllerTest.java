package br.ce.wcaquino.taskbackend.controller;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.repo.TaskRepo;
import br.ce.wcaquino.taskbackend.utils.ValidationException;

public class TaskControllerTest {

    @Mock
    private TaskRepo taskRepo;

    @InjectMocks
    private TaskController taskController;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validarTaskSemDescricao() {
        Task task = new Task();

        task.setDueDate(LocalDate.now());

        try {
            taskController.save(task);
            Assert.fail();
        } catch (ValidationException e) {
            Assert.assertEquals("Fill the task description", e.getMessage());
        }
    }

    @Test
    public void validarTaskSemData() {
        Task task = new Task();

        task.setTask("Teste");

        try {
            taskController.save(task);
            Assert.fail();
        } catch (ValidationException e) {
            Assert.assertEquals("Fill the due date", e.getMessage());
        }
    }

    @Test
    public void validarTaskComDataPassada() {
        Task task = new Task();

        task.setTask("Teste");
        task.setDueDate(LocalDate.now().plusDays(-1));

        try {
            taskController.save(task);
            Assert.fail();
        } catch (ValidationException e) {
            Assert.assertEquals("Due date must not be in past", e.getMessage());
        }
    }

    @Test
    public void validarTaskCorreta() {
        Task task = new Task();

        task.setTask("Teste");
        task.setDueDate(LocalDate.now());

        try {
            Assert.assertNotNull(taskController.save(task));
        } catch (ValidationException e) {
            Assert.fail();
        }
    }

}
