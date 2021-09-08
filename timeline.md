Timeline POS 

# [OVERALL FITUR](#overall-fitur)
- Dashboard
- Master Data
- Pembelian
- Penjualan
- Gudang
- Hutang
- Piutang
- Akuntansi
- Laporan
- User
- Pengaturan

# [FRONTEND](#frontend)
- Login [SUDAH]

- Dashboard

- Master Data

    - Produk
        - Lihat List [SUDAH]
        - Tambah Produk [SUDAH]    
        - Update Produk [BELUM]
        - Hapus Produk [BELUM]
    - Kategori
        - Lihat List [SUDAH]
        - Tambah Produk [SUDAH]    
        - Update Produk [BELUM]
        - Hapus Produk [BELUM]
    - Merk
        - Lihat List [SUDAH]
        - Tambah Produk [SUDAH]    
        - Update Produk [BELUM]
        - Hapus Produk [BELUM]
    - Satuan
        - Lihat List [SUDAH]
        - Tambah Produk [SUDAH]    
        - Update Produk [BELUM]
        - Hapus Produk [BELUM]
    - Gudang
        - Lihat List [SUDAH]
        - Tambah Produk [SUDAH]    
        - Update Produk [BELUM]
        - Hapus Produk [BELUM]
    - Karyawan
        - Lihat List [SUDAH]
        - Tambah Produk [SUDAH]    
        - Update Produk [BELUM]
        - Hapus Produk [BELUM]
    - Customer
        - Lihat List [SUDAH]
        - Tambah Produk [SUDAH]    
        - Update Produk [BELUM]
        - Hapus Produk [BELUM]
    - Supplier
        - Lihat List [SUDAH]
        - Tambah Produk [SUDAH]    
        - Update Produk [BELUM]
        - Hapus Produk [BELUM]

- Penjualan

    - Pesanan Penjualan

        - List Pesanan Penjualan [IN PROGRESS]
        - Tambah Pesanan Penjualan [IN PROGRESS]
        - Update Pesanan Penjualan(DRAFT) [BELUM]
        - Lihat Detail Pesanan Penjualan [BELUM]
            - Print [BELUM]
            - Update Status [BELUM]
        - Hapus Pesanan Penjualan(HAPUS/VOID) [BELUM]

    - Penjualan

        - List Penjualan [IN PROGRESS]
        - Tambah Penjualan [BELUM]
        - Lihat Detail Pesanan Penjualan [BELUM]
            - Print Faktur [BELUM]
            - Mencatat cicilan(KREDIT) [BELUM]
        - Tambah Pelunasan Piutang Penjualan (KREDIT) [BELUM]
        - Hapus Penjualan(HAPUS/VOID) [BELUM]

    - Retur Penjualan

        - List Retur Penjualan [BELUM]
        - Tambah Retur Penjualan [BELUM]
        - Lihat Detail Penjualan [BELUM]
            - Print [BELUM]
        - Hapus Return Penjualan [BELUM]


- Pembelian

    - Pesanan Pembelian

        - List Pesanan Pembelian [SUDAH]
        - Tambah Pesanan Pembelian [SUDAH]
        - Update Pesanan Pembelian(DRAFT) [SUDAH]
        - Lihat Detail Pesanan Pembelian [IN PROGRESS]
            - Print [BELUM]
            - Request Approval (update status) [SUDAH]
            - Approve (update status) [SUDAH]
            - Reject (update status) [SUDAH]
            - hapus/void (update status) [BELUM]
        - Hapus Pesanan Pembelian(HAPUS/VOID) [BELUM]

    - Pembelian

        - Lihat Pembelian [SUDAH]
        - Tambah Pembelian [SUDAH]
        - Lihat Detail Pembelian [SUDAH]
            - Tambah Pelunasan Hutang Pembelian(mencatat cicilan) (KREDIT) [BELUM]
        - Hapus Pembelian(HAPUS/VOID) [BELUM]

    - Retur Pembelian

        - List Retur Pembelian [BELUM]
        - Tambah Retur Pembelian [BELUM]
        - Lihat Detail Pembelian [BELUM]
        - Hapus Retur Pembelian [BELUM]

- Inventory/Gudang

    - Lihat Gudang [SUDAH]

        - Lihat Stok Produk [SUDAH]

            - Lihat Kartu Stok Produk [IN PROGRESS]



- Akuntansi

    - Kode Akun Akuntansi (COA)

        - List Kode Akun [SUDAH]
        - Tambah Kode Akun [IN PROGRESS]
        - Update Kode Akun [BELUM]
        - Hapus Kode Akun [BELUM]

    - Jurnal [BELUM]
        - Jurnal Umum ? [BELUM]
        - Jurnal Penyesuaian [BELUM]

            - Lihat Jurnal Penyesuaian [BELUM]
            - Tambah Jurnal Penyesuaian [BELUM]
    
    - Neraca ? [BELUM]

    - Buku Besar ? [BELUM]

    - Laporan Keuangan
        - Laporan neraca [BELUM]
        - Laporan laba rugi [BELUM]
        - Laporan perubahan modal [BELUM]
        - Laporan catatan atas laporan keuangan [BELUM]
        - Laporan arus kas [BELUM]

