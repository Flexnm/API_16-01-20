package preTest;

import java.util.Calendar;

public class Project {

	private String name;
	private int numOfTasks;
	private Calendar startDate;
	private Calendar endDate;

	public Project(String name, Calendar startDate, Calendar endDate) {
		this.name = name;
		setStart(startDate);
		setEnd(endDate);
	}

	public Calendar getStart() {
		return startDate;
	}

	public Calendar getEnd() {
		return endDate;
	}

	public String getName() {
		return name;
	}

	public void setStart(Calendar startDate) {
		this.startDate = startDate;
	}

	public void setEnd(Calendar endDate) {
		this.endDate = endDate;
	}

	public int getTasks() {
		return numOfTasks;
	}

	public void addTask(int minutes) {
		Calendar cal = getEnd();
		cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + minutes);
		setEnd(cal);
		numOfTasks++;
	}
	
	public String toString() {
		return "Project " + name + " has " + numOfTasks + " tasks. It started at " + startDate.getTime() + " and it is due date at " + endDate.getTime();
	}

}
