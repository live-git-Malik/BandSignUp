package com.BandStudents.model;

public class Student {
	private String AnumberID;
	private String StudentName;
	private float Fee = 0;
	private String Instrument;

	@Override
	public String toString() {
		return "Student [AnumberID=" + AnumberID + ", StudentName=" + StudentName + ", Fee=" + Fee + ", Instrument="
				+ Instrument + "]";
	}

	public String getInstrument() {
		return Instrument;
	}

	public void setInstrument(String instrument) {
		Instrument = instrument;
	}

	// Writing accessors and mutators
	public String getAnumberID() {
		return AnumberID;
	}

	public void setAnumberID(String anumberID) {
		AnumberID = anumberID;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public float getFee() {
		return Fee;
	}

	public void setFee(float fee) {
		Fee = fee;
	}

}
