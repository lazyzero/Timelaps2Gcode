package de.lazyzero.timelapse2gcode;

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
		workflow = new String[preface.length + program.length + postface.length];
		for (int i = 0; i < preface.length; i++) {
			workflow[i] = preface[i];
		}
		int offset = preface.length;
		for (int i = 0; i < program.length; i++) {
			workflow[i + offset] = program[i + offset];
		}
		offset += program.length;
		for (int i = 0; i < postface.length; i++) {
			workflow[i + offset] = postface[i + offset];
		}
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
