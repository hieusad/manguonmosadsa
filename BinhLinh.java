import java.util.InputMismatchException;
import java.util.Scanner;

public class BinhLinh {
    protected String TenLinh;
    protected double SucManh = 50;
    protected boolean TrangBi;
    private Scanner sc = new Scanner(System.in);

    public BinhLinh() {}

    public BinhLinh(String tl, double sm, boolean tb) {
        TenLinh = tl;
        SucManh = sm;
        TrangBi = tb;
    }

    public String getTenLinh() {
        return TenLinh;
    }

    public void setTenLinh(String tenLinh) {
        TenLinh = tenLinh;
    }

    public double getSucManh() {
        return SucManh;
    }

    public void setSucManh(double sucManh) {
        SucManh = sucManh;
    }

    public boolean isTrangBi() {
        return TrangBi;
    }

    public void setTrangBi() {
        if (CapTrangBi() == 1) {
            TrangBi = true;
        } else {
            TrangBi = false;
        }
    }

    public int CapTrangBi() {
        int n = 0;
        boolean flag = false;
        while (!flag) {
            try {
                System.out.println("Có cung cấp trang bị cho nhân vật của bạn không?");
                System.out.println("Nhập 1 nếu có, Nhập 2 nếu không: ");
                n = sc.nextInt();
                if (n != 1 && n != 2) {
                    System.out.println("Nhập sai khoảng giá trị! Mời nhập lại: ");
                } else {
                    flag = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Nhập sai định dạng giá trị! Mời nhập lại: ");
                sc.nextLine();
            }
        }
        return n;
    }

    public int ChonNhanVat() {
        System.out.println("Chọn nhân vật của bạn!");
        System.out.println("Nhập 1 nếu chọn Lính, Nhập 2 nếu chọn Cung Thủ, Nhập 3 nếu chọn Kiếm Sĩ, Nhập 4 nếu chọn Đấu Sĩ: ");
        int n = 0;
        boolean flag = false;
        while (!flag) {
            try {
                n = sc.nextInt();
                if (n != 1 && n != 2 && n != 3 && n != 4) {
                    System.out.println("Thông tin nhập không hợp lệ! Mời nhập lại: ");
                } else {
                    flag = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Lỗi định dạng nhập liệu! Mời nhập lại: ");
                sc.nextLine();
            }
        }
        return n;
    }

    private void TinhSucManh() {
        double baseSM = getSucManh();
        if (isTrangBi()) {
            if (this instanceof Linh) {
                setSucManh(baseSM * 1.1);
            } else if (this instanceof CungThu) {
                setSucManh(baseSM * 1.3);
            } else if (this instanceof Kiem_Si) {
                setSucManh(baseSM * 1.5);
            } else if (this instanceof DauSi) {
                setSucManh(baseSM * 1.7);
            }
        }
    }

    public void InThongTin() {
        TinhSucManh(); // Tính lại sức mạnh trước khi in thông tin
        System.out.println(TenLinh + " có chỉ số sức mạnh " + getSucManh());
    }

    public static String ChienDau(BinhLinh bl1, BinhLinh bl2) {
        bl1.TinhSucManh();
        bl2.TinhSucManh();
        double sm1 = bl1.getSucManh();
        double sm2 = bl2.getSucManh();
        if (sm1 > sm2) {
            return bl1.getTenLinh() + " thắng!";
        } else if (sm1 < sm2) {
            return bl2.getTenLinh() + " thắng!";
        } else {
            return "Hòa!";
        }
    }

    public static void main(String[] args) {
        BinhLinh linh = new Linh("Lính", 50, true);
        BinhLinh cungThu = new CungThu("Cung Thủ", 50, true);
        BinhLinh kiemSi = new Kiem_Si("Kiếm Sĩ", 50, true);
        BinhLinh dauSi = new DauSi("Đấu Sĩ", 50, true);

        linh.InThongTin();
        cungThu.InThongTin();
        kiemSi.InThongTin();
        dauSi.InThongTin();

        System.out.println(ChienDau(linh, cungThu));
        System.out.println(ChienDau(kiemSi, dauSi));
        System.out.println(ChienDau(linh, dauSi));
    }
}

class Linh extends BinhLinh {
    public Linh(String ten, double sucManh, boolean trangBi) {
        super(ten, sucManh, trangBi);
    }
}

class CungThu extends BinhLinh {
    public CungThu(String ten, double sucManh, boolean trangBi) {
        super(ten, sucManh, trangBi);
    }
}

class Kiem_Si extends BinhLinh {
    public Kiem_Si(String ten, double sucManh, boolean trangBi) {
        super(ten, sucManh, trangBi);
    }
}

class DauSi extends BinhLinh {
    public DauSi(String ten, double sucManh, boolean trangBi) {
        super(ten, sucManh, trangBi);
    }
}
