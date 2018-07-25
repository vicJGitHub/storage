package com.hywa.bigdata.storage.common.activiti;

import org.activiti.bpmn.model.EndEvent;
import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.bpmn.model.StartEvent;
import org.activiti.bpmn.model.UserTask;

import java.util.List;


public class ActivitiUtils {

    //创建task个人任务
    public static UserTask createUserTask(String id, String name, String assignee) {
        UserTask userTask = new UserTask();
        userTask.setName(name);
        userTask.setId(id);
        userTask.setAssignee(assignee);
        return userTask;
    }

    //创建task组任务
    public static UserTask createGroupTask(String id, String name,List<String> list) {
        UserTask userTask = new UserTask();
        userTask.setName(name);
        userTask.setId(id);
        //此处通过部门查询所有用信息(通过各部门id查询人员)
        userTask.setCandidateGroups(list);
        return userTask;
    }

    //创建箭头
    public static SequenceFlow createSequenceFlow(String from, String to) {
        SequenceFlow flow = new SequenceFlow();
        flow.setSourceRef(from);
        flow.setTargetRef(to);
        return flow;
    }

    //创建开始任务点
    public static StartEvent createStartEvent() {
        StartEvent startEvent = new StartEvent();
        startEvent.setId("start");
        return startEvent;
    }

    //创建结尾任务点
    public static EndEvent createEndEvent() {
        EndEvent endEvent = new EndEvent();
        endEvent.setId("end");
        return endEvent;
    }



}