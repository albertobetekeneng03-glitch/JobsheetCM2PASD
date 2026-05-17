package JobsheetCM2;
public class DLLPesanan {
    NodePesanan head;
    NodePesanan tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void tambahPesanan(int kode, String namaPesanan, int harga, String namaPembeli) {
        Pesanan ps = new Pesanan(kode, namaPesanan, harga, namaPembeli);
        NodePesanan newNode = new NodePesanan(null, ps, null);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        System.out.println("Pesanan berhasil ditambahkan!");
    }

    public void sortPesanan() {
        if (head == null) {
            return;
        }

        boolean tukar;

        do {
            tukar = false;
            NodePesanan current = head;

            while (current.next != null) {
                String nama1 = current.data.namaPesanan.toLowerCase();
                String nama2 = current.next.data.namaPesanan.toLowerCase();

                if (nama1.compareTo(nama2) > 0) {
                    Pesanan temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;

                    tukar = true;
                }

                current = current.next;
            }

        } while (tukar);
    }

    public void tampilPesanan() {
        if (isEmpty()) {
            System.out.println("Belum ada pesanan");
            return;
        }

        sortPesanan();

        NodePesanan current = head;
        int total = 0;

        System.out.println("============================================================");
        System.out.println("Laporan Pesanan");
        System.out.println("============================================================");

        System.out.printf("%-10s %-20s %-15s %-10s\n",
                "Kode",
                "Menu",
                "Pembeli",
                "Harga");

        while (current != null) {
            System.out.printf("%-10d %-20s %-15s %-10d\n",
                    current.data.kodePesanan,
                    current.data.namaPesanan,
                    current.data.namaPembeli,
                    current.data.harga);

            total += current.data.harga;
            current = current.next;
        }

        System.out.println("============================================================");
        System.out.println("Total Pendapatan : Rp " + total);
    }
}