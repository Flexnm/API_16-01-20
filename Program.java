package preTest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

		ArrayList<Project> projects = new ArrayList<Project>();
		ProjectsThread t1 = new ProjectsThread(projects);
		boolean hasTasks = false;
		while (true) {
			Scanner scan = new Scanner(System.in);
			System.out.println(
					"Please choose one of these options:\n1) Create Project\n2) Add task to a specific project\n3) Print projects list\n4) Exit program");
			try {
				int input = scan.nextInt();

				switch (input) {
				case 1:
					System.out.println("What is the name of the project?");
					String name = scan.next();
					Calendar startDate = Calendar.getInstance();
					Calendar endDate = Calendar.getInstance();
					System.out.println("Please enter a deadline:");
					System.out.print("Year: ");
					int year = scan.nextInt();
					System.out.print("Month: ");
					int month = scan.nextInt();
					System.out.print("Day: ");
					int date = scan.nextInt();
					System.out.print("Hour: ");
					int hour = scan.nextInt();
					System.out.print("Minutes: ");
					int minute = scan.nextInt();
					endDate.set(year, month, date, hour, minute);
					projects.add(new Project(name, startDate, endDate));
					if (!(hasTasks)) {
						t1.start();
						hasTasks = true;
					}
					break;
				case 2:
					if (projects.size() > 0) {
						System.out.println(
								"Please enter project index from projects list (enter 0 for first project index). You have "
										+ projects.size() + " projects in the list.");
						int index = scan.nextInt();
						if (index >= projects.size()) {
							System.out.println(
									"You entered a non-existing project index. Please make sure to enter a number that is smaller than "
											+ projects.size());
							break;
						}
						System.out.println("How long will the task take to complete (in minutes)? ");
						projects.get(index).addTask(scan.nextInt());
					} else {
						System.out.println("There are no projects to add tasks for.");
					}
					break;
				case 3:
					if (projects.size() > 0) {
						for (Project project : projects) {
							System.out.println(project);
						}
					} else {
						System.out.println("There are no projects to display.");
					}
					break;
				case 4:
					scan.close();
					return;
				default:
					System.out.println("Invalid input");
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Please enter a valid number.");
			}
		}

	}

}
