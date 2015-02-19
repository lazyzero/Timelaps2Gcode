package de.lazyzero.timelapse2gcode;

import java.util.Vector;

public class Workflow {
	private String[] workflow;
	private String[] preface;
	private String[] postface;
	private String[] program;
	
	public Workflow(String[] preface, String[] program, String[] postface) {
		this.preface = preface;
		this.program = program;
		this.postface = postface;
		createWorkflow();
	}
	
	private void createWorkflow() {
		//workflow = {preface , program, postface}; 
		workflow = null;
		Vector<String> v = new Vector<String>();
		for (int i = 0; i < preface.length; i++) {
			v.add(preface[i]);
		}
		
		for (int i = 0; i < program.length; i++) {
			v.add(program[i]);
		}
		
		for (int i = 0; i < postface.length; i++) {
			v.add(postface[i]);
		}
		this.workflow = (String[]) v.toArray();
	}
	public void resetWorkflow() {
		this.workflow = null;
	}

	public String[] getWorkflow() {
		if (workflow == null) {
			createWorkflow();
		}
		return workflow;
	}

}
