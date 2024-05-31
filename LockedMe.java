
public class LockedMe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		import java.io.File;
		import java.util.Arrays;
		import java.util.Scanner;

		public class LockedMeApp {
		    private static final String ROOT_DIR = "root";
		    private static Scanner scanner = new Scanner(System.in);

		    public static void main(String[] args) {
		        showWelcomeScreen();
		        while (true) {
		            showMainMenu();
		        }
		    }

		    private static void showWelcomeScreen() {
		        System.out.println("Welcome to LockedMe.com");
		        System.out.println("Developer: Your Name");
		        System.out.println("----------------------");
		    }

		    private static void showMainMenu() {
		        System.out.println("Main Menu:");
		        System.out.println("1. List files in ascending order");
		        System.out.println("2. File operations");
		        System.out.println("3. Exit application");
		        System.out.print("Enter your choice: ");
		        String choice = scanner.nextLine();
		        switch (choice) {
		            case "1":
		                listFiles();
		                break;
		            case "2":
		                showFileOperationsMenu();
		                break;
		            case "3":
		                System.out.println("Exiting application.");
		                System.exit(0);
		            default:
		                System.out.println("Invalid input. Please try again.");
		        }
		    }

		    private static void listFiles() {
		        File dir = new File(ROOT_DIR);
		        if (!dir.exists()) {
		            dir.mkdirs();
		        }
		        String[] files = dir.list();
		        if (files != null && files.length > 0) {
		            Arrays.sort(files);
		            System.out.println("Files in ascending order:");
		            for (String file : files) {
		                System.out.println(file);
		            }
		        } else {
		            System.out.println("No files found in the directory.");
		        }
		    }

		    private static void showFileOperationsMenu() {
		        while (true) {
		            System.out.println("File Operations:");
		            System.out.println("1. Add a file");
		            System.out.println("2. Delete a file");
		            System.out.println("3. Search for a file");
		            System.out.println("4. Return to main menu");
		            System.out.print("Enter your choice: ");
		            String choice = scanner.nextLine();
		            switch (choice) {
		                case "1":
		                    addFile();
		                    break;
		                case "2":
		                    deleteFile();
		                    break;
		                case "3":
		                    searchFile();
		                    break;
		                case "4":
		                    return;
		                default:
		                    System.out.println("Invalid input. Please try again.");
		            }
		        }
		    }

		    private static void addFile() {
		        System.out.print("Enter the file name to add: ");
		        String fileName = scanner.nextLine();
		        File file = new File(ROOT_DIR + File.separator + fileName);
		        try {
		            if (file.createNewFile()) {
		                System.out.println("File added successfully.");
		            } else {
		                System.out.println("File already exists.");
		            }
		        } catch (IOException e) {
		            System.out.println("An error occurred while adding the file.");
		        }
		    }

		    private static void deleteFile() {
		        System.out.print("Enter the file name to delete: ");
		        String fileName = scanner.nextLine();
		        File file = new File(ROOT_DIR + File.separator + fileName);
		        if (file.exists()) {
		            if (file.delete()) {
		                System.out.println("File deleted successfully.");
		            } else {
		                System.out.println("Failed to delete the file.");
		            }
		        } else {
		            System.out.println("File not found.");
		        }
		    }

		    private static void searchFile() {
		        System.out.print("Enter the file name to search: ");
		        String fileName = scanner.nextLine();
		        File file = new File(ROOT_DIR + File.separator + fileName);
		        if (file.exists()) {
		            System.out.println("File found.");
		        } else {
		            System.out.println("File not found.");
		        }
		    }
		}


	}

}
