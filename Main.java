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