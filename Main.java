import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tree organizationTree = null;
        Queue taskQueue = new Queue();
        Stack historyStack = new Stack();  // Menambahkan stack untuk riwayat tugas
        boolean exit = false;

        while (!exit) {
            System.out.println("\n# Struktur Organisasi Perusahaan #");
            System.out.println("1. Memasukkan organisasi perusahaan");
            System.out.println("2. Memasukkan jumlah staf di divisi");
            System.out.println("3. Menampilkan struktur organisasi");
            System.out.println("4. Memasukkan jumlah antrian");
            System.out.println("5. Riwayat tugas");
            System.out.println("6. Sorting berdasarkan ID");
            System.out.println("7. Pencarian data staf");
            System.out.println("8. Exit");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Membersihkan karakter newline yang tersisa

            switch (choice) {
                case 1:
                    // Memasukkan organisasi perusahaan
                    System.out.print("Masukkan nama divisi utama: ");
                    String rootDivision = scanner.nextLine();
                    organizationTree = new Tree(rootDivision);

                    System.out.print("Masukkan nama divisi kiri: ");
                    organizationTree.addLeft(scanner.nextLine());

                    System.out.print("Masukkan nama divisi tengah: ");
                    organizationTree.addMiddle(scanner.nextLine());

                    System.out.print("Masukkan nama divisi kanan: ");
                    organizationTree.addRight(scanner.nextLine());
                    break;

                case 2:
                    if (organizationTree == null) {
                        System.out.println("Silakan masukkan organisasi terlebih dahulu (pilih opsi 1).\n");
                        break;
                    }

                    System.out.print("Masukkan jumlah staf untuk setiap divisi: ");
                    int staffCount = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Masukkan staf untuk divisi " + organizationTree.root.left.division);
                    addStaffToDivision(organizationTree.root.left, staffCount, scanner);

                    System.out.println("Masukkan staf untuk divisi " + organizationTree.root.middle.division);
                    addStaffToDivision(organizationTree.root.middle, staffCount, scanner);

                    System.out.println("Masukkan staf untuk divisi " + organizationTree.root.right.division);
                    addStaffToDivision(organizationTree.root.right, staffCount, scanner);
                    break;

                case 3:
                    if (organizationTree == null) {
                        System.out.println("Organisasi belum dimasukkan.");
                    } else {
                        System.out.println("\nStruktur Organisasi:");
                        organizationTree.traverse();
                    }
                    break;

                case 4:
                    if (organizationTree == null) {
                        System.out.println("Silakan masukkan organisasi terlebih dahulu (pilih opsi 1).\n");
                        break;
                    }

                    System.out.print("Masukkan jumlah tugas untuk antrian: ");
                    int queueCount = scanner.nextInt();
                    scanner.nextLine();  

                    for (int i = 0; i < queueCount; i++) {
                        System.out.print("Nama tugas: ");
                        String taskName = scanner.nextLine();

                        System.out.println("Pilih staf untuk tugas ini:");
                        organizationTree.root.left.staffList.display();
                        organizationTree.root.middle.staffList.display();
                        organizationTree.root.right.staffList.display();

                        System.out.print("Masukkan nama staf yang dituju: ");
                        String targetStaffName = scanner.nextLine();

                        Node targetStaff = organizationTree.root.left.staffList.linearSearch(targetStaffName);
                        if (targetStaff == null) {
                            targetStaff = organizationTree.root.middle.staffList.linearSearch(targetStaffName);
                        }
                        if (targetStaff == null) {
                            targetStaff = organizationTree.root.right.staffList.linearSearch(targetStaffName);
                        }

                        if (targetStaff != null) {
                            String taskWithStaff = taskName + " (Ditugaskan ke: " + targetStaff.name + ")";
                            taskQueue.enqueue(new Node(taskWithStaff, 0, ""));
                            System.out.println("Tugas '" + taskName + "' berhasil ditambahkan ke staf " + targetStaff.name);
                        } else {
                            System.out.println("Staf tidak ditemukan. Tugas ini diabaikan.");
                        }
                    }

                    System.out.println("\nDaftar tugas yang telah ditambahkan ke antrian:");
                    taskQueue.display();
                    break;

                case 5:
                    if (taskQueue.isEmpty()) {
                        System.out.println("Tidak ada tugas yang sedang antri.");
                    } else {
                        System.out.println("\nDaftar tugas yang ada di antrian:");
                        taskQueue.display();
                
                        System.out.print("Pilih tugas yang telah selesai: ");
                        String completedTaskName = scanner.nextLine();
        
                        Node completedTask = null;
                        Node temp = taskQueue.front;
                
                        while (temp != null) {
                            if (temp.name.contains(completedTaskName)) {
                                completedTask = temp;
                                break;
                            }
                            temp = temp.next;
                        }
                
                        if (completedTask != null) {
                            
                            taskQueue.dequeue();  
                            historyStack.push(completedTask);  
                            System.out.println("Tugas: " + completedTask.name + " telah selesai dikerjakan.");
                        } else {
                            System.out.println("Tugas tidak ditemukan.");
                        }
                    }
                    break;
                    
                case 6:
                    
                    if (organizationTree == null) {
                        System.out.println("Organisasi belum dimasukkan.");
                        break;
                    }
                    System.out.println("\nData Staff Setelah Sorting Berdasarkan ID:");
                    sortAndDisplayStaffById(organizationTree);
                    break;

                case 7:
                    if (organizationTree == null) {
                        System.out.println("Organisasi belum dimasukkan.");
                        break;
                    }
                    System.out.print("Masukkan nama staf untuk mencari: ");
                    String searchName = scanner.nextLine();
                    searchStaff(organizationTree, searchName);
                    break;

                case 8:
                    exit = true;
                    System.out.println("Program selesai. Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
        scanner.close();
    }

    private static void addStaffToDivision(TreeNode divisionNode, int staffCount, Scanner scanner) {
        for (int i = 0; i < staffCount; i++) {
            System.out.print("Nama staf: ");
            String name = scanner.nextLine();

            System.out.print("ID staf: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Posisi staf: ");
            String position = scanner.nextLine();

            divisionNode.staffList.insertLast(new Node(name, id, position));
        }
    }

    private static void sortAndDisplayStaffById(Tree organizationTree) {
        System.out.println("Data Staff Sebelum Sorting:");
        organizationTree.root.left.staffList.display();
        organizationTree.root.middle.staffList.display();
        organizationTree.root.right.staffList.display();

        organizationTree.root.left.staffList.bubbleSortById();
        organizationTree.root.middle.staffList.bubbleSortById();
        organizationTree.root.right.staffList.bubbleSortById();

        System.out.println("\nData Staff Setelah Sorting Berdasarkan ID:");
        organizationTree.root.left.staffList.display();
        organizationTree.root.middle.staffList.display();
        organizationTree.root.right.staffList.display();
    }    


                    

                    