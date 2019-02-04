package com.kaeam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jbpm.test.JBPMHelper;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeEnvironmentBuilder;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.manager.RuntimeManagerFactory;
import org.kie.api.task.TaskService;
import org.kie.api.task.model.TaskSummary;

public class ProcessMain {

	public static void main(String[] args) {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieBase kbase = kContainer.getKieBase("kbase");

		RuntimeManager manager = createRuntimeManager(kbase);
		RuntimeEngine engine = manager.getRuntimeEngine(null);
		KieSession ksession = engine.getKieSession();
		TaskService taskService = engine.getTaskService();

		Map<String, Object> params = new HashMap<String, Object>();
        // initialize variables here if necessary
        params.put("username", "John"); // type String
        // params.put("password", value); // type String
        // params.put("company", value); // type String
        // params.put("elicit_stg_rmp", value); // type String
        // params.put("elicit_imp_rmp", value); // type String
        // params.put("search_candidate_sol", value); // type String
        // params.put("discover_reuse_sol", value); // type String
        // params.put("discover_rev_sol_name", value); // type String
        // params.put("discover_rev_sol_ver", value); // type String
        // params.put("reuse_sol_artifact", value); // type String
        // params.put("adapt_artifact", value); // type String
        // params.put("deploy_sol", value); // type String
        // params.put("kaeam_initiator", value); // type String
        // params.put("kaeam_start_reason", value); // type String
        // params.put("archemist", value); // type String
		
		// ksession.startProcess("com.kaeam.bpmn.hello"); // ORIGINAL
        ksession.startProcess("com.eamtk.bpmn.kaeam", params);

		// let john execute Login Task 
		List<TaskSummary> list = taskService.getTasksAssignedAsPotentialOwner("john", "en-UK");
		TaskSummary task = list.get(0);
		System.out.println("John is executing task " + task.getName());
		taskService.start(task.getId(), "john");
        //Map<String, Object> results = new HashMap<String, Object>();
        // add results here
        //results.put("password", "krisv"); // type String
		taskService.complete(task.getId(), "john", null);

		// let mary execute Solution Task
		list = taskService.getTasksAssignedAsPotentialOwner("mary", "en-UK");
		task = list.get(0);
		System.out.println("Mary is executing task " + task.getName());
		taskService.start(task.getId(), "mary");
		taskService.complete(task.getId(), "mary", null);
		
		// let john execute Build Task
		list = taskService.getTasksAssignedAsPotentialOwner("john", "en-UK");
		task = list.get(0);
		System.out.println("John is executing task " + task.getName());
		taskService.start(task.getId(), "john");
        //Map<String, Object> results = new HashMap<String, Object>();
        // add results here
        //results.put("password", "krisv"); // type String
		taskService.complete(task.getId(), "john", null);
		
		// let john execute KAEAM Elicit Task
		list = taskService.getTasksAssignedAsPotentialOwner("john", "en-UK");
		task = list.get(0);
		System.out.println("John is executing task " + task.getName());
		taskService.start(task.getId(), "john");
        //Map<String, Object> results = new HashMap<String, Object>();
        // add results here
        //results.put("password", "krisv"); // type String
		taskService.complete(task.getId(), "john", null);
		
		// let john execute KAEAM Search Task
		list = taskService.getTasksAssignedAsPotentialOwner("john", "en-UK");
		task = list.get(0);
		System.out.println("John is executing task " + task.getName());
		taskService.start(task.getId(), "john");
        //Map<String, Object> results = new HashMap<String, Object>();
        // add results here
        //results.put("password", "krisv"); // type String
		taskService.complete(task.getId(), "john", null);
		
		// let john execute KAEAM Discover Task
		list = taskService.getTasksAssignedAsPotentialOwner("john", "en-UK");
		task = list.get(0);
		System.out.println("John is executing task " + task.getName());
		taskService.start(task.getId(), "john");
        //Map<String, Object> results = new HashMap<String, Object>();
        // add results here
        //results.put("password", "krisv"); // type String
		taskService.complete(task.getId(), "john", null);
		
		// let john execute Discover Review Task
		list = taskService.getTasksAssignedAsPotentialOwner("john", "en-UK");
		task = list.get(0);
		System.out.println("John is executing task " + task.getName());
		taskService.start(task.getId(), "john");
        //Map<String, Object> results = new HashMap<String, Object>();
        // add results here
        //results.put("password", "krisv"); // type String
		taskService.complete(task.getId(), "john", null);
		
		// let john execute KAEAM  Reuse Task
		list = taskService.getTasksAssignedAsPotentialOwner("john", "en-UK");
		task = list.get(0);
		System.out.println("John is executing task " + task.getName());
		taskService.start(task.getId(), "john");
        //Map<String, Object> results = new HashMap<String, Object>();
        // add results here
        //results.put("password", "krisv"); // type String
		taskService.complete(task.getId(), "john", null);
		
		// let john execute KAEAM Adapt Task
		list = taskService.getTasksAssignedAsPotentialOwner("john", "en-UK");
		task = list.get(0);
		System.out.println("John is executing task " + task.getName());
		taskService.start(task.getId(), "john");
        //Map<String, Object> results = new HashMap<String, Object>();
        // add results here
        //results.put("password", "krisv"); // type String
		taskService.complete(task.getId(), "john", null);
		
		// let john execute KAEAM Deploy Task
		list = taskService.getTasksAssignedAsPotentialOwner("john", "en-UK");
		task = list.get(0);
		System.out.println("John is executing task " + task.getName());
		taskService.start(task.getId(), "john");
        //Map<String, Object> results = new HashMap<String, Object>();
        // add results here
        //results.put("password", "krisv"); // type String
		taskService.complete(task.getId(), "john", null);
//		int x = 1;
//		while (x == 1) {
//			
//		}
		manager.disposeRuntimeEngine(engine);
		System.exit(0);
	}

	private static RuntimeManager createRuntimeManager(KieBase kbase) {
		JBPMHelper.startH2Server();
		JBPMHelper.setupDataSource();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.jbpm.persistence.jpa");
		RuntimeEnvironmentBuilder builder = RuntimeEnvironmentBuilder.Factory.get()
			.newDefaultBuilder().entityManagerFactory(emf)
			.knowledgeBase(kbase);
		return RuntimeManagerFactory.Factory.get()
			.newSingletonRuntimeManager(builder.get(), "com.eamtk:version:1.0");
			//.newSingletonRuntimeManager(builder.get(), "com.kaeam:example:1.0");
	}

}