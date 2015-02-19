package de.lazyzero.timelapse2gcode;

import java.text.DecimalFormat;

public class CameraControl {
	//sequences of command to be send to the gcode interpreter to do the job
	//shutter connect to coolant pin of GRBL
	private static final String[] RELEASE_SHUTTER =  {Gcode.M8, Gcode.G4_P, Gcode.M9};
	//focus connected to spindle direction pin of GRBL
	private static final String[] FOCUS_ON = { Gcode.M4 };
	private static final String[] FOCUS_OFF = { Gcode.M3 };
	
	public static String[] releaseShutter(double delay) {
		String[] command = RELEASE_SHUTTER.clone();
		command[1] = command[1].concat(new DecimalFormat("##.###").format(delay));
		return command;
	}
	
	public static String[] enableFocus(boolean b) {
		return b ? FOCUS_ON : FOCUS_OFF;
	}
	
	private static String toString(String[] command) {
		StringBuilder sb = new StringBuilder();
		for (String line : command) {
			sb.append(line);
			sb.append(" ");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(toString(releaseShutter(333.22)));
		System.out.println(toString(releaseShutter(333.2225)));
		System.out.println(toString(releaseShutter(0.2)));
	}

}
