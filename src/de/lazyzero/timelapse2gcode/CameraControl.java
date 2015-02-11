package de.lazyzero.timelapse2gcode;

import java.text.DecimalFormat;

public class CameraControl {
	private static final String[] RELEASE_SHUTTER =  {Gcode.M3, Gcode.G4_P, Gcode.M4};
	
	public static String[] releaseShutter(double delay) {
		String[] command = RELEASE_SHUTTER.clone();
		command[1] = command[1].concat(new DecimalFormat("##.###").format(delay));
		return command;
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
