import java.util.Scanner;

public class Playlist {
    private String[] songs;
    private int top;
    private int size;

    public Playlist(int size) {
        songs = new String[size];
        top = -1;
        this.size = size;
    }

    public void display() {
        if (top == -1) {
            System.out.println("Playlist is empty.");
        } else {
            System.out.println("Playlist:");
            for (int i = top; i >= 0; i--) {
                System.out.println(songs[i]);
            }
        }
    }

    public void push(String song) {
        if (top == size - 1) {
            System.out.println("Playlist is full.");
        } else {
            top++;
            songs[top] = song;
            System.out.println(song + " added to playlist.");
        }
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Playlist is empty.");
        } else {
            String song = songs[top];
            top--;
            System.out.println(song + " removed from playlist.");
        }
    }

    public void insertAt(int index, String song) {
        if (top == size - 1) {
            System.out.println("Playlist is full.");
        } else if (index < 0 || index > top + 1) {
            System.out.println("Invalid index.");
        } else {
            top++;
            for (int i = top; i > index; i--) {
                songs[i] = songs[i - 1];
            }
            songs[index] = song;
            System.out.println(song + " added to playlist at index " + index + ".");
        }
    }

    public void deleteAt(int index) {
        if (top == -1) {
            System.out.println("Playlist is empty.");
        } else if (index < 0 || index > top) {
            System.out.println("Invalid index.");
        } else {
            String song = songs[index];
            for (int i = index; i < top; i++) {
                songs[i] = songs[i + 1];
            }
            top--;
            System.out.println(song + " removed from playlist at index " + index + ".");
        }
    }

    public void clear() {
        top = -1;
        System.out.println("Playlist cleared.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter playlist size: ");
        int size = scanner.nextInt();
        Playlist playlist = new Playlist(size);
        int choice;
        do {
            System.out.println("1. Display playlist");
            System.out.println("2. Add song to playlist");
            System.out.println("3. Remove song from playlist");
            System.out.println("4. Add song to playlist at index");
            System.out.println("5. Remove song from playlist at index");
            System.out.println("6. Clear playlist");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    playlist.display();
                    break;
                case 2:
                    System.out.print("Enter song name: ");
                    scanner.nextLine();
                    String song = scanner.nextLine();
                    playlist.push(song);
                    break;
                case 3:
                    playlist.pop();
                    break;
                case 4:
                    System.out.print("Enter index: ");
                    int index = scanner.nextInt();
                    System.out.print("Enter song name: ");
                    scanner.nextLine();
                    song = scanner.nextLine();
                    playlist.insertAt(index, song);
                    break;
                case 5:
                    System.out.print("Enter index: ");
                    index = scanner.nextInt();
                    playlist.deleteAt(index);
                    break;
                case 6:
                    playlist.clear();
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
        scanner.close();
    }
}