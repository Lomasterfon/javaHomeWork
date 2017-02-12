package homework3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Group implements Commissar {
	private Student[] group = new Student[10];
	private int counterStudent = 0;

	public Group() {
		super();
	}

	public Group(Student[] group, int counterStudent) {
		super();
		this.group = group;
		this.counterStudent = counterStudent;
	}

	public void addStudent(Student student) throws MyException {
		if (counterStudent >= 10)
			throw new MyException();
		for (int i = 0; i < group.length; i++) {
			if (group[i] == null) {
				group[i] = student;
				counterStudent = counterStudent + 1;
				System.out.println("Student - " + student + " - added in the group!");
				break;
			}
		}
	}

	public void delStudent(Student surname) {
		for (int i = 0; i < group.length; i++) {
			if (group[i].equals(surname)) {
				group[i] = null;
				counterStudent = counterStudent - 1;
				System.out.println("Student - " + surname + " - has been deleted from group.");
			}
		}
	}

	public void searchStudent(String surname) {
		boolean f = false;
		for (int i = 0; i < group.length; i++) {
			if ((group[i] != null) && (group[i].getSurname().equals(surname))) {
				System.out.println("Student - " + surname + ": " + group[i]);
				f = true;
				break;
			}
		}
		if (f == false)
			System.out.println("Student - " + surname + ": " + "not found");

	}

	public void sortGroup(int paramSort) {
		switch (paramSort) {
		case 1:
			Arrays.sort(group,
					(a, b) -> checkNull(a, b) == 2 ? a.getSurname().compareTo(b.getSurname()) : checkNull(a, b));
			break;
		case 2:
			Arrays.sort(group, (a, b) -> checkNull(a, b) == 2 ? a.getName().compareTo(b.getName()) : checkNull(a, b));
			break;
		case 3:
			Arrays.sort(group, (a, b) -> checkNull(a, b) == 2 ? Integer.valueOf(a.getAge()).compareTo(b.getAge())
					: checkNull(a, b));
			break;
		case 4:
			Arrays.sort(group, (a, b) -> checkNull(a, b) == 2 ? Double.valueOf(a.getWeight()).compareTo(b.getWeight())
					: checkNull(a, b));
			break;
		case 5:
			Arrays.sort(group,
					(a, b) -> checkNull(a, b) == 2 ? a.getGender().compareTo(b.getGender()) : checkNull(a, b));
			break;
		case 6:
			Arrays.sort(group, (a, b) -> checkNull(a, b) == 2 ? Integer.valueOf(a.getCourse()).compareTo(b.getCourse())
					: checkNull(a, b));
			break;
		case 7:
			Arrays.sort(group,
					(a, b) -> checkNull(a, b) == 2 ? a.getFaculty().compareTo(b.getFaculty()) : checkNull(a, b));

		}
	}

	public static int checkNull(Object a, Object b) {
		if ((a != null) && (b == null)) {
			return -1;
		}
		if ((a == null) && (b != null)) {
			return 1;
		}
		if ((a == null) && (b == null)) {
			return 0;
		}
		return 2;
	}

	public void keyboardInput() throws MyException, IOException {
		if (counterStudent >= 10)
			throw new MyException();
		Student newStudent = new Student();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < group.length; i++) {
			if (group[i] == null) {
				System.out.println("Enter name: ");
				newStudent.setName(reader.readLine());
				System.out.println("Enter surname: ");
				newStudent.setSurname(reader.readLine());
				System.out.println("Enter gender: ");
				newStudent.setGender(reader.readLine());
				System.out.println("Enter weight: ");
				newStudent.setWeight(Double.parseDouble(reader.readLine()));
				System.out.println("Enter age: ");
				newStudent.setAge(Integer.parseInt(reader.readLine()));
				System.out.println("Enter faculty: ");
				newStudent.setFaculty(reader.readLine());
				System.out.println("Enter course: ");
				newStudent.setCourse(Integer.parseInt(reader.readLine()));
				System.out.println("Enter studentID: ");
				newStudent.setStudentID(Integer.parseInt(reader.readLine()));
				group[i] = newStudent;
				break;
			}
		}

	}

	public Group getReservist() throws Exception {
		Group reservists = new Group();
		for (int i = 0; i < group.length; i++) {
			if (group[i] != null) {
				if ((group[i].getAge() > 18) && (group[i].getGender().equals("male"))) {
					reservists.addStudent(group[i]);
				}
			}
		}
		return reservists;
	}

	public void saveGroupFile(File file) {
		try (PrintWriter pw = new PrintWriter(file)) {
			for (Student student : group) {
				pw.print(student.getName() + ",");
				pw.print(student.getSurname() + ",");
				pw.print(student.getGender() + ",");
				pw.print(student.getWeight() + ",");
				pw.print(student.getAge() + ",");
				pw.print(student.getFaculty() + ",");
				pw.print(student.getCourse() + ",");
				pw.println(student.getStudentID());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Group saved!");
	}

	public void loadGroupFile(File file) throws Exception {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String s;
			for (int i = 0; (s = br.readLine()) != null; i++) {
				Student student = new Student();
				String[] str = s.split(",");
				student.setName(str[0]);
				student.setSurname(str[1]);
				student.setGender(str[2]);
				student.setWeight(Double.parseDouble(str[3]));
				student.setAge(Integer.parseInt(str[4]));
				student.setFaculty(str[5]);
				student.setCourse(Integer.parseInt(str[6]));
				student.setStudentID(Integer.parseInt(str[7]));
				group[i] = student;
			}
		}
		System.out.println("Group is loaded from a file!");
	}

	@Override
	public String toString() {
		String output = "Group: \n";
		for (Student student : group) {
			output += student + "\n";
		}
		return output;
	}

}
