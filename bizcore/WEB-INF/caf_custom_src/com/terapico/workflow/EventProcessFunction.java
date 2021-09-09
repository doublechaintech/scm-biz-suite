package com.terapico.workflow;

@FunctionalInterface
public interface EventProcessFunction {
    boolean process(ProcessInstance instance, Actor actor, Node node, Event event) throws Exception;
}
