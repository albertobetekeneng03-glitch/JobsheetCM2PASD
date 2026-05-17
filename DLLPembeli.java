package JobsheetCM2;
public class DLLPembeli {
    NodePembeli head;
    NodePembeli tail;
    int nomor = 1;

    public boolean isEmpty() {
        return head == null;
    }

    public void tambahAntrian(String nama, String hp) {
        Pembeli pb = new Pembeli(nomor++, nama, hp);
        NodePembeli newNode = new NodePembeli(null, pb, null);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        System.out.println("Pembeli masuk antrean!");
    }

    public void cetakAntrian() {
        if (isEmpty()) {
            System.out.println("Antrean kosong");
            return;
        }

        NodePembeli current = head;

        System.out.println("========================================");
        System.out.println("Daftar Antrean Pembeli");
        System.out.println("========================================");
        System.out.printf("%-10s %-20s %-15s\n", "Antrian", "Nama", "No HP");

        while (current != null) {
            System.out.printf("%-10d %-20s %-15s\n",
                    current.data.noAntrian,
                    current.data.namaPembeli,
                    current.data.noHp);

            current = current.next;
        }
    }

    public Pembeli hapusAntrian() {
        if (isEmpty()) {
            System.out.println("Antrean kosong!");
            return null;
        }

        Pembeli data = head.data;

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        return data;
    }
}