- Kas & Bank ? 
    - Penerimaan Kas [BELUM]
    - Pengeluaran Kas [BELUM]

- Piutang
    - Lihat Daftar Piutang [BELUM]
    - Tambah Pelunasan Piutang [BELUM]

- Hutang
    - Lihat Daftar Hutang [BELUM]
    - Tambah Pelunasan Hutang [BELUM]

- User
    - Managemen Role dan Permission [BELUM]

- Pengaturan
    - Pengaturan Akuntasi
        - Pengaturan Kode Akun
            - Pengaturan Kode Akun Penjualan [IN PROGRESS]
            - Pengaturan Kode Akun Pembelian [IN PROGRESS]
            - Pengaturan Kode akun lainnya [IN PROGRESS]

    - Pengaturan Data Perusahaan [BELUM]

# [BACKEND](#backend)

- API
    - Auth
        - Login [SUDAH]
        - Refresh Token [SUDASH]

    - Product
        - Get Paginate List [SUDAH]
        - Get One Product [SUDAH]
        - Create One Product [SUDAH]
        - Update One Product [SUDAH]
        - Delete One Product [SUDAH]

    - Brand
        - Get Paginate List [SUDAH]
        - Get One [SUDAH]
        - Create One [SUDAH]
        - Update One [SUDAH]
        - Delete One [SUDAH]

    - Category
        - Get Paginate List [SUDAH]
        - Get One [SUDAH]
        - Create One [SUDAH]
        - Update One [SUDAH]
        - Delete One [SUDAH]

    - Unit
        - Get Paginate List [SUDAH]
        - Get List [SUDAH]
        - Get One [SUDAH]
        - Create One [SUDAH]
        - Update One [SUDAH]
        - Delete One [SUDAH]

    - Warehouse
        - Get Paginate List [SUDAH]
        - Get List [SUDAH]
        - Get One [SUDAH]
        - Create One [SUDAH]
        - Update One [SUDAH]
        - Delete One [SUDAH]
        - Get One Warehouse With Paginate List Product Stock [SUDAH]
        - Get One Warehouse With One Product Stock [SUDAH]

    - Employee
        - Get Paginate List [SUDAH]
        - Get One [SUDAH]
        - Create One [SUDAH]
        - Update One [SUDAH]
        - Delete One [SUDAH]

    - Customer
        - Get Paginate List [SUDAH]
        - Get One [SUDAH]
        - Create One [SUDAH]
        - Update One [SUDAH]
        - Delete One [SUDAH]

    - Supplier
        - Get Paginate List [SUDAH]
        - Get One [SUDAH]
        - Create One [SUDAH]
        - Update One [SUDAH]
        - Delete One [SUDAH]

    - Purchase Order
        - Get Paginate List [SUDAH]
        - Create One [SUDAH]
        - Update One (General) [IN PROGRESS]
        - Update Purchase Order Status [SUDAH]
        - Delete One [BELUM]

    - Purchase
        - Get Paginate List [SUDAH]
        - Get One [SUDAH]
        - Create One [SUDAH]
        - Delete One (VOID) [BELUM]

    - Purchase Return
        - Get Paginate List [BELUM]
        - Get One [BELUM]
        - Create One [BELUM]
        - Update One [BELUM]
        - Delete One [BELUM]

    - Sale Order
        - Get Paginate List [BELUM]
        - Get One [BELUM]
        - Create One [SUDAH]
        - Update One (General) [BELUM]
        - Update Sale Order Status [BELUM]
        - Delete One [BELUM]

    - Sale
        - Get Paginate List [BELUM]
        - Get One [BELUM]
        - Create One [BELUM]
        - Delete One (VOID) [BELUM]

    - Sale Return
        - Get Paginate List [BELUM]
        - Get One [BELUM]
        - Create One [BELUM]
        - Update One [BELUM]
        - Delete One [BELUM]

    - Product Stock
        - Get Paginate List [SUDAH]
        - Get One [SUDAH]
        - Create One [BELUM]
        - Update One [BELUM]
        - Delete One [BELUM]
    
    - Role
        - List Role [SUDAH]
        - Create Role [SUDAH]
        - Delete Role [BELUM]
        - Update Role / Assign Permission To Role [SUDAH]

    - User
        - Assign Role To User [BELUM]

    - Report
        - Accounting Report
            - Financial Report [BELUM]
                - Get Data Laporan Neraca [BELUM]
                - Get Data Laporan Laba Rugi [BELUM]
                - Get Data Laporan Perubahan Modal [BELUM]
                - Get Data Laporan Catatan Atas Laporan Keuangan [BELUM]
                - Get Data Laporan Arus Kas [BELUM]
            - Get Data Laporan Penjualan [BELUM]
            - Get Data Laporan Pembelian [BELUM]

    