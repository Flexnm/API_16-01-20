package preTest;

import java.util.ArrayList;
import java.util.Calendar;

public class ProjectsThread extends Thread {

	private ArrayList<Project> projects;

	public ProjectsThread(ArrayList<Project> projects) {
		setP(projects);
	}

	public ArrayList<Project> getP() {
		return projects;
	}

	public void setP(ArrayList<Project> projects) {
		this.projects = projects;
	}

	public void timeLeft(Project project) {
		Calendar cal1 = Calendar.getInstance();
		int y1 = cal1.get(Calendar.YEAR);
		int m1 = cal1.get(Calendar.MONTH);
		int d1 = cal1.get(Calendar.DATE);
		int h1 = cal1.get(Calendar.HOUR);
		int mm1 = cal1.get(Calendar.MINUTE);

		int y2 = project.getEnd().get(Calendar.YEAR);
		int m2 = project.getEnd().get(Calendar.MONTH);
		int d2 = project.getEnd().get(Calendar.DATE);
		int h2 = project.getEnd().get(Calendar.HOUR);
		int mm2 = project.getEnd().get(Calendar.MINUTE);

		if (cal1.compareTo(project.getEnd()) < 0) {

			int y = Math.abs(y2 - y1);
			int m = Math.abs(m2 - m1);
			if (m2 < m1) {
				m = 12 - m;
				if (y > 0) {
					y--;
				}
			}
			int d = Math.abs(d2 - d1);
			if (d2 < d1) {
				d = 30 - d;
				if (m > 0) {
					m--;
				}
			}
			int h = Math.abs(h2 - h1);
			if (h2 < h1) {
				h = 24 - h;
				if (d > 0) {
					d--;
				}
			}
			int mm = Math.abs(mm2 - mm1);
			if (mm2 < mm1) {
				mm = 60 - mm;
				if (h > 0) {
					h--;
				}
			}

			System.out.println("Project " + project.getName() + " has " + y + " year(s), " + m + " month(s), " + d
					+ " day(s), " + h + " hour(s) and " + mm + " minute(s) left to complete.");
		} else {
			System.out.println("Project " + project.getName() + "'s deadline has passed.");
		}
	}

	public void run() {
		while (true) {
			setP(projects);

			for (Project project : projects) {
				timeLeft(project);
			}

			try {
				Thread.sleep(1000 * 30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
